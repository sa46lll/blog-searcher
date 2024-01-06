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
@Table(name = "search_keyword")
@EntityListeners(AuditingEntityListener.class)
public class SearchKeywordEntity extends AuditEntity {

    @Id
    @Column(name = "search_history_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "keyword", nullable = false, unique = true)
    private String keyword;

    @Column(name = "search_count", nullable = false)
    private int count;

    protected SearchKeywordEntity() {
    }

    public SearchKeywordEntity(final Long id, final String keyword, final int count) {
        this.id = id;
        this.keyword = keyword;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public String getKeyword() {
        return keyword;
    }

    public int getCount() {
        return count;
    }
}
