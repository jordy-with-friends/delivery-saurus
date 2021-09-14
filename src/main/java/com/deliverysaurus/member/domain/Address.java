package com.deliverysaurus.member.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class Address {

    @Column(name = "address")
    private String address;

    @Column(name = "address_detail")
    private String detail;

    public Address(String address, String detail) {
        this.address = address;
        this.detail = detail;
    }
}
