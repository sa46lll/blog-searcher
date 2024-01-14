package com.sa46lll.blogsearcher.repository;

import java.util.List;

public interface PopularKeywordCacheRepository {

    void save(final List<String> keywords);
}
