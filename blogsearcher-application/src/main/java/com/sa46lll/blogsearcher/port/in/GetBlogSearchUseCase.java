package com.sa46lll.blogsearcher.port.in;

import com.sa46lll.blogsearcher.domain.Post;
import com.sa46lll.blogsearcher.dto.GetBlogSearchDto;
import com.sa46lll.blogsearcher.dto.PageQuery;
import com.sa46lll.blogsearcher.dto.PageResponse;

public interface GetBlogSearchUseCase {

    PageResponse<Post> search(final GetBlogSearchDto getBlogSearchDto, final PageQuery pageQuery);
}
