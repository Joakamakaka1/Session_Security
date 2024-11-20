package com.es.seguridadsession.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * The type Aes util.
 */
public class AESUtil {
    private static final String ALGORITHM = "AES";
    private static final byte[] SECRET_KEY = "MySecretAESKey123".getBytes(); // Clave secreta de 16 bytes

    /**
     * Encrypt string.
     *
     * @param data the data
     * @return the string
     * @throws Exception the exception
     */
    public static String encrypt(String data) throws Exception {
        SecretKey key = new SecretKeySpec(SECRET_KEY, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    /**
     * Decrypt string.
     *
     * @param encryptedData the encrypted data
     * @return the string
     * @throws Exception the exception
     */
    public static String decrypt(String encryptedData) throws Exception {
        SecretKey key = new SecretKeySpec(SECRET_KEY, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] original = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(original);
    }
}
