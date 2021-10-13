package com.deliverysaurus.member.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Name name;

    @Embedded
    private Nickname nickname;

    @Embedded
    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    @Embedded
    @Enumerated(EnumType.STRING)
    private Rank rank;

    @Column(length = 5)
    private String zipCode;

    @Embedded
    private Address address;

    @Embedded
    private Tel tel;

    @Embedded
    private Gender gender;

    @Embedded
    private Age age;

    @Column(length = 20)
    private String password;

    public Member(Name name, Nickname nickname, MemberStatus status, Rank rank, String zipCode, Address address, Tel tel, Gender gender, Age age, String password) {
        this.name = name;
        this.nickname = nickname;
        this.status = status;
        this.rank = rank;
        this.zipCode = zipCode;
        this.address = address;
        this.tel = tel;
        this.gender = gender;
        this.age = age;
        this.password = password;
    }
}
