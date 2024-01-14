package com.sa46lll.blogsearcher.adapter;

import com.sa46lll.blogsearcher.port.out.WritePopularKeywordCachePort;
import com.sa46lll.blogsearcher.repository.PopularKeywordCacheRepository;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class WritePopularKeywordCacheAdapter implements WritePopularKeywordCachePort {

    private final PopularKeywordCacheRepository popularKeywordCacheRepository;

    public WritePopularKeywordCacheAdapter(final PopularKeywordCacheRepository popularKeywordCacheRepository) {
        this.popularKeywordCacheRepository = popularKeywordCacheRepository;
    }

    @Override
    public void save(final List<String> sortedKeywords) {
        popularKeywordCacheRepository.save(sortedKeywords);
    }
}
