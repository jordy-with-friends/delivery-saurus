package com.deliverysaurus.member.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandNumberGeneratorTest {

    @DisplayName("랜덤 번호 바운더리 체크")
    @Test
    void 번호_생성() {
        // given
        // when
        // then
        assertThat(RandNumberGenerator.MIN_NUMBER).isEqualTo(100000);
        assertThat(RandNumberGenerator.MAX_NUMBER).isEqualTo(999999);
    }
}
