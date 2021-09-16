package com.deliverysaurus.member.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

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

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    
    public Member addMember(MemberDto memberDto) {
        Member member = new Member(
                new Name(memberDto.getName()),
                new Nickname(memberDto.getNickname()),
                memberDto.getEmail(),
                Status.AUTHORIZING,
                Rank.IRON,
                memberDto.getZipCode(),
                new Address(memberDto.getAddress(), memberDto.getAddressDetail()),
                new Tel(memberDto.getTel()),
                Gender.toGender(memberDto.getGender()),
                new Age(memberDto.getAge()),
                memberDto.getPassword()
        );

        return memberRepository.save(member);
    }
}
