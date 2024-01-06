package com.sa46lll.blogsearcher.event;

public record BlogSearchEvent(
        String keyword,
        Long memberId
) {

}
