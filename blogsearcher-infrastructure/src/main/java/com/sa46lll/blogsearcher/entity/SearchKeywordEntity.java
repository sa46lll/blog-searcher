package com.sa46lll.blogsearcher.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "search_keyword")
public class SearchKeywordEntity {

    @Id
    @Column(name = "search_history_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "keyword", nullable = false, unique = true)
    private String keyword;

    @Column(name = "search_count", nullable = false)
    private int count;
}
