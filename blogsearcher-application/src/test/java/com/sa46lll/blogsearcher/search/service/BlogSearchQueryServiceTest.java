package com.sa46lll.blogsearcher.search.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.sa46lll.blogsearcher.domain.Post;
import com.sa46lll.blogsearcher.dto.GetBlogSearchDto;
import com.sa46lll.blogsearcher.dto.GetBlogSearchResponse;
import com.sa46lll.blogsearcher.dto.PageQuery;
import com.sa46lll.blogsearcher.dto.PageResponse;
import com.sa46lll.blogsearcher.event.BlogSearchEvent;
import com.sa46lll.blogsearcher.port.out.ReadBlogSearchPersistencePort;
import com.sa46lll.blogsearcher.port.out.WriteSearchHistoryPersistencePort;
import com.sa46lll.blogsearcher.service.GetBlogSearchQueryService;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

@ExtendWith(MockitoExtension.class)
class BlogSearchQueryServiceTest {

    @InjectMocks
    private GetBlogSearchQueryService sut;

    @Mock
    private WriteSearchHistoryPersistencePort writeSearchPersistencePort;

    @Mock
    private ReadBlogSearchPersistencePort readSearchPersistencePort;

    @Mock
    private ApplicationEventPublisher applicationEventPublisher;

    private GetBlogSearchDto getBlogSearchDto;

    private PageQuery pageQuery;

    BlogSearchQueryServiceTest() {
    }

    @BeforeEach
    void setUp() {
        getBlogSearchDto = new GetBlogSearchDto("keyword", 1L);
        pageQuery = new PageQuery(1, 3);
    }

    @Disabled
    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "\t", "\n"})
    void 검색어가_없으면_저장하지_않는다(String keyword) { // 제거 -> controller 이동 ( 클라이언트 입장에서 생길 수 있는 테스트 )
        sut.search(getBlogSearchDto, pageQuery);

        verify(writeSearchPersistencePort, never()).save(any());
    }

    @Test
    void 키워드를_검색하면_블로그_목록을_반환한다() {
        PageResponse<Post> pageResponse = new PageResponse<>(
                List.of(
                        new Post(1L, "title", "content", null)),
                1, 1, 1, 1, false);
        when(readSearchPersistencePort.findByKeyword(any(), any())).thenReturn(pageResponse);

        PageResponse<GetBlogSearchResponse> keyword = sut.search(getBlogSearchDto, pageQuery);

        assertThat(keyword).isNotNull();
    }

    @Test
    void 키워드를_검색하면_검색_이벤트가_발생한다() {
        PageResponse<Post> pageResponse = new PageResponse<>(
                List.of(
                        new Post(1L, "title", "content", null)),
                1, 1, 1, 1, false);
        when(readSearchPersistencePort.findByKeyword(any(), any())).thenReturn(pageResponse);
        BlogSearchEvent event = new BlogSearchEvent("keyword", 1L);

        sut.search(getBlogSearchDto, pageQuery);

        verify(applicationEventPublisher, times(1)).publishEvent(event);
    }
}
