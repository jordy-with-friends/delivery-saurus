package com.deliverysaurus.member.ui;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import com.deliverysaurus.member.domain.Member;
import com.deliverysaurus.member.dto.EmailAuthDto;
import com.deliverysaurus.member.dto.MemberDto;
import com.deliverysaurus.member.application.MemberService;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/members")
    @ResponseBody
    public ResponseEntity<Long> addMember(MemberDto memberDto) {
        Member member = memberService.addMember(memberDto);
        return ResponseEntity.ok().body(member.getId());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/members/authorization")
    @ResponseBody
    public ResponseEntity<ResponseBody> authEmail(EmailAuthDto emailAuthDto) {
        Member member = memberService.authEmail(emailAuthDto.getAuthNumber());
        return ResponseEntity.created(URI.create("/members/" + member.getId())).build();
    }
}
