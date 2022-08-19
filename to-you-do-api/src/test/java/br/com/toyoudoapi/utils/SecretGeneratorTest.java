package br.com.toyoudoapi.utils;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecretGeneratorTest {

    private static final Logger log = LoggerFactory.getLogger(SecretGeneratorTest.class);

    @Test
    public void gerarSecret(){
        // Not workings! :(
//        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//        String secretString = Encoders.BASE64.encode(key.getEncoded());
//        log.info("Secret key: " + secretString);
    }

}
