package com.deliverysaurus.member.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.deliverysaurus.member.dto.MemberDto;
import com.deliverysaurus.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    
    public void addMember(MemberDto memberDto) {
    }
}
