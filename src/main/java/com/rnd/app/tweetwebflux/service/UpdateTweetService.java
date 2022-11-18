package com.rnd.app.tweetwebflux.service;

import com.alibaba.fastjson.JSON;
import com.rnd.app.tweetwebflux.base.Base;
import com.rnd.app.tweetwebflux.exception.TweetNotFoundException;
import com.rnd.app.tweetwebflux.payload.TweetRequest;
import com.rnd.app.tweetwebflux.payload.TweetResponse;
import com.rnd.app.tweetwebflux.repository.TweetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class UpdateTweetService implements Base<TweetResponse, TweetRequest> {

    @Autowired
    private TweetRepository tweetRepository;

    @Transactional
    @Override
    public Mono<TweetResponse> execute(TweetRequest request) {
        log.info("request update tweets={}", JSON.toJSONString(request));
        return tweetRepository.findById(request.getId())
                .switchIfEmpty(Mono.error(new TweetNotFoundException("sorry id "+request.getId()+" not found")))
                .flatMap(tweet -> {
                    log.info("id={}",tweet.getId());
                    tweet.setText(request.getTweet());
                    return tweetRepository.save(tweet)
                            .map(tweetData -> TweetResponse.builder()
                                    .id(tweetData.getId())
                                    .tweet(tweetData.getText())
                                    .createdAt(tweetData.getCreatedAt())
                                    .build());
                });
    }
}
