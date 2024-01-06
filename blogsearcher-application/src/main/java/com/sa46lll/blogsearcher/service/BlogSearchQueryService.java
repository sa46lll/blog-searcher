package com.sa46lll.blogsearcher.service;

import com.sa46lll.blogsearcher.dto.BlogSearchDto;
import com.sa46lll.blogsearcher.dto.BlogSearchResponse;
import com.sa46lll.blogsearcher.event.BlogSearchEvent;
import com.sa46lll.blogsearcher.port.in.BlogSearchUseCase;
import com.sa46lll.blogsearcher.port.out.ReadBlogSearchPersistencePort;
import java.util.List;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BlogSearchQueryService implements BlogSearchUseCase {

    private final ReadBlogSearchPersistencePort readBlogSearchPersistencePort;
    private final ApplicationEventPublisher applicationEventPublisher;

    public BlogSearchQueryService(final ReadBlogSearchPersistencePort readBlogSearchPersistencePort,
                                  final ApplicationEventPublisher applicationEventPublisher) {
        this.readBlogSearchPersistencePort = readBlogSearchPersistencePort;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public List<BlogSearchResponse> search(final BlogSearchDto blogSearchDto) {
        applicationEventPublisher.publishEvent(
                new BlogSearchEvent(blogSearchDto.keyword(), blogSearchDto.memberId()));

        return readBlogSearchPersistencePort.findByKeyword(blogSearchDto.keyword()).stream()
                .map(BlogSearchResponse::from)
                .toList();
    }
}
