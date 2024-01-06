package com.sa46lll.blogsearcher.mapper;

import com.sa46lll.blogsearcher.domain.Member;
import com.sa46lll.blogsearcher.entity.MemberEntity;

public class MemberMapper {

    private MemberMapper() {
    }

    public static Member toDomain(final MemberEntity entity) {
        return new Member(
                entity.getId(),
                entity.getName(),
                entity.getEmail()
        );
    }

    public static MemberEntity toEntity(final Member member) {
        return new MemberEntity(
                member.getId(),
                member.getName(),
                member.getEmail()
        );
    }
}
