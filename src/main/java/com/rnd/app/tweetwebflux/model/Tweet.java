package com.rnd.app.tweetwebflux.model;

import com.rnd.app.tweetwebflux.base.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "tweets")
public class Tweet extends BaseResponse {

    @Id
    private String id;
    private String text;
    /** created at auto generate **/
    private Date createdAt = new Date();
}
