package com.sa46lll.blogsearcher.port.out;

import com.sa46lll.blogsearcher.domain.Member;

public interface WriteMemberPersistencePort {

    void save(final Member member);
}
