package com.rnd.app.tweetwebflux.service.tweet;

import com.alibaba.fastjson.JSON;
import com.rnd.app.tweetwebflux.base.Base;
import com.rnd.app.tweetwebflux.model.Tweet;
import com.rnd.app.tweetwebflux.payload.TweetRequest;
import com.rnd.app.tweetwebflux.payload.TweetResponse;
import com.rnd.app.tweetwebflux.repository.TweetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.UUID;

@Slf4j
@Service
public class CreateTweetService implements Base<TweetResponse, TweetRequest> {

    @Autowired
    private TweetRepository tweetRepository;

    @Override
    public Mono<TweetResponse> execute(TweetRequest request) {
        log.info("request tweets={}", JSON.toJSONString(request));
        return tweetRepository.save(convertEntityToDto(request))
                .map(result -> convertDtoToEntity(result));
    }

    private Tweet convertEntityToDto(TweetRequest request){
        return Tweet.builder()
                .id(UUID.randomUUID().toString())
                .text(request.getTweet())
                .createdAt(new Date())
                .build();
    }

    private TweetResponse convertDtoToEntity(Tweet tweet){
        return TweetResponse.builder()
                .id(tweet.getId())
                .createdAt(tweet.getCreatedAt())
                .tweet(tweet.getText())
                .build();
    }
}
