package com.sa46lll.blogsearcher.port.in;

import com.sa46lll.blogsearcher.dto.BlogSearchResponse;
import java.util.List;

public interface BlogSearchUseCase {

    List<BlogSearchResponse> search(String keyword);
}
