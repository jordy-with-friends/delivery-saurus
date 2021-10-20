package com.deliverysaurus.product.domain;


import com.deliverysaurus.domain.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Option Test")
class OptionTest {

    @DisplayName("Option, constructor, 성공")
    @Test
    void constructor_성공() {
        // given
        Name givenName = new Name("스프라이트 변경");
        Price givenAdditionalPrice = new Price(0);

        // when, then
        assertDoesNotThrow(() -> new Option(givenName, givenAdditionalPrice));
    }

    @Test
    void equals_케이스별() {
        assertThat(new Option(new Name("코카콜라 선택"), new Price(0)))
                .isEqualTo(new Option(new Name("코카콜라 선택"), new Price(0)));

        assertThat(new Option(new Name("코카콜라 선택"), new Price(0)))
                .isNotEqualTo(new Option(new Name("스프라이트 변경"), new Price(0)));
    }
}