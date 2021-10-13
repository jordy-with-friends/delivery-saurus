package com.deliverysaurus.member.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmailTest {

    private static final String NAME = "죠르디";
    private static final String NICKNAME = "jordy";
    private static final String EMAIL = "jordy@firends.com";
    private static final String ZIP_CODE = "05552";
    private static final String ADDRESS = "서울시 영등포구 영등포동 포동길 12";
    private static final String ADDRESS_DETAIL = "101호";
    private static final String TEL = "01015251525";
    private static final int AGE = 15;
    private static final String PASSWORD = "password";


    @DisplayName("생성")
    @Test
    void 생성() {
        // given
        Member member = new Member(
                new Name(NAME),
                new Nickname(NICKNAME),
                MemberStatus.AUTHORIZING,
                Rank.DIAMOND,
                ZIP_CODE,
                new Address(ADDRESS, ADDRESS_DETAIL),
                new Tel(TEL),
                Gender.M,
                new Age(AGE),
                PASSWORD
        );

        // when
        Email email = new Email(
                member,
                EMAIL,
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        // then
        assertThat(email).isNotNull();
    }
}
