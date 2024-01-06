package com.sa46lll.blogsearcher.dto;

import com.sa46lll.blogsearcher.domain.SearchKeyword;

public record GetPopularKeywordResponse(
        String keyword,
        int count
) {

    public static GetPopularKeywordResponse from(final SearchKeyword searchKeyword) {
        return new GetPopularKeywordResponse(
                searchKeyword.getKeyword(),
                searchKeyword.getCount()
        );
    }
}
