package com.sa46lll.blogsearcher.adapter;

import com.sa46lll.blogsearcher.domain.Post;
import com.sa46lll.blogsearcher.dto.PageQuery;
import com.sa46lll.blogsearcher.dto.PageJpaDto;
import com.sa46lll.blogsearcher.dto.PageResponse;
import com.sa46lll.blogsearcher.mapper.PageMapper;
import com.sa46lll.blogsearcher.mapper.PostMapper;
import com.sa46lll.blogsearcher.port.out.ReadBlogSearchPersistencePort;
import com.sa46lll.blogsearcher.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class ReadBlogSearchPersistenceAdapter implements ReadBlogSearchPersistencePort {

    private final PostRepository postRepository;

    public ReadBlogSearchPersistenceAdapter(final PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PageResponse<Post> findByKeyword(final String keyword, final PageQuery pageQuery) {
        PageRequest pageable = PageRequest.of(pageQuery.page(), pageQuery.size());
        Page<Post> posts = postRepository.findByKeyword(keyword, pageable)
                .map(PostMapper::toDomain);

        return PageMapper.toResponse(PageJpaDto.of(posts));
    }
}
