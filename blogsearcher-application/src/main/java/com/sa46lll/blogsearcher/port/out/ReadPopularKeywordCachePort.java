package com.sa46lll.blogsearcher.port.out;

import com.sa46lll.blogsearcher.domain.SearchKeyword;
import java.util.List;

public interface ReadPopularKeywordCachePort {

    List<SearchKeyword> getPopularKeywords();
}
