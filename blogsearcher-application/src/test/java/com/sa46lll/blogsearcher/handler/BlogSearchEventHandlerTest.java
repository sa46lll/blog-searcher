package com.sa46lll.blogsearcher.handler;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.sa46lll.blogsearcher.event.BlogSearchEvent;
import com.sa46lll.blogsearcher.port.in.SaveSearchHistoryUseCase;
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

    @Test
    void 검색_이벤트가_발생하면_검색_히스토리를_저장한다() {
        sut.handleBlogSearchEvent(
                new BlogSearchEvent("keyword", 1L));

        verify(saveSearchHistoryUseCase, times(1)).save(any());
    }
}
