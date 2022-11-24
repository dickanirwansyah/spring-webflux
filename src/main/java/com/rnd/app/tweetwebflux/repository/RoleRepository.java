package com.rnd.app.tweetwebflux.repository;

import com.rnd.app.tweetwebflux.model.Role;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface RoleRepository extends ReactiveMongoRepository<Role, String> {

    @Query("{name:?0}")
    Mono<Role> getRoleByName(@Param("name")String name);
}
