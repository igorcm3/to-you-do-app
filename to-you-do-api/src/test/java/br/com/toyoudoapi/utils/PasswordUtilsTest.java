package br.com.toyoudoapi.utils;

import br.com.toyoudoapi.configs.security.utils.PasswordUtils;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtilsTest {
    private static final String SENHA = "123456";
    private final BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();

    @Test
    public void testSenhaNula() throws Exception {
        assertNull(PasswordUtils.gerarBCrypt(null));
    }

    @Test
    public void testGerarHashSenha() throws Exception {
        String hash = PasswordUtils.gerarBCrypt(SENHA);

        assertTrue(bCryptEncoder.matches(SENHA, hash));
    }
}
