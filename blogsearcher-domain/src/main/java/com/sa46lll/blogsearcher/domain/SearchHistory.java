package com.sa46lll.blogsearcher.domain;

public class SearchHistory {

    private Long id;
    private String keyword;
    private Long memberId;

    public SearchHistory(final Long id,
                         final String keyword,
                         final Long memberId) {
        this.id = id;
        this.keyword = keyword;
        this.memberId = memberId;
    }

    public SearchHistory(final String keyword,
                         final Long memberId) {
        this.keyword = keyword;
        this.memberId = memberId;
    }

    public Long getId() {
        return id;
    }

    public String getKeyword() {
        return keyword;
    }

    public Long getMemberId() {
        return memberId;
    }
}
