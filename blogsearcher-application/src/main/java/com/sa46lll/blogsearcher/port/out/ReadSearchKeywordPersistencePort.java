package com.sa46lll.blogsearcher.port.out;

import com.sa46lll.blogsearcher.domain.SearchKeyword;
import java.util.Optional;

public interface ReadSearchKeywordPersistencePort {

    Optional<SearchKeyword> findByKeyword(final String keyword);
}
