package com.sa46lll.blogsearcher.adapter;

import com.sa46lll.blogsearcher.Post;
import com.sa46lll.blogsearcher.mapper.PostMapper;
import com.sa46lll.blogsearcher.port.out.ReadBlogSearchPersistencePort;
import com.sa46lll.blogsearcher.repository.PostRepository;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ReadBlogSearchPersistenceAdapter implements ReadBlogSearchPersistencePort {

    private final PostRepository postRepository;

    public ReadBlogSearchPersistenceAdapter(final PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> findByKeyword(String keyword) {
        return postRepository.findByContentContaining(keyword).stream()
                .map(PostMapper::toDomain)
                .toList();
    }
}
