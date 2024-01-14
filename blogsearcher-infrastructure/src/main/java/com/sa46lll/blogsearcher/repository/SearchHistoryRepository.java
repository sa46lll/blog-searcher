package com.sa46lll.blogsearcher.repository;

import com.sa46lll.blogsearcher.entity.SearchHistoryEntity;
import com.sa46lll.blogsearcher.repository.custom.CustomSearchHistoryRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchHistoryRepository extends JpaRepository<SearchHistoryEntity, Long>, CustomSearchHistoryRepository {

}
