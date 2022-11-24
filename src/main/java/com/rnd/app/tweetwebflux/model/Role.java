package com.rnd.app.tweetwebflux.model;

import com.rnd.app.tweetwebflux.base.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "role")
public class Role extends BaseResponse {
    @Id
    private String id;
    private String name;
    private Integer deleted;
}
