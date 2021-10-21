package com.deliverysaurus.member.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;

@Embeddable
@Getter
public class EmailAuthTryCount {
    private static int MIN_COUNT = 0;
    private static int MAX_COUNT = 5;

    @Column(name = "try_count")
    private int count;

    public EmailAuthTryCount() {
        this(MIN_COUNT);
    }

    public EmailAuthTryCount(int count) {
        validate(count);
        this.count = count;
    }

    private void validate(int count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException("유효하지 않는 시도 횟수 입니다.");
        }
        if (count > MAX_COUNT) {
            throw new RuntimeException("시도 횟수를 초과하였습니다.");
        }
    }
}
