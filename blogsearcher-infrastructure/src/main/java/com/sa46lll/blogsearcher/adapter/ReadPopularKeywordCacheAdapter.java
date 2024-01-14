package com.sa46lll.blogsearcher.adapter;

import com.sa46lll.blogsearcher.domain.SearchKeyword;
import com.sa46lll.blogsearcher.port.out.ReadPopularKeywordCachePort;
import com.sa46lll.blogsearcher.repository.PopularKeywordCacheRepository;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ReadPopularKeywordCacheAdapter implements ReadPopularKeywordCachePort {

    private final PopularKeywordCacheRepository popularKeywordCacheRepository;

    public ReadPopularKeywordCacheAdapter(final PopularKeywordCacheRepository popularKeywordCacheRepository) {
        this.popularKeywordCacheRepository = popularKeywordCacheRepository;
    }

    @Override
    public List<SearchKeyword> getPopularKeywords() {
        return popularKeywordCacheRepository.findPopularKeywords();
    }
}
