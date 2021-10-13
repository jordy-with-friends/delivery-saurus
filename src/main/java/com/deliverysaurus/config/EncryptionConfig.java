package com.deliverysaurus.config;

import com.deliverysaurus.config.aes.AES256;
import com.deliverysaurus.config.bcryption.BCryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EncryptionConfig {

    @Autowired
    private AES256 aes256;

    @Autowired
    private BCryption bCryption;

    @Bean
    public Encryption encryption() {
        Encryption encryption = new Encryption();
        encryption.put("AES256", aes256);
        encryption.put("Bcrypt", bCryption);
        return encryption;
    }
}
