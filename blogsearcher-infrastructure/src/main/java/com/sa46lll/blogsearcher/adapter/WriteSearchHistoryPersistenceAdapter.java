package com.sa46lll.blogsearcher.adapter;

import com.sa46lll.blogsearcher.domain.SearchHistory;
import com.sa46lll.blogsearcher.mapper.SearchHistoryMapper;
import com.sa46lll.blogsearcher.port.out.WriteSearchHistoryPersistencePort;
import com.sa46lll.blogsearcher.repository.SearchHistoryRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class WriteSearchHistoryPersistenceAdapter implements WriteSearchHistoryPersistencePort {

    private final SearchHistoryRepository searchHistoryRepository;

    public WriteSearchHistoryPersistenceAdapter(final SearchHistoryRepository searchHistoryRepository) {
        this.searchHistoryRepository = searchHistoryRepository;
    }

    @Override
    public void save(final SearchHistory searchHistory) {
        System.out.println("Save search history: " + searchHistory.getKeyword() + ", " + searchHistory.getMemberId());
        searchHistoryRepository.save(
                SearchHistoryMapper.toEntity(searchHistory)
        );
    }
}
