package com.sa46lll.blogsearcher.dto;

import com.sa46lll.blogsearcher.domain.Member;

public record SaveMemberCommand(
        String name,
        String email
) {

    public Member toDomain() {
        return Member.of(name, email);
    }
}
