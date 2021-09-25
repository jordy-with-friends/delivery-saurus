package com.deliverysaurus.member.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static com.deliverysaurus.member.fixture.MemberFixture.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberTest {
    @DisplayName("생성")
    @Test
    void create() {
        // given
        Member member = new Member(
                new Name(NAME),
                new Nickname(NICKNAME),
                EMAIL,
                Status.AUTHORIZING,
                Rank.DIAMOND,
                ZIP_CODE,
                new Address(ADDRESS, ADDRESS_DETAIL),
                new Tel(TEL),
                Gender.M,
                new Age(AGE),
                PASSWORD
        );
        // when
        // then
        assertThat(member).isNotNull();
    }
}
