package com.rnd.app.tweetwebflux.repository;

import com.rnd.app.tweetwebflux.model.LogActivity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogActivityRepository extends ReactiveMongoRepository<LogActivity, String> {
}
