package com.sa46lll.blogsearcher.repository.custom;

import static com.sa46lll.blogsearcher.entity.QPostEntity.postEntity;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sa46lll.blogsearcher.entity.PostEntity;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

@Repository
public class CustomPostRepositoryImpl implements CustomPostRepository {

    private final JPAQueryFactory queryFactory;

    public CustomPostRepositoryImpl(final JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public Page<PostEntity> findByKeyword(final String keyword, final Pageable pageable) {
        List<PostEntity> posts = queryFactory
                .selectFrom(postEntity)
                .where(isContainTitle(keyword).or(isContainContent(keyword)))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory.select(postEntity.count())
                .from(postEntity)
                .where(isContainTitle(keyword).or(isContainContent(keyword)));

        return PageableExecutionUtils.getPage(posts, pageable, countQuery::fetchOne);
    }

    private BooleanExpression isContainTitle(final String keyword) {
        return postEntity.title.containsIgnoreCase(keyword);
    }

    private BooleanExpression isContainContent(final String keyword) {
        return postEntity.content.containsIgnoreCase(keyword);
    }
}
