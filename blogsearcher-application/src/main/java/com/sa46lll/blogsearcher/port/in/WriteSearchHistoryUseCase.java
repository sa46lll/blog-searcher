package com.sa46lll.blogsearcher.port.in;

import com.sa46lll.blogsearcher.dto.WriteSearchHistoryCommand;

public interface WriteSearchHistoryUseCase {

    void save(final WriteSearchHistoryCommand writeSearchHistoryCommand);
}
