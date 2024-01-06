package com.sa46lll.blogsearcher.dto;

import java.util.List;
import org.springframework.data.domain.Page;

public record PageJpaDto<T>(
        List<T> content,
        long totalElements,
        int totalPages,
        int pageNumber,
        int numberOfElements,
        boolean hasNextPages
) {

    public static <T> PageJpaDto<T> of(Page<T> page) {
        return new PageJpaDto<>(
                page.getContent(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.getNumber(),
                page.getNumberOfElements(),
                page.hasNext()
        );
    }
}
