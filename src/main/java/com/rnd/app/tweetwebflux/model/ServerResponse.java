package com.rnd.app.tweetwebflux.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerResponse {
    private Date timestamp;
    private Object data;
    private Integer status;
    private String message;

    public static ServerResponse ok(Object data){
        return ServerResponse.builder()
                .data(data)
                .status(HttpStatus.OK.value())
                .timestamp(new Date())
                .message("success")
                .build();
    }

    public static ServerResponse notFound(String message){
        return ServerResponse.builder()
                .data(null)
                .status(HttpStatus.NOT_FOUND.value())
                .timestamp(new Date())
                .message(message)
                .build();
    }
}
