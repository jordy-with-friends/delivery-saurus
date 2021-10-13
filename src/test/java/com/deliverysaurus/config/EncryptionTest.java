package com.deliverysaurus.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class EncryptionTest {

    @Autowired
    private Encryption encryption;

    @DisplayName("aes256 암호화 테스트")
    @Test
    void getEncrypted_aes256() throws Exception {

        EncryptionStrategy aes256 = encryption.get("AES256");

        String encrypted = aes256.encrypt("1234");

        assertThat(encrypted).isEqualTo(aes256.encrypt("1234"));
    }

    @DisplayName("aes256 복호화 테스트")
    @Test
    void getDecrypted_aes256() throws Exception {
        String targetText = "12345";
        EncryptionStrategy aes256 = encryption.get("AES256");

        String encrypted = aes256.encrypt(targetText);

        assertThat(aes256.decrypt(encrypted)).isEqualTo(targetText);
    }

    @DisplayName("aes256 암복호화 텍스트 비교")
    @Test
    void isMatch_aes256() throws Exception {
        String targetText = "12345";
        EncryptionStrategy aes256 = encryption.get("AES256");

        String encrypted = aes256.encrypt(targetText);

        assertThat(aes256.isMatch(targetText, encrypted)).isTrue();
        assertThat(aes256.isMatch(targetText + "6", encrypted)).isFalse();
    }

    @DisplayName("bcrypt 암호화 테스트")
    @Test
    void getEncrypted_bcrypt() throws Exception {
        String targetText = "1234";
        EncryptionStrategy bcrypt = encryption.get("Bcrypt");

        String encrypted = bcrypt.encrypt(targetText);

        assertThat(encrypted).isNotEqualTo(targetText);
        assertThat(encrypted.length()).isEqualTo(60); //해시화된 길이값 항상 같음
    }

    @DisplayName("bcrypt 복호화 테스트")
    @Test
    void getDecrypted_bcrypt() throws Exception {
        String targetText = "12345";
        EncryptionStrategy bcrypt = encryption.get("Bcrypt");

        String encrypted = bcrypt.encrypt(targetText);

        Throwable exception = assertThrows(RuntimeException.class, () -> {
            throw new RuntimeException("Bcrypt는 복호화가 불가합니다.");
        });
        assertThat(exception.getMessage()).isEqualTo("Bcrypt는 복호화가 불가합니다.");
    }

    @DisplayName("bcrypt 암복호화 텍스트 비교")
    @Test
    void isMatch_bcrypt() throws Exception {
        String targetText = "12345";
        EncryptionStrategy bcrypt = encryption.get("Bcrypt");

        String encrypted = bcrypt.encrypt(targetText);

        assertThat(bcrypt.isMatch(targetText, encrypted)).isTrue();
        assertThat(bcrypt.isMatch(targetText + "6", encrypted)).isFalse();
    }
}