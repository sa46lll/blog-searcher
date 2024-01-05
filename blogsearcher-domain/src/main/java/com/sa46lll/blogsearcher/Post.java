package com.sa46lll.blogsearcher;

import java.lang.reflect.Member;

public class Post {

    private Long id;
    private String title;
    private String content;
    private Member member;

    public Post(Long id, String title, String content, Member member) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.member = member;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Member getMember() {
        return member;
    }
}
