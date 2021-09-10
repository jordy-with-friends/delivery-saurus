package com.example.jordyshop.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TelTest {

    @DisplayName("생성")
    @Test
    void create() {
        // given
        Tel tel = new Tel("01015251525");
        // when
        // then
        assertThat(tel).isNotNull();
    }

    @DisplayName("생성 실패 - 짧은 번호")
    @Test
    void createFailedByLength() {
        // given
        // when
        // then
        assertThatThrownBy(() -> new Tel("010"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성 실패 - 번호가 아님")
    @Test
    void createFailedByText() {
        // given
        // when
        // then
        assertThatThrownBy(() -> new Tel("010abcdabcd"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
