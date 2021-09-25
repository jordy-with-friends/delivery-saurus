package com.deliverysaurus.member.application;

import static com.deliverysaurus.member.fixture.MemberFixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.deliverysaurus.member.domain.Address;
import com.deliverysaurus.member.domain.Age;
import com.deliverysaurus.member.domain.Gender;
import com.deliverysaurus.member.domain.Member;
import com.deliverysaurus.member.domain.Name;
import com.deliverysaurus.member.domain.Nickname;
import com.deliverysaurus.member.domain.Rank;
import com.deliverysaurus.member.domain.Status;
import com.deliverysaurus.member.domain.Tel;
import com.deliverysaurus.member.dto.MemberDto;
import com.deliverysaurus.member.repository.MemberRepository;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @DisplayName("유저 생성 테스트")
    @Test
    void 유저_생성_테스트() {
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
        when(memberRepository.save(any())).thenReturn(member);
        Member actual = memberService.addMember(memberDto);

        // then
        assertThat(actual.getName()).isEqualTo(new Name(NAME));
    }
}
