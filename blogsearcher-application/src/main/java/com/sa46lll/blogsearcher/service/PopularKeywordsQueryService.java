package com.sa46lll.blogsearcher.service;

import com.sa46lll.blogsearcher.dto.GetPopularKeywordResponse;
import com.sa46lll.blogsearcher.port.in.GetCachedPopularKeywordsUseCase;
import com.sa46lll.blogsearcher.port.in.GetPopularKeywordsUseCase;
import com.sa46lll.blogsearcher.port.out.ReadPopularKeywordCachePort;
import com.sa46lll.blogsearcher.port.out.ReadSearchKeywordPersistencePort;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PopularKeywordsQueryService implements GetPopularKeywordsUseCase, GetCachedPopularKeywordsUseCase {

    private final ReadSearchKeywordPersistencePort readSearchKeywordPersistencePort;
    private final ReadPopularKeywordCachePort readPopularKeywordCachePort;

    public PopularKeywordsQueryService(final ReadSearchKeywordPersistencePort readSearchKeywordPersistencePort,
                                       final ReadPopularKeywordCachePort readPopularKeywordCachePort) {
        this.readSearchKeywordPersistencePort = readSearchKeywordPersistencePort;
        this.readPopularKeywordCachePort = readPopularKeywordCachePort;
    }

    @Override
    public List<GetPopularKeywordResponse> get() {
        return readSearchKeywordPersistencePort.getPopularKeywords().stream()
                .map(GetPopularKeywordResponse::from)
                .toList();
    }

    @Override
    public List<GetPopularKeywordResponse> getCached() {
        System.out.println("getCached() called");
        return readPopularKeywordCachePort.getPopularKeywords().stream()
                .map(GetPopularKeywordResponse::from)
                .toList();
    }
}
