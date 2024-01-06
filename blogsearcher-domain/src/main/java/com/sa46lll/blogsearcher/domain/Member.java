package com.sa46lll.blogsearcher.domain;

public class Member {

    private final Long id;
    private final String name;
    private final String email;

    public Member(final Long id, final String name, final String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public static Member of(final Long id, final String name, final String email) {
        return new Member(id, name, email);
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
