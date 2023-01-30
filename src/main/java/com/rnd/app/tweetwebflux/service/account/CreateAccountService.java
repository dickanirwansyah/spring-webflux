package com.rnd.app.tweetwebflux.service.account;

import com.alibaba.fastjson.JSON;
import com.rnd.app.tweetwebflux.base.Base;
import com.rnd.app.tweetwebflux.model.Account;
import com.rnd.app.tweetwebflux.model.Role;
import com.rnd.app.tweetwebflux.payload.AccountRequest;
import com.rnd.app.tweetwebflux.payload.AccountResponse;
import com.rnd.app.tweetwebflux.payload.LogRequest;
import com.rnd.app.tweetwebflux.repository.AccountRepository;
import com.rnd.app.tweetwebflux.repository.RoleRepository;
import com.rnd.app.tweetwebflux.service.log.LogService;
import com.rnd.app.tweetwebflux.util.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CreateAccountService implements Base<AccountResponse, AccountRequest> {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private LogService logService;

    //save multiple models : https://stackoverflow.com/questions/47432973/webflux-mongo-save-multiple-models

    @Override
    public Mono<AccountResponse> execute(AccountRequest request) {
        log.info("create account={}", JSON.toJSONString(request));
        log.info("choose roles={}",request.getRoles());
        return logService.execute(LogRequest.builder()
                        .logs(request)
                        .accountId(request.getId())
                        .status(currentStatus("CREATED_ACCOUNT"))
                        .build())
                .then(accountRepository.save(accountConvertDtoToEntity(request))
                .flatMap(account -> accountRepository.findById(account.getId())))
                .map(this::accountEntityConvertToDto);
    }

    private String currentStatus(String status){
        return Arrays.stream(Constant.STATUS)
                .filter(data -> data.equals(status)).findFirst().get();
    }

    private AccountResponse accountEntityConvertToDto(Account account){
        return AccountResponse.builder()
                .accountId(account.getId())
                .accountDob(account.getDob())
                .accountActivation(account.getActivation())
                .accountAddress(account.getAddress())
                .accountUsername(account.getUsername())
                .accountFullName(account.getFullName())
                .accountEmail(account.getEmail())
                .status(account.getStatus())
                .deleted(account.getDeleted())
                .roles(account.getRoles().stream().map(Role::getName)
                        .collect(Collectors.toList()))
                .accountPhoneNumber(account.getPhoneNumber())
                .build();
    }

    private Account accountConvertDtoToEntity(AccountRequest request){
        return Account.builder()
                .id(UUID.randomUUID().toString())
                .email(request.getEmail())
                .dob(request.getDob())
                .roles(request.getRoles())
                .deleted(Constant.ACTIVE)
                .address(request.getAddress())
                .status(currentStatus("CREATED_ACCOUNT"))
                .phoneNumber(request.getPhoneNumber())
                .username(request.getUsername())
                .password(request.getPassword())
                .fullName(request.getFullName())
                .activation(Constant.getApproval.stream()
                        .filter(data -> data.equals(Constant.PENDING)).findFirst().get())
                .build();
    }

}
