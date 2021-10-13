package com.deliverysaurus.config.bcryption;

import com.deliverysaurus.config.EncryptionStrategy;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class BCryption implements EncryptionStrategy {
    public String encrypt(String text) {
        return BCrypt.hashpw(text, BCrypt.gensalt());
    }

    public String decrypt(String text) {
        throw new RuntimeException("Bcrypt는 복호화가 불가합니다.");
    }

    public boolean isMatch(String text, String hashed) {
        return BCrypt.checkpw(text, hashed);
    }
}
