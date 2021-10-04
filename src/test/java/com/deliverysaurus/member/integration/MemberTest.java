package com.deliverysaurus.member.integration;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.deliverysaurus.member.application.MemberService;
import com.deliverysaurus.member.domain.Email;
import com.deliverysaurus.member.domain.Member;
import com.deliverysaurus.member.domain.Nickname;
import com.deliverysaurus.member.dto.MemberDto;
import com.deliverysaurus.member.repository.EmailRepository;
import com.deliverysaurus.member.repository.MemberRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class MemberTest {

    private static final String NAME = "죠르디";
    private static final String NICKNAME = "jordy";
    private static final String EMAIL = "jordy@firends.com";
    private static final String ZIP_CODE = "05552";
    private static final String ADDRESS = "서울시 영등포구 영등포동 포동길 12";
    private static final String ADDRESS_DETAIL = "101호";
    private static final String TEL = "01015251525";
    private static final String GENDER = "M";
    private static final int AGE = 15;
    private static final String PASSWORD = "password";

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private MemberService memberService;

    @DisplayName("회원 가입 결과")
    @Test
    void 회원_가입_결과() {
        // given
        MemberDto memberDto = MemberDto.builder()
                .name(NAME)
                .nickname(NICKNAME)
                .email(EMAIL)
                .zipCode(ZIP_CODE)
                .address(ADDRESS)
                .addressDetail(ADDRESS_DETAIL)
                .tel(TEL)
                .gender(GENDER)
                .age(AGE)
                .password(PASSWORD)
                .build();

        // when
        memberService.addMember(memberDto);
        Member member = memberRepository.findMemberByNickname(new Nickname(NICKNAME));
        Email email = emailRepository.findEmailByMember(member);

        // then
        assertThat(email.getEmail()).isEqualTo(EMAIL);
    }
}
