package com.example.jordyshop.member.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "member")
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String nickname;

    private String email;

    @Embedded
    @Enumerated(EnumType.STRING)
    private Status status;

    @Embedded
    @Enumerated(EnumType.STRING)
    private Rank rank;

    @Column(length = 5)
    private String zipCode;

    @Embedded
    private Address address;

    private String addressDetail;

    private String tel;

    @Embedded
    private Gender gender;

    private int age;

    @Column(length = 20)
    private String password;

    public Member(String name, String nickname, String email, Status status, Rank rank, String zipCode, Address address, String addressDetail, String tel, Gender gender, int age, String password) {
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.status = status;
        this.rank = rank;
        this.zipCode = zipCode;
        this.address = address;
        this.addressDetail = addressDetail;
        this.tel = tel;
        this.gender = gender;
        this.age = age;
        this.password = password;
    }
}
