package com.sa46lll.blogsearcher.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "search_history")
@EntityListeners(AuditingEntityListener.class)
public class SearchHistoryEntity extends AuditEntity {

    @Id
    @Column(name = "search_history_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "keyword")
    private String keyword;

    @Column(name = "member_id")
    private Long memberId;

    protected SearchHistoryEntity() {
    }

    public SearchHistoryEntity(String keyword, Long memberId) {
        this.keyword = keyword;
        this.memberId = memberId;
    }
}
