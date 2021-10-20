package com.deliverysaurus.product.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import java.util.Objects;

import static java.lang.String.format;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Description {
    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 150;

    @Column(name = "description")
    private String description;

    public Description(String description) {
        validate(description);
        this.description = description;
    }

    private void validate(String description) {
        if (description.length() < MIN_LENGTH || description.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(format("설명의 길이가 %d~%d가 아닙니다."
                    , MIN_LENGTH, MAX_LENGTH));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Description that = (Description) o;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }
}
