package com.rnd.app.tweetwebflux.controller;

import com.rnd.app.tweetwebflux.base.SearchPageRequest;
import com.rnd.app.tweetwebflux.model.ServerResponse;
import com.rnd.app.tweetwebflux.payload.TweetRequest;
import com.rnd.app.tweetwebflux.service.CreateTweetService;
import com.rnd.app.tweetwebflux.service.SearchTweetService;
import com.rnd.app.tweetwebflux.service.UpdateTweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Date;


@RequestMapping(value = "/api/tweet")
@RestController
public class TweetController {

    @Autowired
    private CreateTweetService createTweetService;
    @Autowired
    private SearchTweetService searchTweetService;
    @Autowired
    private UpdateTweetService updateTweetService;

    @PostMapping(value = "/create")
    public Mono<ServerResponse> create(@RequestBody TweetRequest request){
        return createTweetService.execute(request)
                .map(result -> ServerResponse.builder()
                        .data(result)
                        .message("success")
                        .status(HttpStatus.OK.value())
                        .timestamp(new Date())
                        .build());
    }

    @GetMapping(value = "/custom-list")
    public Mono<ServerResponse> customListResponse(@RequestParam(value = "page", required = true)int page,
                                                   @RequestParam(value = "size", required = true)int size){

        return searchTweetService.execute(SearchPageRequest.builder()
                        .pageable(PageRequest.of(page, size))
                .build())
                .map(result -> ServerResponse.builder()
                        .timestamp(new Date())
                        .status(HttpStatus.OK.value())
                        .message("success")
                        .data(result)
                        .build());
    }

    @PutMapping(value = "/custom-update")
    public Mono<ServerResponse> customResponseUpdate(@RequestBody TweetRequest request){
        return updateTweetService.execute(request)
                .map(result -> ServerResponse.builder()
                        .data(result)
                        .message("success")
                        .status(HttpStatus.OK.value())
                        .timestamp(new Date())
                        .build());
    }

}
