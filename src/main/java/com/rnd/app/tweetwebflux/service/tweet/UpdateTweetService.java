package com.rnd.app.tweetwebflux.service.tweet;

import com.alibaba.fastjson.JSON;
import com.rnd.app.tweetwebflux.base.Base;
import com.rnd.app.tweetwebflux.exception.TweetNotFoundException;
import com.rnd.app.tweetwebflux.payload.LogRequest;
import com.rnd.app.tweetwebflux.payload.TweetRequest;
import com.rnd.app.tweetwebflux.payload.TweetResponse;
import com.rnd.app.tweetwebflux.repository.TweetRepository;
import com.rnd.app.tweetwebflux.service.log.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class UpdateTweetService implements Base<TweetResponse, TweetRequest> {

    @Autowired
    private TweetRepository tweetRepository;
    @Autowired
    private LogService logService;

    @Override
    public Mono<TweetResponse> execute(TweetRequest request) {
        log.info("request update tweets={}", JSON.toJSONString(request));
        return tweetRepository.findById(request.getId())
                .switchIfEmpty(Mono.error(new TweetNotFoundException("sorry id "+request.getId()+" not found")))
                .flatMap(tweet -> {
                    log.info("id={}",tweet.getId());
                    tweet.setText(request.getTweet());
                    return logService.execute(LogRequest.builder()
                                    .logs(request)
                                    .accountId(request.getId())
                                    .status("UPDATED_TWEET")
                            .build()).then(tweetRepository.save(tweet))
                            .map(responseTweet -> TweetResponse
                                    .builder()
                                    .id(responseTweet.getId())
                                    .tweet(responseTweet.getText())
                                    .createdAt(responseTweet.getCreatedAt())
                                    .build());
                });
    }
}
