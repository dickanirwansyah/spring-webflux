package com.rnd.app.tweetwebflux.repository;

import com.rnd.app.tweetwebflux.model.Tweet;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends ReactiveMongoRepository<Tweet, String> {
}
