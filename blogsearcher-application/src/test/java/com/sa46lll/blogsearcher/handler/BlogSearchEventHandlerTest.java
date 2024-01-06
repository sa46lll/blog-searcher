package com.sa46lll.blogsearcher.handler;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.sa46lll.blogsearcher.event.BlogSearchEvent;
import com.sa46lll.blogsearcher.port.in.SaveSearchHistoryUseCase;
import com.sa46lll.blogsearcher.port.in.UpdateSearchKeywordUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BlogSearchEventHandlerTest {

    @InjectMocks
    private BlogSearchEventHandler sut;

    @Mock
    private SaveSearchHistoryUseCase saveSearchHistoryUseCase;

    @Mock
    private UpdateSearchKeywordUseCase updateSearchKeywordUseCase;

    @Test
    void 검색_이벤트가_발생하면_검색_히스토리를_저장한다() {
        sut.handleBlogSearchEvent(
                new BlogSearchEvent("keyword", 1L));

        verify(saveSearchHistoryUseCase, times(1)).save(any());
    }

    @Test
    void 검색_이벤트가_발생하면_검색한_키워드의_횟수를_업데이트한다() {
        sut.handleBlogSearchEvent(
                new BlogSearchEvent("keyword", 1L));

        verify(updateSearchKeywordUseCase, times(1)).update(any());
    }
}
