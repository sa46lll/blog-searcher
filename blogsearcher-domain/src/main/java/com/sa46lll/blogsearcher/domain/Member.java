package com.sa46lll.blogsearcher.domain;

public class Member {

    private Long id;
    private String name;
    private String email;

    public Member(final Long id, final String name, final String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Member(final String name, final String email) {
        this.name = name;
        this.email = email;
    }

    public static Member of(final String name, final String email) {
        return new Member(name, email);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
