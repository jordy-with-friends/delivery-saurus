package com.example.jordyshop.domain;

import javax.persistence.Embeddable;

@Embeddable
public enum Status {
    AUTHORIZING, NORMAL, WITHDRAW
}
