package com.deliverysaurus.store.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class AddressTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("주소가 공백이거나 null이면 IllegalArgumnetExceptino이 발생한다")
    public void 주소가_공백이거나_null이면_IllegalArgumnetExceptino이_발생한다(String address) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Address(address, "12345"));
    }

    @Test
    @DisplayName("주소의 길이가 40글자 초과면 IllegalArgumentException이 발생한다")
    public void 주소의_길이가_40글자_초과면_IllegalArgumentException이_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Address(generateLongString(41), "12345"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("우편번호가 공백이거나 null이면 IllegalArgumnetExceptino이 발생한다")
    public void 우편번호가_공백이거나_null이면_IllegalArgumnetExceptino이_발생한다(String zipcode) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Address(generateLongString(40), zipcode));
    }

    @Test
    @DisplayName("우편번호의 길이가 5글자가 아니면 IllegalArgumentException이 발생한다")
    public void 우편번호의_길이가_5글자가_아니면_IllegalArgumentException이_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Address(generateLongString(40), "1234"));
    }

    @Test
    @DisplayName("주소의 길이가 40글자 이하면서 우편번호의 길이가 5면 성공한다")
    public void 주소의_길이가_40글자_이하면서_우편번호의_길이가_5면_성공한다() {
        assertDoesNotThrow(() -> new Address(generateLongString(1), "12345"));
        assertDoesNotThrow(() -> new Address(generateLongString(40), "12345"));
    }

    private String generateLongString(int length) {
        String name = "";

        for (int i = 0; i < length; i++) {
            name += "a";
        }

        return name;
    }
}
