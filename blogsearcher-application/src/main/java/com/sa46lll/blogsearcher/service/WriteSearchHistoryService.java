package com.sa46lll.blogsearcher.service;

import com.sa46lll.blogsearcher.dto.WriteSearchHistoryCommand;
import com.sa46lll.blogsearcher.port.in.WriteSearchHistoryUseCase;
import com.sa46lll.blogsearcher.port.out.WriteSearchHistoryPersistencePort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WriteSearchHistoryService implements WriteSearchHistoryUseCase {

    private final WriteSearchHistoryPersistencePort writeSearchHistoryPersistencePort;

    public WriteSearchHistoryService(final WriteSearchHistoryPersistencePort writeSearchHistoryPersistencePort) {
        this.writeSearchHistoryPersistencePort = writeSearchHistoryPersistencePort;
    }

    @Override
    public void save(WriteSearchHistoryCommand writeSearchHistoryCommand) {
        writeSearchHistoryPersistencePort.save(writeSearchHistoryCommand.toDomain());
    }
}
