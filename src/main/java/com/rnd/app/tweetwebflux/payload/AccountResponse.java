package com.rnd.app.tweetwebflux.payload;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.rnd.app.tweetwebflux.base.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountResponse extends BaseResponse {

    private String accountId;
    private String accountFullName;
    private Date accountDob;
    private String accountAddress;
    private String accountPhoneNumber;
    private String accountEmail;
    @JsonIgnore
    private String accountPassword;
    private String accountUsername;
    private List<String> roles;
    private Integer deleted;
    private String status;
    private String accountActivation;
}
