package com.sa46lll.blogsearcher.in.web;

import com.sa46lll.blogsearcher.dto.ApiResponse;
import com.sa46lll.blogsearcher.dto.GetPopularKeywordResponse;
import com.sa46lll.blogsearcher.port.in.GetCachedPopularKeywordsUseCase;
import com.sa46lll.blogsearcher.port.in.GetPopularKeywordsUseCase;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PopularKeywordController {

    private final GetPopularKeywordsUseCase getPopularKeywordsUseCase;
    private final GetCachedPopularKeywordsUseCase getCachedPopularKeywordsUseCase;

    public PopularKeywordController(final GetPopularKeywordsUseCase getPopularKeywordsUseCase,
                                    final GetCachedPopularKeywordsUseCase getCachedPopularKeywordsUseCase) {
        this.getPopularKeywordsUseCase = getPopularKeywordsUseCase;
        this.getCachedPopularKeywordsUseCase = getCachedPopularKeywordsUseCase;
    }

    /**
     * 인기 키워드를 조회한다
     *
     * @return 인기 키워드 목록
     */
    @GetMapping("/v1/search/popular")
    public ApiResponse<List<GetPopularKeywordResponse>> getPopularKeywords() {
        return ApiResponse.ok(getPopularKeywordsUseCase.get());
    }

    @GetMapping("/v2/search/popular")
    public ApiResponse<List<GetPopularKeywordResponse>> getCachedPopularKeywords() {
        return ApiResponse.ok(getCachedPopularKeywordsUseCase.getCached());
    }
}
