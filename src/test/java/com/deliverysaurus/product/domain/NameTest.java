package com.deliverysaurus.product.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.deliverysaurus.product.domain.Name.MAX_LENGTH;
import static com.deliverysaurus.product.domain.Name.MIN_LENGTH;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("Name in Product Context Test")
class NameTest {

    @MethodSource("methodSource_constructor_성공")
    @DisplayName("Name, constructor, 성공")
    @ParameterizedTest
    void constructor_성공(String givenName) {
        assertDoesNotThrow(() -> new Name(givenName));
    }

    static Stream<String> methodSource_constructor_성공() {
        return Stream.of("a".repeat(MIN_LENGTH), "a".repeat(MAX_LENGTH));
    }

    @MethodSource("methodSource_constructor_예외_illegalLength")
    @DisplayName("Name, constructor, 예외, illegalLength")
    @ParameterizedTest
    void constructor_예외_illegalLength(String givenName) {
        assertThatThrownBy(() -> new Name(givenName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<String> methodSource_constructor_예외_illegalLength() {
        return Stream.of("", "a".repeat(MAX_LENGTH + 1));
    }
}