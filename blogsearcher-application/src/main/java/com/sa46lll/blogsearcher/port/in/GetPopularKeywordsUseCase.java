package com.sa46lll.blogsearcher.port.in;

import com.sa46lll.blogsearcher.dto.GetPopularKeywordResponse;
import java.util.List;

public interface GetPopularKeywordsUseCase {

    List<GetPopularKeywordResponse> get();
}
