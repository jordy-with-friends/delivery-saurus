package com.deliverysaurus.member.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class Nickname {
    private static final int NICKNAME_MIN_LENGTH = 2;
    private static final int NICKNAME_MAX_LENGTH = 20;

    @Column(name = "nickname")
    private String value;

    public Nickname(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value.length() < NICKNAME_MIN_LENGTH || value.length() > NICKNAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
