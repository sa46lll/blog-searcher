package com.sa46lll.blogsearcher.port.out;

import com.sa46lll.blogsearcher.domain.Post;
import com.sa46lll.blogsearcher.dto.PageQuery;
import com.sa46lll.blogsearcher.dto.PageResponse;

public interface ReadBlogSearchPersistencePort {

    PageResponse<Post> findByKeyword(final String keyword, final PageQuery pageQuery);
}
