package com.deliverysaurus.member.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class Age {

    @Column(name = "age")
    private int value;

    public Age(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException();
        }
    }
}
