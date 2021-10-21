package com.deliverysaurus.member.application;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CacheServiceTest {

    @InjectMocks
    private CacheService cacheService;

    @DisplayName("인증번호비교성공")
    @Test
    void 인증번호비교성공() {
        // given
        // when
        // then
        cacheService.checkAuthNumber(111, 111);
    }

    @DisplayName("인증번호비교실패")
    @Test
    void 인증번호비교실패() {
        // given
        // when
        // then
        assertThatThrownBy(() -> cacheService.checkAuthNumber(111, 222))
                .isInstanceOf(RuntimeException.class);
    }
}
