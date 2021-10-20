package com.deliverysaurus.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

import javax.persistence.Embeddable;

@Getter
@Setter(value = AccessLevel.PRIVATE)
@Embeddable
public class Price {
    public static final Price ZERO = new Price(0);

    private int price;

    protected Price() {
        this(0);
    }

    public Price(int price) {
        validate(price);

        this.price = price;
    }

    public boolean biggerThen(Price maximumOrderPrice) {
        return this.price >= maximumOrderPrice.price;
    }

    private void validate(int price) {
        Assert.isTrue(price >= 0, "금액은 0원 이상이여야 합니다.");
    }
}
