package com.deliverysaurus.product.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import java.util.Objects;

import static java.lang.String.format;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Name {
    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 40;

    @Column(name = "name")
    private String value;

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value.length() < MIN_LENGTH || value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(format("이름의 길이가 %d~%d가 아닙니다."
                    , MIN_LENGTH, MAX_LENGTH));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
