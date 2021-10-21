package com.deliverysaurus.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EmailAuthDto {
    private Long memberId;
    private int authNumber;
}
