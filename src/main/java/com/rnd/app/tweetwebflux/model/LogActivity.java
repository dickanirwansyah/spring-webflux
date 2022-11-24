package com.rnd.app.tweetwebflux.model;

import com.rnd.app.tweetwebflux.base.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "log_activity")
public class LogActivity extends BaseResponse {
    @Id
    private String id;
    private String accountId;
    private String logs;
    private Date logDate;
    private String status;
}
