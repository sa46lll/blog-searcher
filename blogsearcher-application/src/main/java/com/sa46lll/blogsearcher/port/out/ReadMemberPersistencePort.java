package com.sa46lll.blogsearcher.port.out;

import com.sa46lll.blogsearcher.domain.Member;
import java.util.Optional;

public interface ReadMemberPersistencePort {

    Optional<Member> findById(final Long memberId);
}
