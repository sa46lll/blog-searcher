package com.sa46lll.blogsearcher.in.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.sa46lll.blogsearcher.dto.GetPopularKeywordResponse;
import com.sa46lll.blogsearcher.port.in.GetPopularKeywordsUseCase;
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
class PopularKeywordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetPopularKeywordsUseCase getBlogSearchUseCase;

    @Test
    void 인기_검색어_목록을_조회한다() throws Exception {
        when(getBlogSearchUseCase.get())
                .thenReturn(List.of(
                        new GetPopularKeywordResponse("keyword3", 3),
                        new GetPopularKeywordResponse("keyword2", 2),
                        new GetPopularKeywordResponse("keyword1", 1)
                ));

        mockMvc.perform(get("/api/v1/search/popular")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("요청에 성공했습니다."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].keyword").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].count").isNumber());
    }
}
