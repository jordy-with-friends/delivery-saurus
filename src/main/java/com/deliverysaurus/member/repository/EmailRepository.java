package com.deliverysaurus.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliverysaurus.member.domain.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
