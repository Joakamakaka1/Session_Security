package com.es.seguridadsession.utils;

import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;
import java.util.Base64;

/**
 * The type Aes util.
 */
@Component
public class AESUtil {
    private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY = "claveSuperSecreta"; // 16 caracteres

    /**
     * Encrypt string.
     *
     * @param nombreUsuario the nombre usuario
     * @return the string
     * @throws Exception the exception
     */
    public String encrypt(String nombreUsuario) throws Exception {
        String tokenSinCifrar = nombreUsuario+SECRET_KEY;

        SecretKeySpec secretKeySpec = new SecretKeySpec(Arrays.copyOf(SECRET_KEY.getBytes(),16), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] tokenCifrado = cipher.doFinal(tokenSinCifrar.getBytes());
        return Base64.getEncoder().encodeToString(tokenCifrado);
    }

    /**
     * Decrypt string.
     *
     * @param tokenCifrado the token cifrado
     * @return the string
     * @throws Exception the exception
     */
    public String decrypt(String tokenCifrado) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(Arrays.copyOf(SECRET_KEY.getBytes(),16), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] tokenDescifrado = cipher.doFinal(Base64.getDecoder().decode(tokenCifrado));
        return new String(tokenDescifrado);
    }
}
