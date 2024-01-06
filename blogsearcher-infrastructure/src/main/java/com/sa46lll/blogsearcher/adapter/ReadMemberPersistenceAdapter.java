package com.sa46lll.blogsearcher.adapter;

import com.sa46lll.blogsearcher.domain.Member;
import com.sa46lll.blogsearcher.mapper.MemberMapper;
import com.sa46lll.blogsearcher.port.out.ReadMemberPersistencePort;
import com.sa46lll.blogsearcher.repository.MemberRepository;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class ReadMemberPersistenceAdapter implements ReadMemberPersistencePort {

    private final MemberRepository memberRepository;

    public ReadMemberPersistenceAdapter(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Optional<Member> findById(Long memberId) {
        return memberRepository.findById(memberId)
                .map(MemberMapper::toDomain);
    }
}
