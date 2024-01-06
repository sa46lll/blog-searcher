package com.sa46lll.blogsearcher.port.out;

import com.sa46lll.blogsearcher.domain.Post;

public interface WritePostPersistencePort {

    void save(final Post post);
}
