package com.sa46lll.blogsearcher;

public class SearchKeyword {

    private Long id;
    private String keyword;
    private int count;

    public SearchKeyword(Long id, String keyword, int count) {
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
