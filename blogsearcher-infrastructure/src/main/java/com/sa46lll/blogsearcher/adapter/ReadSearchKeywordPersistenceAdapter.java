package com.sa46lll.blogsearcher.adapter;

import com.sa46lll.blogsearcher.domain.SearchKeyword;
import com.sa46lll.blogsearcher.mapper.SearchKeywordMapper;
import com.sa46lll.blogsearcher.port.out.ReadSearchKeywordPersistencePort;
import com.sa46lll.blogsearcher.repository.SearchKeywordRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class ReadSearchKeywordPersistenceAdapter implements ReadSearchKeywordPersistencePort {

    private final SearchKeywordRepository searchKeywordRepository;

    public ReadSearchKeywordPersistenceAdapter(final SearchKeywordRepository searchKeywordRepository) {
        this.searchKeywordRepository = searchKeywordRepository;
    }

    @Override
    public Optional<SearchKeyword> findByKeyword(String keyword) {
        return searchKeywordRepository.findByKeyword(keyword)
                .map(SearchKeywordMapper::toDomain);
    }

    @Override
    public List<SearchKeyword> getPopularKeywords() {
        return searchKeywordRepository.findTop10ByOrderByCountDesc().stream()
                .map(SearchKeywordMapper::toDomain)
                .toList();
    }
}
