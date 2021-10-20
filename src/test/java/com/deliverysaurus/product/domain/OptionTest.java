package com.deliverysaurus.product.domain;


import com.deliverysaurus.domain.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}