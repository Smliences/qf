package com.souvc.weixin.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
* 绫诲悕: SignUtil </br>
* 鎻忚堪: 妫�獙signature 宸ュ叿绫�</br>
* 寮�彂浜哄憳锛�souvc </br>
* 鍒涘缓鏃堕棿锛� 2015-9-29 </br>
* 鍙戝竷鐗堟湰锛歏1.0  </br>
 */
public class SignUtil {
    
    // 涓庢帴鍙ｉ厤缃俊鎭腑鐨凾oken瑕佷竴鑷�
    private static String token = "test";

    /**
    * 鏂规硶鍚嶏細checkSignature</br>
    * 璇﹁堪锛氶獙璇佺鍚�/br>
    * 寮�彂浜哄憳锛歴ouvc</br>
    * 鍒涘缓鏃堕棿锛�015-9-29  </br>
    * @param signature
    * @param timestamp
    * @param nonce
    * @return
    * @throws
     */
    public static boolean checkSignature(String signature, String timestamp,String nonce) {
        // 1.灏唗oken銆乼imestamp銆乶once涓変釜鍙傛暟杩涜瀛楀吀搴忔帓搴�
        String[] arr = new String[] { token, timestamp, nonce };
        Arrays.sort(arr);
        
        // 2. 灏嗕笁涓弬鏁板瓧绗︿覆鎷兼帴鎴愪竴涓瓧绗︿覆杩涜sha1鍔犲瘑
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }
        MessageDigest md = null;
        String tmpStr = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
            // 灏嗕笁涓弬鏁板瓧绗︿覆鎷兼帴鎴愪竴涓瓧绗︿覆杩涜sha1鍔犲瘑
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        
        content = null;
        // 3.灏唖ha1鍔犲瘑鍚庣殑瀛楃涓插彲涓巗ignature瀵规瘮锛屾爣璇嗚璇锋眰鏉ユ簮浜庡井淇�
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
    }

    /**
    * 鏂规硶鍚嶏細byteToStr</br>
    * 璇﹁堪锛氬皢瀛楄妭鏁扮粍杞崲涓哄崄鍏繘鍒跺瓧绗︿覆</br>
    * 寮�彂浜哄憳锛歴ouvc </br>
    * 鍒涘缓鏃堕棿锛�015-9-29  </br>
    * @param byteArray
    * @return
    * @throws
     */
    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    /**
    * 鏂规硶鍚嶏細byteToHexStr</br>
    * 璇﹁堪锛氬皢瀛楄妭杞崲涓哄崄鍏繘鍒跺瓧绗︿覆</br>
    * 寮�彂浜哄憳锛歴ouvc</br>
    * 鍒涘缓鏃堕棿锛�015-9-29  </br>
    * @param mByte
    * @return
    * @throws
     */
    private static String byteToHexStr(byte mByte) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A','B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];
        String s = new String(tempArr);
        return s;
    }
}