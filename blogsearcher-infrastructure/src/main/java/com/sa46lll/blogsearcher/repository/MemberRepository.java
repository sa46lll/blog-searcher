package com.sa46lll.blogsearcher.repository;

import com.sa46lll.blogsearcher.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

}
