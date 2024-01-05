package com.sa46lll.blogsearcher;

public class SearchHistory {

    private Long id;
    private String keyword;

    public SearchHistory(String keyword) {
        this.keyword = keyword;
    }

    public Long getId() {
        return id;
    }

    public String getKeyword() {
        return keyword;
    }
}
