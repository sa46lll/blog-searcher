package com.sa46lll.blogsearcher.service;

import com.sa46lll.blogsearcher.dto.BlogSearchResponse;
import com.sa46lll.blogsearcher.port.in.BlogSearchUseCase;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BlogSearchService implements BlogSearchUseCase {

    @Override
    public List<BlogSearchResponse> search(String keyword) {
        return List.of(new BlogSearchResponse(1L, "title"));
    }
}
