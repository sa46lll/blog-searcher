package com.sa46lll.blogsearcher.port.out;

import com.sa46lll.blogsearcher.domain.SearchHistory;

public interface WriteSearchHistoryPersistencePort {

    void save(final SearchHistory searchHistory);
}
