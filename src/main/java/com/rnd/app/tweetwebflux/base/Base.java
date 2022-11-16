package com.rnd.app.tweetwebflux.base;

import reactor.core.publisher.Mono;

public interface Base <RESPONSE extends BaseResponse, REQUEST extends BaseRequest>{

    Mono<RESPONSE> execute(REQUEST request);
}
