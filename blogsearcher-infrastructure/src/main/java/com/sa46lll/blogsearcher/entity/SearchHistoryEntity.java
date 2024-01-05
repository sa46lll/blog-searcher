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


    private String keyword;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;
}
