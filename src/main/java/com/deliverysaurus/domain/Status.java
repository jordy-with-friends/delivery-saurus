package com.deliverysaurus.domain;

import javax.persistence.Embeddable;

@Embeddable
public enum Status {
    AUTHORIZING, NORMAL, WITHDRAW
}
