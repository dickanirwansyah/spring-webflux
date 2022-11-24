package com.rnd.app.tweetwebflux.payload;

import com.rnd.app.tweetwebflux.base.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogRequest extends BaseRequest {
    private Object logs;
    private String status;
    private String accountId;
}
