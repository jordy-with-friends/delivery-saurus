package com.deliverysaurus.store.domain;

import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@Embeddable
public class Name {
    private static final int MAX_LENGTH = 20;

    @Column(length = MAX_LENGTH)
    private String name;

    public Name(String name) {
        validate(name);

        this.name = name.trim();
    }

    private void validate(String name) {
        Assert.isTrue(name != null && name.trim().length() > 0, "이름은 공백이면 안됩니다.");
        Assert.isTrue(name.trim().length() <= MAX_LENGTH, "이름의 길이는 "+ MAX_LENGTH +" 글자 이하여야 합니다");
    }
}
