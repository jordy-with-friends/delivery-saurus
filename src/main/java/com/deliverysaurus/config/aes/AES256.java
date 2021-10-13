package com.deliverysaurus.config.aes;

import com.deliverysaurus.config.EncryptionStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Component
public class AES256 implements EncryptionStrategy {

    @Value("${custom.algorithm}")
    private String algorithm;

    @Value("${custom.key}")
    private String key;

    @Value("${custom.iv}")
    private String iv;

    public String encrypt(String text) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParameterSpec);

        byte[] bytes = cipher.doFinal(text.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(bytes);
    }

    public String decrypt(String cipherText) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParameterSpec);

        byte[] decoded = Base64.getDecoder().decode(cipherText);
        byte[] bytes = cipher.doFinal(decoded);
        return new String(bytes, "UTF-8");
    }

    public boolean isMatch(String text, String hashed) throws Exception {
        return text.equals(decrypt(hashed));
    }
}
