package com.rnd.app.tweetwebflux.payload;

import com.rnd.app.tweetwebflux.base.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogResponse extends BaseResponse {

    private String log;
    private String status;
    private Date createdDate;
}
