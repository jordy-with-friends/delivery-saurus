package com.example.jordyshop.domain;

import java.util.regex.Pattern;

public class Tel {
    private static final int TEL_MIN_LENGTH = 9;
    public static final String NUMBER_REG_EXP = "^[0-9]+$";

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
