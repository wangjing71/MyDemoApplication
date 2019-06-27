package com.wj.myapplication;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * 3DES加密工具类
 *
 * @author 感谢原始作者liufeng
 * @date 2014-7-9
 */
public class DES3 {
	// 密钥
	private final static String secretKey = "mimajiabujiadouyiyang@dt";
	// 向量
	private final static String iv = "12345678";
	// 加解密统一使用的编码方式
	private final static String encoding = "UTF-8";
	
	public static void main(String[] args) throws Exception {
//		实现3DES加密算法，工作模式CBC，填充模式PKCS5
		String str = "网址：http://www.sina.com.cn";
		System.out.println(encode(str));
		System.out.println("s/6mnA+mZvRnZcVGd10cgUcfJ8oDWpiawdCyjZlXFQo=");
		System.out.println(decode("s/6mnA+mZvRnZcVGd10cgUcfJ8oDWpiawdCyjZlXFQo="));

		System.out.println("encode:"+encode(""));
		System.out.println("decode:"+decode(""));

	}
	
	
	/**
	 * 3DES加密
	 *
	 * @param plainText 普通文本
	 * @return
	 * @throws Exception
	 */
	public static String encode(String plainText) throws Exception {
		return encode(plainText,secretKey);
	}
	public static String encode(String plainText, String secretKey) throws Exception {
		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);

		Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
		byte[] encryptData = cipher.doFinal(plainText.getBytes(encoding));
		return Base64.encode(encryptData);
	}

	/**
	 * 3DES解密
	 *
	 * @param plainText 加密文本
	 * @return
	 * @throws Exception
	 */
	public static String decode(String plainText) throws Exception {
		return decode(plainText,secretKey);
	}
	public static String decode(String encryptText, String secretKey) throws Exception {
		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);
		Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.DECRYPT_MODE, deskey, ips);

		byte[] decryptData = cipher.doFinal(Base64.decode(encryptText));

		return new String(decryptData, encoding);
	}
}