package com.sa46lll.blogsearcher.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "search_history")
public class SearchHistoryEntity {

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
