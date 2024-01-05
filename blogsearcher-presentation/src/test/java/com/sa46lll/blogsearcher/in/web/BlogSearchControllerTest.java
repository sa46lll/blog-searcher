package com.sa46lll.blogsearcher.in.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.sa46lll.blogsearcher.dto.BlogSearchResponse;
import com.sa46lll.blogsearcher.port.in.BlogSearchUseCase;
import java.util.List;
import org.junit.jupiter.api.Disabled;
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
    private BlogSearchUseCase blogSearchUsecase;

    @Test
    void 키워드로_블로그를_검색한다() throws Exception {
        String keyword = "keyword";
        when(blogSearchUsecase.search(keyword)).thenReturn(List.of(
                new BlogSearchResponse(1L, "title", "keyword")
        ));

        mockMvc.perform(get("/api/v1/search")
                        .param("keyword", keyword)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("요청에 성공했습니다."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].id").isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].title").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].content").isString());
    }

    @Test
    @Disabled
    void 인기_검색어_목록을_조회한다() throws Exception {
        mockMvc.perform(get("/api/v1/search/popular")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("요청에 성공했습니다."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").isArray());
    }
}
