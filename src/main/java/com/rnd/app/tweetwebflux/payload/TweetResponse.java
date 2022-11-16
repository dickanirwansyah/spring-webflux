package com.rnd.app.tweetwebflux.payload;

import com.rnd.app.tweetwebflux.base.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TweetResponse extends BaseResponse {
    private String id;
    private String tweet;
    private Date createdAt;
}
