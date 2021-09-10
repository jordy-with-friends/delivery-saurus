package com.example.jordyshop.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberTest {
    @DisplayName("생성")
    @Test
    void create() {
        // given
        Member member = new Member(
                "죠르디",
                "jordy",
                "jordy@firends.com",
                Status.AUTHORIZING,
                Rank.DIAMOND,
                "05552",
                "서울시 영등포구 영등포동 포동길 12",
                "101호",
                new Tel("01015251525"),
                Gender.M,
                15,
                "password"
        );
        // when
        // then
        assertThat(member).isNotNull();
    }
}
