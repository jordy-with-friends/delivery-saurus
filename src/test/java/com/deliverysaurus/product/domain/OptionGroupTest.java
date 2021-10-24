package com.deliverysaurus.product.domain;

import com.deliverysaurus.domain.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Stream;

import static com.deliverysaurus.product.domain.OptionMethod.MUST_HAVE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("OptionGroup Test")
class OptionGroupTest {

    @DisplayName("OptionGroup, constructor, 성공")
    @Test
    void constructor_성공() {
        // given
        Option givenOption1 = new Option(new Name("코카콜라 선택"), new Price(0));
        Option givenOption2 = new Option(new Name("스프라이트 변경"), new Price(0));
        Option givenOption3 = new Option(new Name("제로 콜라 변경"), new Price(0));

        // when, then
        assertDoesNotThrow(() -> new OptionGroup(new Name("음료 변경"), MUST_HAVE, Set.of(givenOption1, givenOption2, givenOption3)));
    }

    @DisplayName("OptionGroup, constructor, 예외_optionsLength")
    @Test
    void constructor_예외_optionsLength() {
        // given
        Name givenName = new Name("음료 변경");
        Set<Option> givenOptions = Set.of(new Option(new Name("코카콜라 선택"), new Price(0)));

        assertThatThrownBy(() -> new OptionGroup(givenName, MUST_HAVE, givenOptions))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("equals, 케이스 별")
    @Test
    void equals_케이스별() {
        // given
        OptionGroup optionGroup_음료_변경1 = new OptionGroup(new Name("음료 변경"), MUST_HAVE, Set.of(
                new Option(new Name("코카콜라 선택"), new Price(0)),
                new Option(new Name("스프라이트 변경"), new Price(0)),
                new Option(new Name("제로 콜라 변경"), new Price(0))));

        OptionGroup optionGroup_음료_변경2 = new OptionGroup(new Name("음료 변경"), MUST_HAVE, Set.of(
                new Option(new Name("코카콜라 선택"), new Price(0)),
                new Option(new Name("스프라이트 변경"), new Price(0)),
                new Option(new Name("제로 콜라 변경"), new Price(0))));

        OptionGroup optionGroup_사이드메뉴_변경 = new OptionGroup(new Name("사이드메뉴 변경"), MUST_HAVE, Set.of(
                new Option(new Name("감자튀김 선택"), new Price(0)),
                new Option(new Name("웨지감자 변경"), new Price(300)),
                new Option(new Name("아이스크림 변경"), new Price(300))));

        // when, then
        assertThat(optionGroup_음료_변경1)
                .isEqualTo(optionGroup_음료_변경2)
                .isNotEqualTo(optionGroup_사이드메뉴_변경);
    }
}
