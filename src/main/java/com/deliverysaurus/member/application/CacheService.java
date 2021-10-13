package com.deliverysaurus.member.application;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.deliverysaurus.member.domain.Member;
import com.deliverysaurus.member.util.RandNumberGenerator;

@Service
public class CacheService {

    @Cacheable(value = "emailAuthNum", key = "#memberId")
    public int getEmailAuthNumber(Long memberId) {
        throw new RuntimeException();
    }

    @CachePut(cacheNames = "emailAuthNum", key = "#member.id")
    public int saveAuthNumber(Member member) {
        return RandNumberGenerator.generate();
    }

    public void checkAuthNum(int authNumber, int emailAuthNumber) {
        if (authNumber != emailAuthNumber) {
            throw new RuntimeException("인증 번호가 서로 다릅니다.");
        }
    }
}
