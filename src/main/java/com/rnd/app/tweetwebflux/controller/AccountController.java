package com.rnd.app.tweetwebflux.controller;


import com.rnd.app.tweetwebflux.model.ServerResponse;
import com.rnd.app.tweetwebflux.payload.AccountRequest;
import com.rnd.app.tweetwebflux.service.account.CreateAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Date;

@RequestMapping(value = "/api/account")
@RestController
public class AccountController {

    @Autowired
    private CreateAccountService createAccountService;

    @PostMapping(value = "/create")
    public Mono<ServerResponse> create(@RequestBody AccountRequest request){
        return createAccountService.execute(request)
                .map(result -> ServerResponse.builder()
                        .data(result)
                        .message("success")
                        .status(HttpStatus.OK.value())
                        .timestamp(new Date())
                        .build());
    }
}
