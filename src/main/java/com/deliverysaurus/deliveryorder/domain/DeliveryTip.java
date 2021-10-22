package com.deliverysaurus.deliveryorder.domain;

import com.deliverysaurus.domain.Price;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = {"minimumOrderPrice", "maximumOrderPrice"})
@Embeddable
public class DeliveryTip {
    @Embedded
    @AttributeOverride(name = "price", column = @Column(name = "minimum_order_price"))
    private Price minimumOrderPrice = Price.ZERO;

    @Embedded
    @AttributeOverride(name = "price", column = @Column(name = "maximum_order_price"))
    private Price maximumOrderPrice = Price.ZERO;

    @Embedded
    @AttributeOverride(name = "price", column = @Column(name = "tip"))
    private Price tip = Price.ZERO;

    public DeliveryTip(Price minimumOrderPrice, Price maximumOrderPrice, Price tip) {
        validate(minimumOrderPrice, maximumOrderPrice);

        this.minimumOrderPrice = minimumOrderPrice;
        this.maximumOrderPrice = maximumOrderPrice;
        this.tip = tip;
    }

    private void validate(Price minimumOrderPrice, Price maximumOrderPrice) {
        Assert.isTrue(maximumOrderPrice.biggerThen(minimumOrderPrice), "최소주문 금액이 최대주문 금액보다 클 수 없습니다.");
    }
}
