package com.sa46lll.blogsearcher.service;

import com.sa46lll.blogsearcher.dto.BlogSearchResponse;
import com.sa46lll.blogsearcher.port.in.BlogSearchUseCase;
import com.sa46lll.blogsearcher.port.out.ReadBlogSearchPersistencePort;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BlogSearchQueryService implements BlogSearchUseCase {

    private final ReadBlogSearchPersistencePort readBlogSearchPersistencePort;

    public BlogSearchQueryService(ReadBlogSearchPersistencePort readBlogSearchPersistencePort) {
        this.readBlogSearchPersistencePort = readBlogSearchPersistencePort;
    }

    @Override
    public List<BlogSearchResponse> search(String keyword) {
        return readBlogSearchPersistencePort.findByKeyword(keyword).stream()
                .map(BlogSearchResponse::from)
                .toList();
    }
}
