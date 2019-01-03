package org.minions.encipher.etc.utils.encipher;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;

public class Base64Util {
    public static String encrypt(String plainText) {
        String cipherText = Base64.encodeBase64String(StringUtils.getBytesUtf8(plainText));
        return cipherText;
    }

    public static String decrypt(String cipherText) {
        byte[] plainBytes = Base64.decodeBase64(cipherText);
        return new String(plainBytes);
    }

    public static void main(String[] args) {
        // base64 - YmFzZTY0
        String plainText = "base64";
        System.out.println(plainText);

        String cipherText = Base64Util.encrypt(plainText);
        System.out.println(cipherText);

        System.out.println(Base64Util.decrypt(cipherText));
    }
}
