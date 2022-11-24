package com.rnd.app.tweetwebflux.repository;

import com.rnd.app.tweetwebflux.model.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends ReactiveMongoRepository<Account, String> {
}
