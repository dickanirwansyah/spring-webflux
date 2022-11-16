package com.rnd.app.tweetwebflux.base;

import com.rnd.app.tweetwebflux.model.Tweet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import reactor.core.publisher.Mono;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchPageResponse extends BaseResponse{
    private Mono<Page<Tweet>> monoPage;
}
