package com.deliverysaurus.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class PriceTest {
    @Test
    @DisplayName("금액이 음수일경우 IllegalArgumentException이 발생한다")
    void 금액이_음수일경우_IllegalArgumentException_이_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Price(-1));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    @DisplayName("금액이 양수일 경우 성공한다")
    void 금액이_음수일경우_IllegalArgumentException_이_발생한다(int price) {
        assertDoesNotThrow(() -> new Price(price));
    }

    @Test
    @DisplayName("A.biggerThen(B)는 A>=B와 같다")
    void biggerThen() {
        assertThat(new Price(0).biggerThen(new Price(0))).isTrue();

        assertThat(new Price(1).biggerThen(new Price(0))).isTrue();

        assertThat(new Price(0).biggerThen(new Price(1))).isFalse();
    }
}