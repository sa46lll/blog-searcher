package com.sa46lll.blogsearcher.repository.custom;

import com.sa46lll.blogsearcher.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomPostRepository {

    Page<PostEntity> findByKeyword(final String keyword, final Pageable pageable);
}
