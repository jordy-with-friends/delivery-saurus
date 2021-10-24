package com.deliverysaurus.common.encryption.aes;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AES256 {

    private String algorithm = "AES/CBC/PKCS5Padding";
    private String key = "01234567890123456789012345678901";
    private String iv = "1234512345123456";

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
}
