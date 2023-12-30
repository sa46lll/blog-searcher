package com.sa46lll.blogsearcher.search.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.sa46lll.blogsearcher.SearchKeyword;
import com.sa46lll.blogsearcher.dto.BlogSearchResponse;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SearchCommandServiceTest {

    @InjectMocks
    private SearchCommandService sut;

    @Mock
    private WriteSearchPersistencePort writeSearchPersistencePort;

    @Mock
    private ReadSearchPersistencePort readSearchPersistencePort;

    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "\t", "\n"})
    void 검색어가_없으면_저장하지_않는다(String keyword) {
        sut.search(keyword);

        verify(writeSearchPersistencePort, never()).save(any());
    }

    @Test
    void 검색어가_있으면_저장한다() {
        sut.search("keyword");

        verify(writeSearchPersistencePort).save(any());
    }

    @Test
    void 검색하면_검색_횟수가_증가한다() {
        sut.search("keyword");

        verify(writeSearchPersistencePort).updateSearchCount(any());
    }

    @Test
    void 검색하면_블로그를_반환한다() {
        BlogSearchResponse response = sut.search("keyword");
        List<SearchKeyword> searchHistories = List.of(
            new SearchKeyword("keyword1"),
            new SearchKeyword("keyword2")
        );

        when(readSearchPersistencePort.findTop10ByOrderBySearchCountDesc()).thenReturn(searchHistories);

        assertThat(response).isNotNull();

    }
}
