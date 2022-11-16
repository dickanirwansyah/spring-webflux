package com.rnd.app.tweetwebflux.controller;

import com.rnd.app.tweetwebflux.base.SearchPageRequest;
import com.rnd.app.tweetwebflux.model.Tweet;
import com.rnd.app.tweetwebflux.payload.TweetRequest;
import com.rnd.app.tweetwebflux.payload.TweetResponse;
import com.rnd.app.tweetwebflux.service.CreateTweetService;
import com.rnd.app.tweetwebflux.service.SearchTweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RequestMapping(value = "/api/tweet")
@RestController
public class TweetController {

    @Autowired
    private CreateTweetService createTweetService;
    @Autowired
    private SearchTweetService searchTweetService;

    @PostMapping(value = "/create")
    public Mono<TweetResponse> create(@RequestBody TweetRequest request){
        return createTweetService.execute(request);
    }

    @GetMapping(value = "/list")
    public Mono<Page<Tweet>> list(@RequestParam(value = "page", required = true)int page,
                                  @RequestParam(value = "size", required = true)int size){
        return searchTweetService.execute(SearchPageRequest.builder()
                        .pageable(PageRequest.of(page, size))
                .build());
    }
}
