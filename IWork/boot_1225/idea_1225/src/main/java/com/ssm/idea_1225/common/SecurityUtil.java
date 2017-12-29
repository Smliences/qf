package com.ssm.idea_1225.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author sml
 * @Time 2017-12-28 15:22
 **/

public class SecurityUtil {
    public static String md5(String src) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] msg = md.digest(src.getBytes());
            StringBuilder sd = new StringBuilder();
            for (int i = 0; i < msg.length; i++) {
                int x = (int)msg[i]&0xff;
                x = x + 1;
                if (x < 16) {
                    sd.append(0);
                }
                sd.append(Integer.toHexString(x));
            }
            return sd.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
