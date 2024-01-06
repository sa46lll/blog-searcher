package com.sa46lll.blogsearcher.service;

import com.sa46lll.blogsearcher.domain.Member;
import com.sa46lll.blogsearcher.dto.SavePostCommand;
import com.sa46lll.blogsearcher.mapper.PostDtoMapper;
import com.sa46lll.blogsearcher.port.in.GetMemberUseCase;
import com.sa46lll.blogsearcher.port.in.SavePostUseCase;
import com.sa46lll.blogsearcher.port.out.WritePostPersistencePort;
import org.springframework.stereotype.Service;

@Service
public class PostCommandService implements SavePostUseCase {

    private final WritePostPersistencePort writePostPersistencePort;
    private final GetMemberUseCase getMemberUseCase;

    public PostCommandService(final WritePostPersistencePort writePostPersistencePort,
                              final GetMemberUseCase getMemberUseCase) {
        this.writePostPersistencePort = writePostPersistencePort;
        this.getMemberUseCase = getMemberUseCase;
    }

    @Override
    public void save(final SavePostCommand savePostCommand) {
        Member member = getMemberUseCase.findById(savePostCommand.memberId());

        writePostPersistencePort.save(PostDtoMapper.toDomain(savePostCommand, member));
    }
}
