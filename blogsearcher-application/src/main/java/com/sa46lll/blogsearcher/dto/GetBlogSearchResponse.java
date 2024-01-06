package com.sa46lll.blogsearcher.dto;

import com.sa46lll.blogsearcher.domain.Post;

public record GetBlogSearchResponse(
        Long id,
        String title,
        String content
) {

    public static GetBlogSearchResponse from(final Post post) {
        return new GetBlogSearchResponse(
                post.getId(),
                post.getTitle(),
                post.getContent());
    }
}
