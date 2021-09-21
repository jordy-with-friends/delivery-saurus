package com.deliverysaurus.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliverysaurus.member.domain.Member;
import com.deliverysaurus.member.domain.Nickname;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findMemberByNickname(Nickname nickname);
}
