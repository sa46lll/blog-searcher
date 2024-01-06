package com.sa46lll.blogsearcher.service;

import com.sa46lll.blogsearcher.dto.SaveMemberCommand;
import com.sa46lll.blogsearcher.port.in.SaveMemberUseCase;
import com.sa46lll.blogsearcher.port.out.WriteMemberPersistencePort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberCommandService implements SaveMemberUseCase {

    private final WriteMemberPersistencePort writeMemberPersistencePort;

    public MemberCommandService(final WriteMemberPersistencePort writeMemberPersistencePort) {
        this.writeMemberPersistencePort = writeMemberPersistencePort;
    }

    @Override
    public void save(SaveMemberCommand saveMemberCommand) {
        writeMemberPersistencePort.save(saveMemberCommand.toDomain());
    }
}
