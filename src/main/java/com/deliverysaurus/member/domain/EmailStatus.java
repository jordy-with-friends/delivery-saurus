package com.deliverysaurus.member.domain;

import javax.persistence.Embeddable;

@Embeddable
public enum EmailStatus {
    RESERVATION, SEND,
}
