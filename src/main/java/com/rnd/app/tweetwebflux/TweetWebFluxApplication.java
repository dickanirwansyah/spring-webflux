package com.rnd.app.tweetwebflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class TweetWebFluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(TweetWebFluxApplication.class, args);
	}

}
