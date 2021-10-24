package com.deliverysaurus.product.domain;

import com.deliverysaurus.domain.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.deliverysaurus.product.domain.OptionMethod.MUST_HAVE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("Product Test")
class ProductTest {
    @DisplayName("constructor, 성공")
    @Test
    void constructor_성공() {
        // given
        Name givenName = new Name("죠르디 치킨 버거 세트");
        Description givenDescription = new Description("요리의 대가 죠르디가 만든 치킨 버거 세트 메뉴로 " +
                "코카콜라, 프렌치 프라이 함께 제공 됩니다.");
        Price givenPrice = new Price(5_500);

        // when, then
        assertDoesNotThrow(() -> new Product(givenName, givenDescription, givenPrice));
    }

    @Test
    void equals_케이스별() {
        // given
        Product product_햄버거 = new Product(new Name("햄버거"), new Description("햄버거"), new Price(3_500));
        Product product_햄버거2 = new Product(new Name("햄버거"), new Description("햄버거"), new Price(3_500));
        Product product_치킨 = new Product(new Name("치킨"), new Description("치킨"), new Price(12_500));

        // when, then
        assertThat(product_햄버거)
                .isEqualTo(product_햄버거2)
                .isNotEqualTo(product_치킨);
    }

    @Test
    void addOptionGroup_성공() {
        // given
        OptionGroup optionGroup_음료_변경 = new OptionGroup(new Name("음료 변경"), MUST_HAVE, Set.of(
                new Option(new Name("코카콜라 선택"), new Price(0)),
                new Option(new Name("스프라이트 변경"), new Price(0)),
                new Option(new Name("제로 콜라 변경"), new Price(0))));

        Product product_햄버거 = new Product(new Name("햄버거"), new Description("햄버거"), new Price(3_500));

        // when, then
        assertDoesNotThrow(() -> product_햄버거.addOptionGroup(optionGroup_음료_변경));
    }

