package com.sa46lll.blogsearcher.port.out;

import com.sa46lll.blogsearcher.domain.SearchKeyword;

public interface WriteSearchKeywordPersistencePort {

    void save(final SearchKeyword searchKeyword);
}
