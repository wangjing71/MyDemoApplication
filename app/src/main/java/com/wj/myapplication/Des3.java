package com.wj.myapplication;


import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class Des3 {
    private final static String encSecretKey = "62FB13F3AF7D9BAD07B8D4C7EB8F6110B494F158B5D44DC63161B0A239AED46E4F6E8F0F8A3CD1E0086988FA1FDD73F714BF23FC17C5CE6F32B33A0AD3200728C0BEF540BBF07D29";
    private final static String secretKey = new DesUtil().strDec(encSecretKey, "1111", "2222", "3333");
    private final static String iv = "01234567";
    private final static String encoding = "utf-8";

    public static String encode(String plainText) {
        try {
            Key deskey = null;
            DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
            SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
            deskey = keyfactory.generateSecret(spec);
            Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
            IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
            byte[] encryptData = cipher.doFinal(plainText.getBytes(encoding));
            return Base64.encode(encryptData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String decode(String encryptText) {
        try {
            Key deskey = null;
            DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
            SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
            deskey = keyfactory.generateSecret(spec);
            Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
            IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, deskey, ips);
            byte[] decryptData = cipher.doFinal(Base64.decode(encryptText));
            return new String(decryptData, encoding);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";

    }
}