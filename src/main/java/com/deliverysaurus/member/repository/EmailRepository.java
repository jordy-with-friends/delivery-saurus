package com.deliverysaurus.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliverysaurus.member.domain.Email;
import com.deliverysaurus.member.domain.Member;

public interface EmailRepository extends JpaRepository<Email, Long> {
    Email findEmailByMember(Member member);
}
