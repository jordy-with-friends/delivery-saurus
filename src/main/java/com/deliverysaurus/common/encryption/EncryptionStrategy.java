package com.deliverysaurus.common.encryption;

import com.deliverysaurus.common.encryption.aes.AES256;
import com.deliverysaurus.common.encryption.bcryption.BCryption;

public enum EncryptionStrategy {
    AES256 {
        @Override
        public String encrypt(String text) throws Exception {
            return new AES256().encrypt(text);
        }

        @Override
        public String decrypt(String text) throws Exception {
            return new AES256().decrypt(text);
        }

        @Override
        public boolean isMatch(String text, String hashed) throws Exception {
            return text.equals(new AES256().decrypt(hashed));
        }
    },
    BYCRYPT {
        @Override
        public String encrypt(String text) {
            return new BCryption().encrypt(text);
        }

        @Override
        public String decrypt(String text) {
            throw new RuntimeException("Bcrypt는 복호화가 불가합니다.");
        }

        @Override
        public boolean isMatch(String text, String hashed) {
            return new BCryption().isMatch(text, hashed);
        }
    };

    public abstract String encrypt(String text) throws Exception;

    public abstract String decrypt(String text) throws Exception;

    public abstract boolean isMatch(String text, String hashed) throws Exception;
}
