package com.example.jordyshop.member.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AddressDetailTest {

    @DisplayName("생성")
    @Test
    void create() {
        // given
        AddressDetail addressDetail = new AddressDetail("1525호");
        // when
        // then
        assertThat(addressDetail).isNotNull();
    }
}