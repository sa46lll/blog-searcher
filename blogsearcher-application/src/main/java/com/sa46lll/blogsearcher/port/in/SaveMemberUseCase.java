package com.sa46lll.blogsearcher.port.in;

import com.sa46lll.blogsearcher.dto.SaveMemberCommand;

public interface SaveMemberUseCase {

    void save(final SaveMemberCommand saveMemberCommand);
}
