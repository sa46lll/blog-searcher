package com.sa46lll.blogsearcher.port.out;

import com.sa46lll.blogsearcher.domain.SearchHistory;
import java.time.LocalDateTime;
import java.util.List;

public interface ReadSearchHistoryPersistencePort {

    List<SearchHistory> findByCreatedDateBetween(LocalDateTime start, LocalDateTime end);
}
