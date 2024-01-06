package com.sa46lll.blogsearcher.mapper;

import com.sa46lll.blogsearcher.dto.PageJpaDto;
import com.sa46lll.blogsearcher.dto.PageResponse;

public class PageMapper {

    private PageMapper() {
    }

    public static <T> PageResponse<T> toResponse(final PageJpaDto page) {
        return new PageResponse<>(
                page.content(),
                page.totalElements(),
                page.totalPages(),
                page.pageNumber(),
                page.numberOfElements(),
                page.hasNextPages()
        );
    }
}
