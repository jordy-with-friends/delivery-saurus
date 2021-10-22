package com.deliverysaurus.store.domain;

import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@Embeddable
public class Address {
    private static final int MAX_ADDRESS_LENGTH = 40;
    private static final int ZIPCODE_LENGTH = 5;

    @Column(length = MAX_ADDRESS_LENGTH)
    private String address;

    @Column(length = ZIPCODE_LENGTH)
    private String zipcode;

    public Address(String address, String zipcode) {
        validate(address, zipcode);

        this.address = address.trim();
        this.zipcode = zipcode.trim();
    }

    private void validate(String address, String zipcode) {
        Assert.isTrue(address != null && address.trim().length() > 0, "주소는 공백이면 안됩니다.");
        Assert.isTrue(address.trim().length() <= MAX_ADDRESS_LENGTH, "주소의 길이는 "+ MAX_ADDRESS_LENGTH +" 글자 이하여야 합니다");

        Assert.isTrue(zipcode != null && zipcode.trim().length() > 0, "주소는 공백이면 안됩니다.");
        Assert.isTrue(zipcode.trim().length() == ZIPCODE_LENGTH, "주소의 길이는 "+ ZIPCODE_LENGTH +" 글자 여야 합니다");
    }
}
