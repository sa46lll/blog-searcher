package com.sa46lll.blogsearcher.in.web;

import com.sa46lll.blogsearcher.dto.GetBlogSearchDto;
import com.sa46lll.blogsearcher.dto.GetBlogSearchResponse;
import com.sa46lll.blogsearcher.dto.ApiResponse;
import com.sa46lll.blogsearcher.port.in.GetBlogSearchUseCase;
import jakarta.websocket.server.PathParam;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/search")
public class BlogSearchController {

    private final GetBlogSearchUseCase getBlogSearchUsecase;

    public BlogSearchController(final GetBlogSearchUseCase getBlogSearchUsecase) {
        this.getBlogSearchUsecase = getBlogSearchUsecase;
    }

    @GetMapping
    public ApiResponse<List<GetBlogSearchResponse>> search(@RequestHeader(value = "X-USER-ID", defaultValue = "1") final Long memberId,
                                                           @PathParam("keyword") String keyword) {
        return ApiResponse.ok(
                getBlogSearchUsecase.search(new GetBlogSearchDto(keyword, memberId)));
    }
}
