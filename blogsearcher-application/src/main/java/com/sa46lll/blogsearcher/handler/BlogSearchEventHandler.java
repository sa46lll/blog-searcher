package com.sa46lll.blogsearcher.handler;

import com.sa46lll.blogsearcher.dto.WriteSearchHistoryCommand;
import com.sa46lll.blogsearcher.event.BlogSearchEvent;
import com.sa46lll.blogsearcher.port.in.UpdateSearchKeywordUseCase;
import com.sa46lll.blogsearcher.port.in.SaveSearchHistoryUseCase;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class BlogSearchEventHandler {

    private final SaveSearchHistoryUseCase saveSearchHistoryUseCase;
    private final UpdateSearchKeywordUseCase updateSearchKeywordUseCase;

    public BlogSearchEventHandler(final SaveSearchHistoryUseCase saveSearchHistoryUseCase,
                                  final UpdateSearchKeywordUseCase updateSearchKeywordUseCase) {
        this.saveSearchHistoryUseCase = saveSearchHistoryUseCase;
        this.updateSearchKeywordUseCase = updateSearchKeywordUseCase;
    }

    @Async
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleBlogSearchEvent(final BlogSearchEvent blogSearchEvent) {
        System.out.println("Blog search event: " + blogSearchEvent.keyword());

        saveSearchHistoryUseCase.save(
                new WriteSearchHistoryCommand(blogSearchEvent.keyword(), blogSearchEvent.memberId()));

        updateSearchKeywordUseCase.update(blogSearchEvent.keyword());
    }
}
