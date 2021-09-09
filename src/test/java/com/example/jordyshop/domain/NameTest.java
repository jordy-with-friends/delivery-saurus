package com.example.jordyshop.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {
    @DisplayName("생성")
    @Test
    void create() {
        // given
        Name name = new Name("죠르디");
        // when
        // then
        assertThat(name).isNotNull();
    }

    @DisplayName("생성 실패 - 너무 긴 이름")
    @Test
    void createFailed() {
        // given
        // when
        // then
        assertThatThrownBy(() -> new Name("죠르듸갓갓해"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
