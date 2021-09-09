package com.example.jordyshop.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NicknameTest {

    @DisplayName("생성")
    @Test
    void create() {
        // given
        Nickname nickname = new Nickname("죠릐디");
        // when
        // then
        assertThat(nickname).isNotNull();
    }

    @DisplayName("생성 실패 - 너무 짧은 닉네임")
    @Test
    void createFailedByMinLength() {
        // given
        // when
        // then
        assertThatThrownBy(() -> new Nickname("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성 실패 - 너무 긴 닉네임")
    @Test
    void createFailedByMaxLength() {
        // given
        // when
        // then
        assertThatThrownBy(() -> new Nickname("죠르듸12334578901233457890"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}