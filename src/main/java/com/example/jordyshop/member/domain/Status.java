package com.example.jordyshop.member.domain;

import javax.persistence.Embeddable;

@Embeddable
public enum Status {
    AUTHORIZING, NORMAL, WITHDRAW
}
