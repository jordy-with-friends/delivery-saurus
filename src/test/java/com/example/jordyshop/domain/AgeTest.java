package com.example.jordyshop.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AgeTest {

    @DisplayName("생성")
    @Test
    void create() {
        // given
        Age age = new Age(10);
        // when
        // then
        assertThat(age).isNotNull();
    }

    @DisplayName("생성 실패 - 나이가 음수")
    @Test
    void createFailedByValue() {
        // given
        // when
        // then
        assertThatThrownBy(() -> new Age(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
