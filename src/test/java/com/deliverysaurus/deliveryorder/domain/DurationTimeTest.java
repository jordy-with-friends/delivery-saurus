package com.deliverysaurus.deliveryorder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class DurationTimeTest {
    @Test
    @DisplayName("소요시간이 음수면 IllegalArgumnetException이 발생한다")
    void 소요시간이_음수면_IllegalArgumentException이_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new DurationTime(-1, 0));
        assertThatIllegalArgumentException().isThrownBy(() -> new DurationTime(0, -1));
    }

    @ParameterizedTest
    @CsvSource(value = {"0, 0", "1, 1"})
    @DisplayName("소요시간은 양수면 성공한다")
    void 소요시간이_양수면_성공한다(int minimumTime, int maximumTime) {
        assertDoesNotThrow(() -> new DurationTime(minimumTime, maximumTime));
    }

    @Test
    @DisplayName("최소 소요시간이 최대 소요시간보다 클 경우 IllegalArgumentException이 발생한다")
    void 최소_소요시간이_최대_소요시간보다_클_경우_IllegalArgumentException이_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new DurationTime(1, 0));
    }
}