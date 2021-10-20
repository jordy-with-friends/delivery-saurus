package com.deliverysaurus.product.domain;

import com.deliverysaurus.domain.BaseEntity;
import com.deliverysaurus.domain.Price;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Option extends BaseEntity {
    @Embedded
    private Name name;

    @Embedded
    @AttributeOverride(name = "price", column = @Column(name = "additional_price"))
    private Price additionalPrice = Price.ZERO;

    public Option(Name name, Price additionalPrice) {
        this.name = name;
        this.additionalPrice = additionalPrice;
    }
}
