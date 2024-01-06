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

}
