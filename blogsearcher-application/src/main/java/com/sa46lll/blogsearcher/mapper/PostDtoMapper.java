package com.sa46lll.blogsearcher.mapper;

import com.sa46lll.blogsearcher.domain.Member;
import com.sa46lll.blogsearcher.domain.Post;
import com.sa46lll.blogsearcher.dto.SavePostCommand;

public class PostDtoMapper {

    private PostDtoMapper() {
    }


    public static Post toDomain(final SavePostCommand savePostCommand, final Member member) {
        return new Post(
                savePostCommand.title(),
                savePostCommand.content(),
                member
        );
    }
}
