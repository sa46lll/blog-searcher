package com.sa46lll.blogsearcher.service;

import com.sa46lll.blogsearcher.dto.GetPopularKeywordResponse;
import com.sa46lll.blogsearcher.port.in.GetPopularKeywordsUseCase;
import com.sa46lll.blogsearcher.port.out.ReadSearchKeywordPersistencePort;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SearchKeywordsQueryService implements GetPopularKeywordsUseCase {

    private final ReadSearchKeywordPersistencePort readSearchKeywordPersistencePort;

    public SearchKeywordsQueryService(final ReadSearchKeywordPersistencePort readSearchKeywordPersistencePort) {
        this.readSearchKeywordPersistencePort = readSearchKeywordPersistencePort;
    }

    @Override
    public List<GetPopularKeywordResponse> getPopularKeywords() {
        return readSearchKeywordPersistencePort.getPopularKeywords().stream()
                .map(GetPopularKeywordResponse::from)
                .toList();
    }
}
