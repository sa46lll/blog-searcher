package com.sa46lll.blogsearcher.port.out;

import java.util.List;

public interface WritePopularKeywordCachePort {

    void save(final List<String> keywords);
}
