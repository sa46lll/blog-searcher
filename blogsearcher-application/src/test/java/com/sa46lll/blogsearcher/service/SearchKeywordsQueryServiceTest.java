package com.sa46lll.blogsearcher.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.sa46lll.blogsearcher.domain.SearchKeyword;
import com.sa46lll.blogsearcher.dto.GetPopularKeywordResponse;
import com.sa46lll.blogsearcher.port.out.ReadSearchKeywordPersistencePort;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SearchKeywordsQueryServiceTest {

    @InjectMocks
    private SearchKeywordsQueryService sut;

    @Mock
    private ReadSearchKeywordPersistencePort readSearchKeywordPersistencePort;

    @Test
    void 제일_많이_검색한_키워드_목록을_반환한다() {
        List<SearchKeyword> topKeywords = List.of(
                new SearchKeyword(1L, "keyword1", 3),
                new SearchKeyword(2L, "keyword2", 2),
                new SearchKeyword(3L, "keyword3", 1)
        );
        when(readSearchKeywordPersistencePort.getPopularKeywords()).thenReturn(topKeywords);

        List<GetPopularKeywordResponse> response = sut.getPopularKeywords();

        assertEquals(3, response.size());
    }
}
