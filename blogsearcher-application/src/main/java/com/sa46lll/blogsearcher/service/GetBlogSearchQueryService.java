package com.sa46lll.blogsearcher.service;

import com.sa46lll.blogsearcher.dto.GetBlogSearchDto;
import com.sa46lll.blogsearcher.dto.GetBlogSearchResponse;
import com.sa46lll.blogsearcher.event.BlogSearchEvent;
import com.sa46lll.blogsearcher.port.in.GetBlogSearchUseCase;
import com.sa46lll.blogsearcher.port.out.ReadBlogSearchPersistencePort;
import java.util.List;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GetBlogSearchQueryService implements GetBlogSearchUseCase {

    private final ReadBlogSearchPersistencePort readBlogSearchPersistencePort;
    private final ApplicationEventPublisher applicationEventPublisher;

    public GetBlogSearchQueryService(final ReadBlogSearchPersistencePort readBlogSearchPersistencePort,
                                     final ApplicationEventPublisher applicationEventPublisher) {
        this.readBlogSearchPersistencePort = readBlogSearchPersistencePort;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public List<GetBlogSearchResponse> search(final GetBlogSearchDto getBlogSearchDto) {
        applicationEventPublisher.publishEvent(
                new BlogSearchEvent(getBlogSearchDto.keyword(), getBlogSearchDto.memberId()));

        return readBlogSearchPersistencePort.findByKeyword(getBlogSearchDto.keyword()).stream()
                .map(GetBlogSearchResponse::from)
                .toList();
    }
}
