package com.deliverysaurus.product.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.deliverysaurus.product.domain.Description.MAX_LENGTH;
import static com.deliverysaurus.product.domain.Description.MIN_LENGTH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("Description Test")
class DescriptionTest {

    @MethodSource("methodSource_constructor_성공")
    @DisplayName("Description, constructor, 성공")
    @ParameterizedTest
    void constructor_성공(String givenDescription) {
        assertDoesNotThrow(() -> new Description(givenDescription));
    }

    static Stream<String> methodSource_constructor_성공() {
        return Stream.of("a".repeat(MIN_LENGTH), "a".repeat(MAX_LENGTH));
    }

    @MethodSource("methodSource_constructor_예외_illegalLength")
    @DisplayName("Description, constructor, 예외, illegalLength")
    @ParameterizedTest
    void constructor_예외_illegalLength(String givenDescription) {
        assertThatThrownBy(() -> new Description(givenDescription))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<String> methodSource_constructor_예외_illegalLength() {
        return Stream.of("", "a".repeat(MAX_LENGTH + 1));
    }

    @Test
    void equals_케이스별() {
        assertThat(new Description("죠르디")).isEqualTo(new Description("죠르디"));
        assertThat(new Description("죠르디")).isNotEqualTo(new Description("스카피"));
    }
}