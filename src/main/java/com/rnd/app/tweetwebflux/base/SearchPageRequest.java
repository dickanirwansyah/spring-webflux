package com.rnd.app.tweetwebflux.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchPageRequest extends BaseRequest{
    private Pageable pageable;
}
