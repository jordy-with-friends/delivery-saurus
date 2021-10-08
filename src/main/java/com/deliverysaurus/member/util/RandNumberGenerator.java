package com.deliverysaurus.member.util;

import java.util.Random;

public class RandNumberGenerator {

    public static final int MIN_NUMBER = 100000;
    public static final int MAX_NUMBER = 999999;

    public static int generate() {
        Random rand = new Random();
        return rand.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
    }
}
