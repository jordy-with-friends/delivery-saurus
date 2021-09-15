package com.deliverysaurus.member.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Name {
    private static final int NAME_MAX_LENGTH = 5;

    @Column(name = "name")
    private String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
