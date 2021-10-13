package com.deliverysaurus.member.dto;

import lombok.Builder;
import lombok.Getter;

import com.deliverysaurus.member.domain.MemberStatus;

@Getter
@Builder
public class MemberDto {
    private String name;
    private String nickname;
    private String email;
    private MemberStatus memberStatus;
    private String zipCode;
    private String address;
    private String addressDetail;
    private String tel;
    private String gender;
    private int age;
    private String password;
}
