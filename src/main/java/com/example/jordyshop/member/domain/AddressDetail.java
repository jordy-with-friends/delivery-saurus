package com.example.jordyshop.member.domain;

import javax.persistence.Embeddable;

import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class AddressDetail {
    private String contents;

    public AddressDetail(String contents) {
        this.contents = contents;
    }
}
