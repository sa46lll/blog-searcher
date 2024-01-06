package com.sa46lll.blogsearcher.adapter;

import com.sa46lll.blogsearcher.domain.Post;
import com.sa46lll.blogsearcher.mapper.PostMapper;
import com.sa46lll.blogsearcher.port.out.WritePostPersistencePort;
import com.sa46lll.blogsearcher.repository.PostRepository;
import org.springframework.stereotype.Component;

@Component
public class WritePostPersistenceAdapter implements WritePostPersistencePort {

    private final PostRepository postRepository;

    public WritePostPersistenceAdapter(final PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void save(Post post) {
        postRepository.save(PostMapper.toEntity(post));
    }
}
