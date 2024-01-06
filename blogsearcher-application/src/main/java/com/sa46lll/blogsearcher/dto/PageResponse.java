package com.sa46lll.blogsearcher.dto;

import java.util.List;

public record PageResponse<T>(
        List<T> content,
        long totalElements,
        int totalPages,
        int pageNumber,
        int numberOfElements,
        boolean hasNextPages
) {

    public static <T> PageResponse<T> convert(final List<T> content, final PageResponse<?> page) {
        return new PageResponse<>(
                content,
                page.totalElements(),
                page.totalPages(),
                page.pageNumber(),
                page.numberOfElements(),
                page.hasNextPages()
        );
    }
}
