package com.sa46lll.blogsearcher.handler;

import com.sa46lll.blogsearcher.dto.WriteSearchHistoryCommand;
import com.sa46lll.blogsearcher.event.BlogSearchEvent;
import com.sa46lll.blogsearcher.port.in.WriteSearchHistoryUseCase;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class BlogSearchEventHandler {

    private final WriteSearchHistoryUseCase writeSearchHistoryUseCase;

    public BlogSearchEventHandler(final WriteSearchHistoryUseCase writeSearchHistoryUseCase) {
        this.writeSearchHistoryUseCase = writeSearchHistoryUseCase;
    }

    @Async
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleBlogSearchEvent(final BlogSearchEvent blogSearchEvent) {
        writeSearchHistoryUseCase.save(
                new WriteSearchHistoryCommand(blogSearchEvent.keyword(), blogSearchEvent.memberId()));

        System.out.println("Blog search event: " + blogSearchEvent.keyword());
    }
}
