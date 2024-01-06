package com.sa46lll.blogsearcher.mapper;

import com.sa46lll.blogsearcher.domain.SearchKeyword;
import com.sa46lll.blogsearcher.entity.SearchKeywordEntity;

public class SearchKeywordMapper {

    private SearchKeywordMapper() {
    }

    public static SearchKeywordEntity toEntity(final SearchKeyword searchKeyword) {
        return new SearchKeywordEntity(searchKeyword.getId(), searchKeyword.getKeyword(), searchKeyword.getCount());
    }

    public static SearchKeyword toDomain(final SearchKeywordEntity searchKeywordEntity) {
        return new SearchKeyword(searchKeywordEntity.getId(), searchKeywordEntity.getKeyword(), searchKeywordEntity.getCount());
    }
}
