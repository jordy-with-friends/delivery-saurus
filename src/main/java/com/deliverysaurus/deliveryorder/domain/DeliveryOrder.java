package com.deliverysaurus.deliveryorder.domain;

import com.deliverysaurus.domain.BaseEntity;
import com.deliverysaurus.domain.Price;
import com.deliverysaurus.store.domain.Store;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeliveryOrder extends BaseEntity {
    @Embedded
    @AttributeOverride(name = "price", column = @Column(name = "minimum_order_price"))
    private Price minimumOrderPrice = new Price(0);

    @Embedded
    private DurationTime durationTime = new DurationTime(0, 0);

    @ElementCollection
    private Set<DeliveryTip> deliveryTips = new HashSet<>();

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<OrderMethod> orderMethods = new HashSet<>();

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<PaymentMethod> paymentMethods = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY)
    private Store store;
}
