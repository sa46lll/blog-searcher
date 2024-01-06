package com.sa46lll.blogsearcher.service;

import com.sa46lll.blogsearcher.domain.Member;
import com.sa46lll.blogsearcher.port.in.GetMemberUseCase;
import com.sa46lll.blogsearcher.port.out.ReadMemberPersistencePort;
import org.springframework.stereotype.Service;

@Service
public class MemberQueryService implements GetMemberUseCase {

    private final ReadMemberPersistencePort readMemberPersistencePort;

    public MemberQueryService(final ReadMemberPersistencePort readMemberPersistencePort) {
        this.readMemberPersistencePort = readMemberPersistencePort;
    }

    @Override
    public Member findById(Long memberId) {
        return readMemberPersistencePort.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
    }
}
