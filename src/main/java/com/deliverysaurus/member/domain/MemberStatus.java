package com.deliverysaurus.member.domain;

import javax.persistence.Embeddable;

@Embeddable
public enum MemberStatus {
    AUTHORIZING, NORMAL, WITHDRAW
}
