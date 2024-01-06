package com.sa46lll.blogsearcher.adapter;

import com.sa46lll.blogsearcher.domain.SearchKeyword;
import com.sa46lll.blogsearcher.mapper.SearchKeywordMapper;
import com.sa46lll.blogsearcher.port.out.WriteSearchKeywordPersistencePort;
import com.sa46lll.blogsearcher.repository.SearchKeywordRepository;
import org.springframework.stereotype.Component;

@Component
public class WriteSearchKeywordPersistenceAdapter implements WriteSearchKeywordPersistencePort {

    private final SearchKeywordRepository searchKeywordRepository;

    public WriteSearchKeywordPersistenceAdapter(final SearchKeywordRepository searchKeywordRepository) {
        this.searchKeywordRepository = searchKeywordRepository;
    }

    @Override
    public void save(final SearchKeyword searchKeyword) {
        searchKeywordRepository.save(SearchKeywordMapper.toEntity(searchKeyword));
    }
}
