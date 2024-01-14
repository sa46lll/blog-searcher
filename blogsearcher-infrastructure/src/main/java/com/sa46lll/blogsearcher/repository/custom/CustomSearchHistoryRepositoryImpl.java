package com.sa46lll.blogsearcher.repository.custom;

import static com.sa46lll.blogsearcher.entity.QSearchHistoryEntity.searchHistoryEntity;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sa46lll.blogsearcher.entity.QSearchHistoryEntity;
import com.sa46lll.blogsearcher.entity.SearchHistoryEntity;
import java.time.LocalDateTime;
import java.util.List;

public class CustomSearchHistoryRepositoryImpl implements CustomSearchHistoryRepository {

    private final JPAQueryFactory queryFactory;

    public CustomSearchHistoryRepositoryImpl(final JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public List<SearchHistoryEntity> findByCreatedDateBetween(LocalDateTime start, LocalDateTime end) {
        return queryFactory.selectFrom(searchHistoryEntity)
                .where(searchHistoryEntity.createdDate.between(start, end))
                .fetch();
    }
}
