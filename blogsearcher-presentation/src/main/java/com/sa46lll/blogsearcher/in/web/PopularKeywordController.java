package com.sa46lll.blogsearcher.in.web;

import com.sa46lll.blogsearcher.dto.ApiResponse;
import com.sa46lll.blogsearcher.dto.GetPopularKeywordQuery;
import com.sa46lll.blogsearcher.dto.GetPopularKeywordResponse;
import com.sa46lll.blogsearcher.port.in.GetPopularKeywordsUseCase;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/search")
public class PopularKeywordController {

    private final GetPopularKeywordsUseCase getPopularKeywordsUseCase;

    public PopularKeywordController(final GetPopularKeywordsUseCase getPopularKeywordsUseCase) {
        this.getPopularKeywordsUseCase = getPopularKeywordsUseCase;
    }

    /**
     * 인기 키워드를 조회한다
     *
     * @return 인기 키워드 목록
     */
    @GetMapping("/popular")
    public ApiResponse<List<GetPopularKeywordResponse>> getPopularKeywords() {
        return ApiResponse.ok(getPopularKeywordsUseCase.getPopularKeywords());
    }
}
