package com.sa46lll.blogsearcher.mapper;

import com.sa46lll.blogsearcher.domain.SearchHistory;
import com.sa46lll.blogsearcher.entity.SearchHistoryEntity;

public class SearchHistoryMapper {

    private SearchHistoryMapper() {
    }

    public static SearchHistoryEntity toEntity(final SearchHistory searchHistory) {
        return new SearchHistoryEntity(
                searchHistory.getKeyword(),
                searchHistory.getMemberId()
        );
    }

    public static SearchHistory toDomain(final SearchHistoryEntity searchHistoryEntity) {
        return new SearchHistory(
                searchHistoryEntity.getId(),
                searchHistoryEntity.getKeyword(),
                searchHistoryEntity.getMemberId()
        );
    }
}
