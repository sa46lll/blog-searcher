package com.sa46lll.blogsearcher.port.in;

import com.sa46lll.blogsearcher.domain.Member;

public interface GetMemberUseCase {

    Member findById(final Long memberId);
}
