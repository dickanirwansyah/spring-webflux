package com.rnd.app.tweetwebflux.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rnd.app.tweetwebflux.base.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "account")
public class Account extends BaseRequest {

    @Id
    private String id;
    private String fullName;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    private String address;
    private String phoneNumber;
    private String email;
    private String username;
    private String password;
    private List<Role> roles;
    private Integer deleted;
    /** active & non active **/
    private String status;
    private String activation;
}
