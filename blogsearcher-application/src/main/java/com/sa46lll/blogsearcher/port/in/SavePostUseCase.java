package com.sa46lll.blogsearcher.port.in;

import com.sa46lll.blogsearcher.dto.SavePostCommand;

public interface SavePostUseCase {

    void save(final SavePostCommand savePostCommand);
}
