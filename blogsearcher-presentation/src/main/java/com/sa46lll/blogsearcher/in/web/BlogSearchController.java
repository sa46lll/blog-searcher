package com.sa46lll.blogsearcher.in.web;

import com.sa46lll.blogsearcher.dto.BlogSearchResponse;
import com.sa46lll.blogsearcher.dto.ApiResponse;
import com.sa46lll.blogsearcher.port.in.BlogSearchUseCase;
import jakarta.websocket.server.PathParam;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/search")
public class BlogSearchController {

    private final BlogSearchUseCase blogSearchUsecase;

    public BlogSearchController(final BlogSearchUseCase blogSearchUsecase) {
        this.blogSearchUsecase = blogSearchUsecase;
    }

    @GetMapping
    public ApiResponse<List<BlogSearchResponse>> search(@RequestHeader(value = "X-USER-ID", defaultValue = "1") final Long userId,
                                                        @PathParam("keyword") String keyword) {
        return ApiResponse.ok(blogSearchUsecase.search(keyword));
    }
}
