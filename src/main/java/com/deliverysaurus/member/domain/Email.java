package com.deliverysaurus.member.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "email")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Member member;

    private String email;

    @Enumerated(EnumType.STRING)
    private EmailStatus emailStatus;

    private LocalDateTime sendDate;

    private LocalDateTime authDate;

    public Email(Member member, String email, LocalDateTime sendDate, LocalDateTime authDate) {
        this.member = member;
        this.email = email;
        this.emailStatus = EmailStatus.RESERVATION;
        this.sendDate = sendDate;
        this.authDate = authDate;
    }
}
