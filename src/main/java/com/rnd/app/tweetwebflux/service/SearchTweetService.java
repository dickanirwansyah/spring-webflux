package com.rnd.app.tweetwebflux.service;

import com.rnd.app.tweetwebflux.base.BasePageable;
import com.rnd.app.tweetwebflux.base.SearchPageRequest;
import com.rnd.app.tweetwebflux.model.Tweet;
import com.rnd.app.tweetwebflux.repository.TweetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import java.util.ArrayList;


@Slf4j
@Service
public class SearchTweetService implements BasePageable<Tweet, SearchPageRequest> {

    @Autowired
    private TweetRepository tweetRepository;

    private Mono<Page<Tweet>> getTweets(Pageable pageable){
        return tweetRepository.count()
                .flatMap(tweetCount -> this.tweetRepository.findAll(pageable.getSort())
                        .buffer(pageable.getPageSize(), (pageable.getPageNumber() + 1))
                        .elementAt(pageable.getPageNumber(), new ArrayList<>())
                        .map(tweets -> new PageImpl<>(tweets, pageable, tweetCount)));
    }

    @Override
    public Mono<Page<Tweet>> execute(SearchPageRequest request) {
        return getTweets(request.getPageable());
    }
}
