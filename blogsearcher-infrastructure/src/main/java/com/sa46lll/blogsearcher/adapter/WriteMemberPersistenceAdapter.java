package com.sa46lll.blogsearcher.adapter;

import com.sa46lll.blogsearcher.domain.Member;
import com.sa46lll.blogsearcher.mapper.MemberMapper;
import com.sa46lll.blogsearcher.port.out.WriteMemberPersistencePort;
import com.sa46lll.blogsearcher.repository.MemberRepository;
import org.springframework.stereotype.Component;

@Component
public class WriteMemberPersistenceAdapter implements WriteMemberPersistencePort {

    private final MemberRepository memberRepository;

    public WriteMemberPersistenceAdapter(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void save(Member member) {
        memberRepository.save(MemberMapper.toEntity(member));
    }
}
