package com.sa46lll.blogsearcher.repository;

import com.sa46lll.blogsearcher.entity.SearchKeywordEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchKeywordRepository extends JpaRepository<SearchKeywordEntity, Long> {

    Optional<SearchKeywordEntity> findByKeyword(String keyword);

    List<SearchKeywordEntity> findTop10ByOrderByCountDesc();
}
