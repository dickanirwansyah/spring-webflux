package com.rnd.app.tweetwebflux.base;

import org.springframework.data.domain.Page;
import reactor.core.publisher.Mono;

public interface BasePageable <RESPONSE extends BaseResponse, REQUEST extends BaseRequest>{
    Mono<Page<RESPONSE>> execute(REQUEST request);
}
