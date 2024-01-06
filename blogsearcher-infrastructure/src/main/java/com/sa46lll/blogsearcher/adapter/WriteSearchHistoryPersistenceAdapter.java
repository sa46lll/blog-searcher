package com.sa46lll.blogsearcher.adapter;

import com.sa46lll.blogsearcher.domain.SearchHistory;
import com.sa46lll.blogsearcher.mapper.SearchHistoryMapper;
import com.sa46lll.blogsearcher.port.out.WriteSearchHistoryPersistencePort;
import com.sa46lll.blogsearcher.repository.SearchHistoryRepository;
import org.springframework.stereotype.Component;

@Component
public class WriteSearchHistoryPersistenceAdapter implements WriteSearchHistoryPersistencePort {

    private final SearchHistoryRepository searchHistoryRepository;

    public WriteSearchHistoryPersistenceAdapter(final SearchHistoryRepository searchHistoryRepository) {
        this.searchHistoryRepository = searchHistoryRepository;
    }

    @Override
    public void save(final SearchHistory searchHistory) {
        searchHistoryRepository.save(
                SearchHistoryMapper.toEntity(searchHistory)
        );
    }
}
