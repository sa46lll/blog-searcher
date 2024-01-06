package com.sa46lll.blogsearcher.port.in;

import com.sa46lll.blogsearcher.dto.GetBlogSearchDto;
import com.sa46lll.blogsearcher.dto.GetBlogSearchResponse;
import com.sa46lll.blogsearcher.dto.PageQuery;
import com.sa46lll.blogsearcher.dto.PageResponse;

public interface GetBlogSearchUseCase {

    PageResponse<GetBlogSearchResponse> search(final GetBlogSearchDto getBlogSearchDto, final PageQuery pageQuery);
}
