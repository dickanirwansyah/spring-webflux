package com.rnd.app.tweetwebflux.controller;

import com.rnd.app.tweetwebflux.exception.TweetNotFoundException;
import com.rnd.app.tweetwebflux.model.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@RestControllerAdvice
@Slf4j
public class GlobalErrorController {

    @ExceptionHandler(TweetNotFoundException.class)
    public ResponseEntity notFoundException(TweetNotFoundException ex){
        log.debug("handling exception={}",ex.getMessage());
        return new ResponseEntity(ServerResponse.notFound(ex.getMessage()),
                HttpStatus.NOT_FOUND);
    }

}
