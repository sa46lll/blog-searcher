package com.sa46lll.blogsearcher.repository;

import com.sa46lll.blogsearcher.entity.PostEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    List<PostEntity> findByContentContaining(String keyword);
}
