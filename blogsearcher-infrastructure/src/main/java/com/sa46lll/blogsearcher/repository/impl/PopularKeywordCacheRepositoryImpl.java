package com.sa46lll.blogsearcher.repository.impl;

import com.sa46lll.blogsearcher.domain.SearchKeyword;
import com.sa46lll.blogsearcher.repository.PopularKeywordCacheRepository;
import java.util.List;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PopularKeywordCacheRepositoryImpl implements PopularKeywordCacheRepository {

    private final RedisTemplate<String, Object> redisTemplate;
    private final ListOperations<String, String> listOperations;

    public PopularKeywordCacheRepositoryImpl(final RedisTemplate<String, Object> redisTemplate,
                                             final ListOperations<String, String> listOperations) {
        this.redisTemplate = redisTemplate;
        this.listOperations = listOperations;
    }

    @Override
    public void save(final List<String> keywords) {
        String key = "popular-keywords";
        for (String keyword : keywords) {
            listOperations.rightPush(key, keyword);
        }
    }

    @Override
    public List<SearchKeyword> findPopularKeywords() {
        String key = "popular-keywords";
        return listOperations.range(key, 0, 9).stream()
                .map(keyword -> {
                    String[] split = keyword.split(":");
                    return new SearchKeyword(null, split[0], Integer.parseInt(split[1]));
                })
                .toList();
    }
}
