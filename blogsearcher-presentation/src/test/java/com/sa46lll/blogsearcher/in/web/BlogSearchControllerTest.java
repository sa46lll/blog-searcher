package com.sa46lll.blogsearcher.in.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.sa46lll.blogsearcher.domain.Post;
import com.sa46lll.blogsearcher.dto.GetBlogSearchDto;
import com.sa46lll.blogsearcher.dto.GetBlogSearchResponse;
import com.sa46lll.blogsearcher.dto.PageQuery;
import com.sa46lll.blogsearcher.dto.PageResponse;
import com.sa46lll.blogsearcher.port.in.GetBlogSearchUseCase;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BlogSearchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetBlogSearchUseCase getBlogSearchUseCase;

    @Test
    void 키워드로_블로그를_검색한다() throws Exception {
        GetBlogSearchDto getBlogSearchDto = new GetBlogSearchDto("keyword", 1L);
        PageResponse<GetBlogSearchResponse> pageResponse = new PageResponse<>(
                List.of(
                        new GetBlogSearchResponse(1L, "title", "content")),
                1, 1, 1, 1, false);

        when(getBlogSearchUseCase.search(getBlogSearchDto, new PageQuery(1, 2)))
                .thenReturn(pageResponse);

        mockMvc.perform(get("/api/v1/search")
                        .param("keyword", "content")
                        .param("page", "1")
                        .param("size", "2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("요청에 성공했습니다."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.content").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.content[0].id").isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.content[0].title").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.content[0].content").isString());
    }
}
