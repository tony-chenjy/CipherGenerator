package org.minions.encipher.dev.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.minions.encipher.base.model.Constants;
import org.minions.encipher.etc.utils.PasswordFormatter;
import org.minions.encipher.etc.utils.encipher.Base64Util;
import org.springframework.stereotype.Service;

@Service
public class EncipherService {

    /**
     * 1. eg. admin & admin123456 = admin123456
     *
     * 2. eg. admin & admin123456 = 291c55bd5f735359196614f3fd76a5a862d6e3fc8e0b33c03fb87c3a9faf00da62dbbbe02da78315872cb52c279b68d9f28763672269bc67a19213fe81215347
     *       system & admin123456 = 291c55bd5f735359196614f3fd76a5a862d6e3fc8e0b33c03fb87c3a9faf00da62dbbbe02da78315872cb52c279b68d9f28763672269bc67a19213fe81215347
     *
     * 3. eg. admin & admin123456 = 4362762dcb46288f7bbde501aedeb3b4f9ae092a154bfc965fa382584b30782c141d6164cfda791441aeeb096692cd528c1d8919e8d0df771a0df0caeac04d34
     *       system & admin123456 = 2db7f7fcabbca04d4de14fb4b2606f433f9cc557d6ef3ecd24811a30efe22e86d121e9a92656697c136e84a24f2aa54825c58c24192ea4b5c89e83d3f3a54030
     *
     * 4. eg. jtms: admin & admin123456 = f084f6a316c1a11bbd3049544449ba91470789e7771af5c69df1fc50c9130d5e65487aff93713f650254940a1a22dfcd0e81780e926a81eab0231f15c8ecca38
     *        oam:  admin & admin123456 = a932e76f0feccca4fc73daeb4ae920fa85422382276c3c5dde43e3fa3d4ffa7b76292186cf1a7bbdac55c8e6fe6e968ce936e2630160d31861ae33e3c2329efa
     *
     * 5. eg. jtms: admin = 8e12ebea8bf8f60e40cb70bcbcf1af46b7103ce4865dc0a859348acb94a6e818979a8858eccac69824c353fade4b5af5375c7536b3c0b38d9d736a5536d95fec
     *        oam:  admin = e13affaef9143344848bc21c6eba64ee8cfd97ecd4335b8adaefc8bcbd738afc35fdd795c41170e6fc1d2f0d037ed9d50b7ef60ebcf73f90c2619a2e9cd066fd
     *
     * @param username
     * @param password
     * @param identity
     * @return
     */
    public String encipher(String username,
                           String password,
                           String identity,
                           short format,
                           int minLength,
                           int maxLength) {
        // 容错性判断
        // TODO
        if (minLength > maxLength) {
            maxLength = minLength;
        }

        String saltIdentity = DigestUtils.sha512Hex(identity); // 128个字符
        String saltUsername = DigestUtils.sha512Hex(username + saltIdentity); // 128个字符
        String sha512Result = DigestUtils.sha512Hex(password + saltUsername); // 128个字符

        StringBuilder result = new StringBuilder();
        result.append(Base64Util.encrypt(sha512Result)).append(sha512Result);

        // TODO
        if (maxLength > result.length()) {
            maxLength = result.length();
        }
        return PasswordFormatter.format(format, result.toString(), maxLength);
    }
}
