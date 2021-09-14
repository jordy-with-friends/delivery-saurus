package com.deliverysaurus.member.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AddressTest {

    @DisplayName("생성")
    @Test
    void create() {
        // given
        Address address = new Address("서울시 송파구 여의도동 15-25");
        // when
        // then
        assertThat(address).isNotNull();
    }
}
