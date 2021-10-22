package com.deliverysaurus.store.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;


import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class NameTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름이 공백이거나 null이면 IllegalArgumnetExceptino이 발생한다")
    public void 이름이_공백이거나_null이면_IllegalArgumnetExceptino이_발생한다(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Name(name));
    }

    @Test
    @DisplayName("이름의 길이가 20글자 초과면 IllegalArgumentException이 발생한다")
    public void 이름의_길이가_20글자_초과면_IllegalArgumentException이_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Name(generateLongName(21)));
    }

    @Test
    @DisplayName("이름의 길이가 20글자 이하면 성공한다")
    public void 이름의_길이가_20글자_이하면_성공한다() {
        assertDoesNotThrow(() -> new Name(generateLongName(1)));
        assertDoesNotThrow(() -> new Name(generateLongName(20)));
    }

    private String generateLongName(int length) {
        String name = "";

        for (int i = 0; i < length; i++) {
            name += "a";
        }

        return name;
    }
}
