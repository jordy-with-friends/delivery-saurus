package com.deliverysaurus.member.ui;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import com.deliverysaurus.member.application.CacheService;
import com.deliverysaurus.member.domain.Member;
import com.deliverysaurus.member.dto.EmailAuthDto;
import com.deliverysaurus.member.dto.MemberDto;
import com.deliverysaurus.member.application.MemberService;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final CacheService cacheService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/members")
    public ResponseEntity<ResponseBody> addMember(MemberDto memberDto) {
        Member member = memberService.addMember(memberDto);
        cacheService.saveAuthNumber(member);
        return ResponseEntity.created(URI.create("/members/" + member.getId())).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/members/authorization")
    public ResponseEntity<Long> authEmail(EmailAuthDto emailAuthDto) {
        int emailAuthNumber = cacheService.getEmailAuthNumber(emailAuthDto.getMemberId());
        cacheService.checkAuthNumber(emailAuthDto.getAuthNumber(), emailAuthNumber);
        return ResponseEntity.ok().body(emailAuthDto.getMemberId());
    }
}
