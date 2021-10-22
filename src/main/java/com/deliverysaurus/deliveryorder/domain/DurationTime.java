package com.deliverysaurus.deliveryorder.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.Embeddable;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Embeddable
public class DurationTime {
    private int minimumTime;
    private int maximumTime;

    public DurationTime(int minimumTime, int maximumTime) {
        validate(minimumTime, maximumTime);

        this.minimumTime = minimumTime;
        this.maximumTime = maximumTime;
    }

    private void validate(int minimumTime, int maximumTime) {
        Assert.isTrue(minimumTime >= 0, "최소 소요 시간은 0보다 커야합니다.");
        Assert.isTrue(maximumTime >= 0, "최대 소요 시간은 0보다 커야합니다.");

        Assert.isTrue(minimumTime <= maximumTime, "최소 소요시간이 최대 소요시간보다 클 수는 없습니다.");
    }
}
