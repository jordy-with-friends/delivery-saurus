package com.deliverysaurus.common.encryption;

public class Encryption {
    private final EncryptionStrategy encryptionStrategy;

    public Encryption(EncryptionStrategy encryptionStrategy) {
        this.encryptionStrategy = encryptionStrategy;
    }

    public String getEncrypted(String text) throws Exception {
        return encryptionStrategy.encrypt(text);
    }

    public String getDecrypted(String text) throws Exception {
        return encryptionStrategy.decrypt(text);
    }

    public boolean isMatched(String text, String hashed) throws Exception {
        return encryptionStrategy.isMatch(text, hashed);
    }
}
