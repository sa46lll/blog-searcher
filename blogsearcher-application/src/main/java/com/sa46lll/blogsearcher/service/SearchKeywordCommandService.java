package com.sa46lll.blogsearcher.service;

import com.sa46lll.blogsearcher.domain.SearchKeyword;
import com.sa46lll.blogsearcher.port.in.UpdateSearchKeywordUseCase;
import com.sa46lll.blogsearcher.port.out.ReadSearchKeywordPersistencePort;
import com.sa46lll.blogsearcher.port.out.WriteSearchKeywordPersistencePort;
import org.springframework.stereotype.Service;

@Service
public class SearchKeywordCommandService implements UpdateSearchKeywordUseCase {

    private final ReadSearchKeywordPersistencePort readSearchKeywordPersistencePort;
    private final WriteSearchKeywordPersistencePort writeSearchKeywordPersistencePort;

    public SearchKeywordCommandService(final WriteSearchKeywordPersistencePort writeSearchKeywordPersistencePort,
                                       final ReadSearchKeywordPersistencePort readSearchKeywordPersistencePort) {
        this.writeSearchKeywordPersistencePort = writeSearchKeywordPersistencePort;
        this.readSearchKeywordPersistencePort = readSearchKeywordPersistencePort;
    }

    @Override
    public void update(String keyword) {
        SearchKeyword searchKeyword = readSearchKeywordPersistencePort.findByKeyword(keyword)
                .orElse(new SearchKeyword(keyword));

        searchKeyword.incrementCount();
        writeSearchKeywordPersistencePort.save(searchKeyword);
    }
}
