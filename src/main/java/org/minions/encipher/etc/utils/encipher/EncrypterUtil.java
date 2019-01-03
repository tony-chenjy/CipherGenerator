package org.minions.encipher.etc.utils.encipher;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * 密码器
 */
public abstract class EncrypterUtil {
    /**
     * 加密
     *
     * @param plainText
     * @return
     */
    public abstract String encrypt(String plainText);

    /**
     * 解密
     *
     * @param cipherText
     * @return
     */
    public abstract String decrypt(String cipherText);
}
