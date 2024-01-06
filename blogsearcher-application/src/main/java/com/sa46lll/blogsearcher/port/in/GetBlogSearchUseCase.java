package com.sa46lll.blogsearcher.port.in;

import com.sa46lll.blogsearcher.dto.GetBlogSearchDto;
import com.sa46lll.blogsearcher.dto.GetBlogSearchResponse;
import java.util.List;

public interface GetBlogSearchUseCase {

    List<GetBlogSearchResponse> search(final GetBlogSearchDto getBlogSearchDto);
}
