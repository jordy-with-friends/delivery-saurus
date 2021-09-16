package com.deliverysaurus.member.domain;

import javax.persistence.Embeddable;

@Embeddable
public enum Gender {
    M, F;

    public static Gender toGender(String gender) {
        switch (gender) {
            case "M":
                return M;
            case "F":
                return F;
            default:
                throw new IllegalArgumentException();
        }
    }
}
