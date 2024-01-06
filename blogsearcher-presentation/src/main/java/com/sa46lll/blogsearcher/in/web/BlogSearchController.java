package com.sa46lll.blogsearcher.in.web;

import com.sa46lll.blogsearcher.domain.Post;
import com.sa46lll.blogsearcher.dto.GetBlogSearchDto;
import com.sa46lll.blogsearcher.dto.ApiResponse;
import com.sa46lll.blogsearcher.dto.PageQuery;
import com.sa46lll.blogsearcher.dto.PageResponse;
import com.sa46lll.blogsearcher.port.in.GetBlogSearchUseCase;
import jakarta.websocket.server.PathParam;
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

    /**
     * 블로그를 검색한다
     *
     * @param memberId
     * @param keyword
     * @return 블로그 검색 결과
     */
    @GetMapping
    public ApiResponse<PageResponse<Post>> search(@RequestHeader(value = "X-USER-ID", defaultValue = "1") final Long memberId,
                                                  @PathParam("keyword") String keyword,
                                                  @PathParam("page") int page,
                                                  @PathParam("size") int size) {
        return ApiResponse.ok(
                getBlogSearchUsecase.search(
                        new GetBlogSearchDto(keyword, memberId),
                        new PageQuery(page, size)));
    }
}
