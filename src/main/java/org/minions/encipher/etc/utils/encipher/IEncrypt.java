package org.minions.encipher.etc.utils.encipher;

public interface IEncrypt {
    /**
     * 加密
     *
     * @param plainText
     * @return
     */
    public String encrypt(String plainText);

    /**
     * 解密
     *
     * @param cipherText
     * @return
     */
    public String decrypt(String cipherText);
}
