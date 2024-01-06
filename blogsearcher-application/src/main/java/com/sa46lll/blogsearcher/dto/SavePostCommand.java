package com.sa46lll.blogsearcher.dto;

public record SavePostCommand(
        String title,
        String content,
        Long memberId
) {

}
