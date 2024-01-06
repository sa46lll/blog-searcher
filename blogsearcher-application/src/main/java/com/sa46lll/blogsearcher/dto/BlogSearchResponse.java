package com.sa46lll.blogsearcher.dto;

import com.sa46lll.blogsearcher.domain.Post;

public record BlogSearchResponse(
        Long id,
        String title,
        String content
) {

    public static BlogSearchResponse from(final Post post) {
        return new BlogSearchResponse(
                post.getId(),
                post.getTitle(),
                post.getContent());
    }
}
