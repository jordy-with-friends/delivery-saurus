package com.example.jordyshop.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
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
