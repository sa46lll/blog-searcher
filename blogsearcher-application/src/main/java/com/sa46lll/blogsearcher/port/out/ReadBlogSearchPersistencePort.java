package com.sa46lll.blogsearcher.port.out;

import com.sa46lll.blogsearcher.Post;
import java.util.List;

public interface ReadBlogSearchPersistencePort {

    List<Post> findByKeyword(String keyword);
}
