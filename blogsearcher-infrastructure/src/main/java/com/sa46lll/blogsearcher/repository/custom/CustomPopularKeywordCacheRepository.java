package com.sa46lll.blogsearcher.repository.custom;

import com.sa46lll.blogsearcher.repository.PopularKeywordCacheRepository;
import java.util.List;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomPopularKeywordCacheRepository implements PopularKeywordCacheRepository {

    private final RedisTemplate<String, Object> redisTemplate;
    private final ListOperations<String, String> listOperations;

    public CustomPopularKeywordCacheRepository(final RedisTemplate<String, Object> redisTemplate,
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
}
