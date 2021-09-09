package com.example.jordyshop.domain;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class Name {
    public static final int NAME_MAX_LENGTH = 5;
    private String value;

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
