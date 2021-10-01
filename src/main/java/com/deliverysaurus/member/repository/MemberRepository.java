package com.deliverysaurus.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliverysaurus.member.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
