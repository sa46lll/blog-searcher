package com.sa46lll.blogsearcher.adapter;

import com.sa46lll.blogsearcher.domain.SearchHistory;
import com.sa46lll.blogsearcher.mapper.SearchHistoryMapper;
import com.sa46lll.blogsearcher.port.out.ReadSearchHistoryPersistencePort;
import com.sa46lll.blogsearcher.repository.SearchHistoryRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ReadSearchHistoryPersistenceAdapter implements ReadSearchHistoryPersistencePort {

    private final SearchHistoryRepository searchHistoryRepository;

    public ReadSearchHistoryPersistenceAdapter(final SearchHistoryRepository searchHistoryRepository) {
        this.searchHistoryRepository = searchHistoryRepository;
    }

    @Override
    public List<SearchHistory> findByCreatedDateBetween(LocalDateTime start, LocalDateTime end) {
        return searchHistoryRepository.findByCreatedDateBetween(start, end).stream()
                .map(SearchHistoryMapper::toDomain)
                .toList();
    }
}
