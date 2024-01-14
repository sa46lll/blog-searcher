package com.sa46lll.blogsearcher.repository.custom;

import com.sa46lll.blogsearcher.entity.SearchHistoryEntity;
import java.time.LocalDateTime;
import java.util.List;

public interface CustomSearchHistoryRepository {

    List<SearchHistoryEntity> findByCreatedDateBetween(LocalDateTime start, LocalDateTime end);
}
