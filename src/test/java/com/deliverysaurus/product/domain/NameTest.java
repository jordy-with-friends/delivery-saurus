package com.deliverysaurus.product.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("Name in Product Context Test")
class NameTest {

    @ValueSource(strings = {"죠", "죠르", "죠르디",
            "죠르디 햄", "죠르디 햄버", "죠르디 햄버거",
            "죠르디 햄버거 세", "죠르디 햄버거 세트",
            "123456789_123456789_123456789_123456789_"})
    @DisplayName("Name, constructor, 성공")
    @ParameterizedTest
    void constructor_성공(String givenName) {
        assertDoesNotThrow(() -> new Name(givenName));
    }

    @ValueSource(strings = {"",
            "123456789_123456789_123456789_123456789_1"})
    @DisplayName("Name, constructor, 예외, illegalLength")
    @ParameterizedTest
    void constructor_예외_illegalLength(String givenName) {
        assertThatThrownBy(() -> new Name(givenName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}