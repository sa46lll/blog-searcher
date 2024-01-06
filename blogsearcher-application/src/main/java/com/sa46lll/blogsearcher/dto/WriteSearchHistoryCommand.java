package com.sa46lll.blogsearcher.dto;

import com.sa46lll.blogsearcher.domain.SearchHistory;

public record WriteSearchHistoryCommand(
        String keyword,
        Long memberId
) {

    public SearchHistory toDomain() {
        return new SearchHistory(
                this.keyword,
                this.memberId
        );
    }
}
