package com.deliverysaurus.config;

public interface EncryptionStrategy {
    String encrypt(String text) throws Exception;
    String decrypt(String text) throws Exception;
    boolean isMatch(String text, String hashed) throws Exception;
}
