package com.deliverysaurus.deliveryorder.domain;

import com.deliverysaurus.domain.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class DeliveryTipTest {
    @Test
    @DisplayName("최소주문 금액이 최대주문 금액보다 클 경우 IllegalArgumentException이 발생한다")
    public void 최소주문_금액이_최대주문_금액보다_클_경우_IllegalArgumentException이_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new DeliveryTip(new Price(1), new Price(0), Price.ZERO));
    }

    @ParameterizedTest
    @CsvSource(value = {"0, 0", "0, 1"})
    @DisplayName("최소주문 금액이 최대주문 금액보다 작을 경우 성공한다")
    public void 최소주문_금액이_최대_주문금액보다_작을경우_성공한다(int minimumPrice, int maximumPrice) {
        assertDoesNotThrow(() -> new DeliveryTip(new Price(minimumPrice), new Price(maximumPrice), Price.ZERO));
    }
}