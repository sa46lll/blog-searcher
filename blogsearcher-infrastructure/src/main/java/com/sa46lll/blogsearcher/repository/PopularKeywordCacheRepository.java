package com.sa46lll.blogsearcher.repository;

import com.sa46lll.blogsearcher.domain.SearchKeyword;
import java.util.List;

public interface PopularKeywordCacheRepository {

    void save(final List<String> keywords);

    List<SearchKeyword> findPopularKeywords();
}
