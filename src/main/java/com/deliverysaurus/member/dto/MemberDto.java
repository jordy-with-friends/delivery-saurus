package com.deliverysaurus.member.dto;

import lombok.Getter;

import com.deliverysaurus.member.domain.Address;
import com.deliverysaurus.member.domain.Age;
import com.deliverysaurus.member.domain.Gender;
import com.deliverysaurus.member.domain.Name;
import com.deliverysaurus.member.domain.Nickname;
import com.deliverysaurus.member.domain.Rank;
import com.deliverysaurus.member.domain.Status;
import com.deliverysaurus.member.domain.Tel;

@Getter
public class MemberDto {
    private String name;
    private String nickname;
    private String email;
    private Status status;
    private Rank rank;
    private String zipCode;
    private String address;
    private String addressDetail;
    private String tel;
    private Gender gender;
    private int age;
    private String password;
}
