package com.deliverysaurus.member.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmailAuthTryCountTest {

    @DisplayName("생성")
    @Test
    void 생성() {
        // given
        EmailAuthTryCount emailAuthTryCount = new EmailAuthTryCount();
        // when
        int actual = emailAuthTryCount.getCount();
        // then
        assertThat(actual).isEqualTo(0);
    }

    @DisplayName("생성 실패 - 음수로 생성")
    @Test
    void 생성_실패_음수로_생성() {
        // given
        // when
        // then
        assertThatThrownBy(() -> new EmailAuthTryCount(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성 실패 - 횟수 초과")
    @Test
    void 생성_실패_횟수_초과() {
        // given
        // when
        // then
        assertThatThrownBy(() -> new EmailAuthTryCount(6))
                .isInstanceOf(RuntimeException.class);
    }
}
