package com.rnd.app.tweetwebflux.exception;

public class TweetNotFoundException extends RuntimeException{

    public TweetNotFoundException(String tweetId){
        super("tweet not found with id "+tweetId);
    }
}
