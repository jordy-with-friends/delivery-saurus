package com.deliverysaurus.common.encryption;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EncryptionTest {

    @DisplayName("aes256 암호화 테스트")
    @Test
    void getEncrypted_aes256() throws Exception {
        Encryption encryption = new Encryption(EncryptionStrategy.AES256);

        String encrypted = encryption.getEncrypted("1234");

        assertThat(encrypted).isEqualTo(encryption.getEncrypted("1234"));
    }

    @DisplayName("aes256 복호화 테스트")
    @Test
    void getDecrypted_aes256() throws Exception {
        String targetText = "12345";
        Encryption encryption = new Encryption(EncryptionStrategy.AES256);

        String encrypted = encryption.getEncrypted(targetText);

        assertThat(encryption.getDecrypted(encrypted)).isEqualTo(targetText);
    }

    @DisplayName("aes256 암복호화 텍스트 비교")
    @Test
    void isMatch_aes256() throws Exception {
        String targetText = "12345";
        Encryption encryption = new Encryption(EncryptionStrategy.AES256);

        String encrypted = encryption.getEncrypted(targetText);

        assertThat(encryption.isMatched(targetText, encrypted)).isTrue();
        assertThat(encryption.isMatched(targetText + "6", encrypted)).isFalse();
    }

    @DisplayName("bcrypt 암호화 테스트")
    @Test
    void getEncrypted_bcrypt() throws Exception {
        String targetText = "1234";
        Encryption encryption = new Encryption(EncryptionStrategy.BYCRYPT);

        String encrypted = encryption.getEncrypted(targetText);

        assertThat(encrypted).isNotEqualTo(targetText);
        assertThat(encrypted.length()).isEqualTo(60); //해시화된 길이값 항상 같음
    }

    @DisplayName("bcrypt 복호화 테스트")
    @Test
    void getDecrypted_bcrypt() throws Exception {
        String targetText = "12345";
        Encryption encryption = new Encryption(EncryptionStrategy.BYCRYPT);

        String encrypted = encryption.getEncrypted(targetText);

        Throwable exception = assertThrows(RuntimeException.class, () -> {
            throw new RuntimeException("Bcrypt는 복호화가 불가합니다.");
        });
        assertThat(exception.getMessage()).isEqualTo("Bcrypt는 복호화가 불가합니다.");
    }

    @DisplayName("bcrypt 암복호화 텍스트 비교")
    @Test
    void isMatch_bcrypt() throws Exception {
        String targetText = "12345";
        Encryption encryption = new Encryption(EncryptionStrategy.BYCRYPT);

        String encrypted = encryption.getEncrypted(targetText);

        assertThat(encryption.isMatched(targetText, encrypted)).isTrue();
        assertThat(encryption.isMatched(targetText + "6", encrypted)).isFalse();
    }
}
