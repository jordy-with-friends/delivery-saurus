package com.deliverysaurus.member.application;

import java.time.LocalDateTime;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.deliverysaurus.member.domain.Address;
import com.deliverysaurus.member.domain.Age;
import com.deliverysaurus.member.domain.Email;
import com.deliverysaurus.member.domain.Gender;
import com.deliverysaurus.member.domain.Member;
import com.deliverysaurus.member.domain.Name;
import com.deliverysaurus.member.domain.Nickname;
import com.deliverysaurus.member.domain.Rank;
import com.deliverysaurus.member.domain.MemberStatus;
import com.deliverysaurus.member.domain.Tel;
import com.deliverysaurus.member.dto.MemberDto;
import com.deliverysaurus.member.repository.EmailRepository;
import com.deliverysaurus.member.repository.MemberRepository;
import com.deliverysaurus.member.util.RandNumberGenerator;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final EmailRepository emailRepository;

    public Member addMember(MemberDto memberDto) {
        Member member = new Member(
                new Name(memberDto.getName()),
                new Nickname(memberDto.getNickname()),
                MemberStatus.AUTHORIZING,
                Rank.IRON,
                memberDto.getZipCode(),
                new Address(memberDto.getAddress(), memberDto.getAddressDetail()),
                new Tel(memberDto.getTel()),
                Gender.valueOf(memberDto.getGender()),
                new Age(memberDto.getAge()),
                memberDto.getPassword()
        );

        memberRepository.save(member);
        emailRepository.save(new Email(
                member,
                memberDto.getEmail(),
                LocalDateTime.now(),
                LocalDateTime.now()
        ));

        authCacheSave(member);

        return member;
    }

    public Member authEmail(Long authNumber) {
        // 이메일 인증 번호를 조회
        // authNumber와 같은지 비교
        return null;
    }

    @Cacheable(value = "emailAuth", key = "#member.nickname")
    public int authCacheSave(Member member) {
        return RandNumberGenerator.generate();
    }
}
