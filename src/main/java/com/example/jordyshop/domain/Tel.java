package com.example.jordyshop.domain;

import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class Tel {
    private static final int TEL_MIN_LENGTH = 9;
    public static final String NUMBER_REG_EXP = "^[0-9]+$";

    @Column(name = "tel")
    private String contents;

    public Tel(String contents) {
        validate(contents);
        this.contents = contents;
    }

    private void validate(String contents) {
        if (contents.length() < TEL_MIN_LENGTH) {
            throw new IllegalArgumentException();
        }
        if (!Pattern.matches(NUMBER_REG_EXP, contents)) {
            throw new IllegalArgumentException();
        }
    }
}
