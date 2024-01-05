package com.sa46lll.blogsearcher.port.out;

import com.sa46lll.blogsearcher.SearchHistory;

public interface WriteBlogSearchPersistencePort {

    void save(final SearchHistory searchHistory);

    void updateSearchCount(Object any);
}
