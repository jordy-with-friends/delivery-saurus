package com.deliverysaurus.common.encryption.bcryption;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class BCryption {

    public String encrypt(String text) {
        return BCrypt.hashpw(text, BCrypt.gensalt());
    }

    public boolean isMatch(String text, String hashed) {
        return BCrypt.checkpw(text, hashed);
    }
}
