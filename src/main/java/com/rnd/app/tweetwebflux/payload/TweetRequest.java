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
public class TweetRequest extends BaseRequest {
    /** if update id cannot be null**/
    private String id;
    private String tweet;
}
