package com.sa46lll.blogsearcher.mapper;

import com.sa46lll.blogsearcher.domain.Post;
import com.sa46lll.blogsearcher.entity.PostEntity;

public class PostMapper {

    private PostMapper() {
    }

    public static Post toDomain(final PostEntity postEntity) {
        return new Post(postEntity.getId(), postEntity.getTitle(), postEntity.getContent(), null);
    }

    public static PostEntity toEntity(final Post post) {
        return new PostEntity(post.getTitle(), post.getContent(), MemberMapper.toEntity(post.getMember()));
    }
}
