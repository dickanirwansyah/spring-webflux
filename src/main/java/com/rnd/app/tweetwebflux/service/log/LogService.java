package com.rnd.app.tweetwebflux.service.log;

import com.alibaba.fastjson.JSON;
import com.rnd.app.tweetwebflux.base.Base;
import com.rnd.app.tweetwebflux.model.LogActivity;
import com.rnd.app.tweetwebflux.payload.AccountRequest;
import com.rnd.app.tweetwebflux.payload.LogRequest;
import com.rnd.app.tweetwebflux.payload.LogResponse;
import com.rnd.app.tweetwebflux.repository.LogActivityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
public class LogService implements Base<LogResponse, LogRequest> {
    @Autowired
    private LogActivityRepository logActivityRepository;

    @Override
    public Mono<LogResponse> execute(LogRequest request) {
        log.info("request log={}", JSON.toJSONString(request));
        return logActivityRepository.save(LogActivity.builder()
                        .id(UUID.randomUUID().toString())
                        .logs(JSON.toJSONString(request.getLogs()))
                        .status(request.getStatus())
                        .logDate(new Date())
                        .accountId(request.getAccountId())
                        .build())
                .map(result -> LogResponse.builder()
                        .createdDate(result.getLogDate())
                        .log(result.getLogs())
                        .status(result.getStatus())
                        .build());
    }
}
