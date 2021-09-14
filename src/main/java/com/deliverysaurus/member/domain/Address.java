package com.deliverysaurus.member.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class Address {

    @Column(name = "address")
    private String contents;

    public Address(String contents) {
        this.contents = contents;
    }
}