    @Test
    void addOptionGroup_예외() {
        // given
        OptionGroup optionGroup_음료_변경 = new OptionGroup(new Name("음료 변경"), MUST_HAVE, Set.of(
                new Option(new Name("코카콜라 선택"), new Price(0)),
                new Option(new Name("스프라이트 변경"), new Price(0)),
                new Option(new Name("제로 콜라 변경"), new Price(0))));

        Product product_햄버거 = new Product(new Name("햄버거"), new Description("햄버거"), new Price(3_500));

        // when, then
        product_햄버거.addOptionGroup(optionGroup_음료_변경);
        assertThatThrownBy(() -> product_햄버거.addOptionGroup(optionGroup_음료_변경))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void addOptionGroups_성공() {
        // given
        OptionGroup optionGroup_음료_변경 = new OptionGroup(new Name("음료 변경"), MUST_HAVE, Set.of(
                new Option(new Name("코카콜라 선택"), new Price(0)),
                new Option(new Name("스프라이트 변경"), new Price(0)),
                new Option(new Name("제로 콜라 변경"), new Price(0))));

        OptionGroup optionGroup_사이드메뉴_변경 = new OptionGroup(new Name("사이드메뉴 변경"), MUST_HAVE, Set.of(
                new Option(new Name("감자튀김 선택"), new Price(0)),
                new Option(new Name("웨지감자 변경"), new Price(300)),
                new Option(new Name("아이스크림 변경"), new Price(300))));

        Set<OptionGroup> givenOptionGroups = Set.of(optionGroup_음료_변경, optionGroup_사이드메뉴_변경);

        Product product_햄버거 = new Product(new Name("햄버거"), new Description("햄버거"), new Price(3_500));

        // when, then
        assertDoesNotThrow(() -> product_햄버거.addOptionGroups(givenOptionGroups));
    }

    @Test
    void addOptionGroups_예외_이미_존재하는_옵션_그룹() {
        // given
        OptionGroup optionGroup_음료_변경 = new OptionGroup(new Name("음료 변경"), MUST_HAVE, Set.of(
                new Option(new Name("코카콜라 선택"), new Price(0)),
                new Option(new Name("스프라이트 변경"), new Price(0)),
                new Option(new Name("제로 콜라 변경"), new Price(0))));

        OptionGroup optionGroup_사이드메뉴_변경 = new OptionGroup(new Name("사이드메뉴 변경"), MUST_HAVE, Set.of(
                new Option(new Name("감자튀김 선택"), new Price(0)),
                new Option(new Name("웨지감자 변경"), new Price(300)),
                new Option(new Name("아이스크림 변경"), new Price(300))));

        Set<OptionGroup> givenOptionGroups = new HashSet<>(Arrays.asList(optionGroup_음료_변경, optionGroup_사이드메뉴_변경));

        Product product_햄버거 = new Product(new Name("햄버거"), new Description("햄버거"), new Price(3_500));

        // when, then
        product_햄버거.addOptionGroups(givenOptionGroups);
        assertThatThrownBy(() -> product_햄버거.addOptionGroups(givenOptionGroups))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void removeOptionGroup_성공() {
        // given
        OptionGroup optionGroup_음료_변경 = new OptionGroup(new Name("음료 변경"), MUST_HAVE, Set.of(
                new Option(new Name("코카콜라 선택"), new Price(0)),
                new Option(new Name("스프라이트 변경"), new Price(0)),
                new Option(new Name("제로 콜라 변경"), new Price(0))));

        Product product_햄버거 = new Product(new Name("햄버거"), new Description("햄버거"), new Price(3_500));

        // when
        product_햄버거.addOptionGroup(optionGroup_음료_변경);
        assertDoesNotThrow(() -> product_햄버거.removeOptionGroup(optionGroup_음료_변경));
    }

    @Test
    void removeOptionGroup_예외() {
        // given
        OptionGroup optionGroup_음료_변경 = new OptionGroup(new Name("음료 변경"), MUST_HAVE, Set.of(
                new Option(new Name("코카콜라 선택"), new Price(0)),
                new Option(new Name("스프라이트 변경"), new Price(0)),
                new Option(new Name("제로 콜라 변경"), new Price(0))));

        Product product_햄버거 = new Product(new Name("햄버거"), new Description("햄버거"), new Price(3_500));

        // when
        assertThatThrownBy(() -> product_햄버거.removeOptionGroup(optionGroup_음료_변경))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void removeOptionGroups_성공() {
        // given
        OptionGroup optionGroup_음료_변경 = new OptionGroup(new Name("음료 변경"), MUST_HAVE, Set.of(
                new Option(new Name("코카콜라 선택"), new Price(0)),
                new Option(new Name("스프라이트 변경"), new Price(0)),
                new Option(new Name("제로 콜라 변경"), new Price(0))));

        OptionGroup optionGroup_사이드메뉴_변경 = new OptionGroup(new Name("사이드메뉴 변경"), MUST_HAVE, Set.of(
                new Option(new Name("감자튀김 선택"), new Price(0)),
                new Option(new Name("웨지감자 변경"), new Price(300)),
                new Option(new Name("아이스크림 변경"), new Price(300))));

        Set<OptionGroup> givenOptionGroups = Set.of(optionGroup_음료_변경, optionGroup_사이드메뉴_변경);

        Product product_햄버거 = new Product(new Name("햄버거"), new Description("햄버거"), new Price(3_500));

        // when, then
        product_햄버거.addOptionGroups(givenOptionGroups);
        assertDoesNotThrow(() -> product_햄버거.removeOptionGroups(givenOptionGroups));
    }

    @Test
    void removeOptionGroups_예외_이미_존재하는_옵션_그룹() {
        // given
        OptionGroup optionGroup_음료_변경 = new OptionGroup(new Name("음료 변경"), MUST_HAVE, Set.of(
                new Option(new Name("코카콜라 선택"), new Price(0)),
                new Option(new Name("스프라이트 변경"), new Price(0)),
                new Option(new Name("제로 콜라 변경"), new Price(0))));

        OptionGroup optionGroup_사이드메뉴_변경 = new OptionGroup(new Name("사이드메뉴 변경"), MUST_HAVE, Set.of(
                new Option(new Name("감자튀김 선택"), new Price(0)),
                new Option(new Name("웨지감자 변경"), new Price(300)),
                new Option(new Name("아이스크림 변경"), new Price(300))));

        Set<OptionGroup> givenOptionGroups = new HashSet<>(Arrays.asList(optionGroup_음료_변경, optionGroup_사이드메뉴_변경));

        Product product_햄버거 = new Product(new Name("햄버거"), new Description("햄버거"), new Price(3_500));

        // when, then
        assertThatThrownBy(() -> product_햄버거.removeOptionGroups(givenOptionGroups))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
