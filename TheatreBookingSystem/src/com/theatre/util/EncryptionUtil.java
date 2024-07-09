package com.theatre.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.security.SecureRandom;

/**
 * Utility class for encryption and decryption operations using
 * AES/CBC/PKCS5Padding.
 */
public class EncryptionUtil {
	private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
	private static final byte[] keyValue = "TheBestSecretKey".getBytes();
	private static final int IV_LENGTH = 16;

	/**
	 * Generates a SecretKey from the predefined key value.
	 * 
	 * @return The SecretKey object.
	 */
	private static SecretKey getSecretKey() {
		return new SecretKeySpec(keyValue, "AES");
	}

	/**
	 * Generates a random Initialisation Vector (IV).
	 * 
	 * @return The IvParameterSpec object containing the IV.
	 */
	private static IvParameterSpec generateIv() {
		byte[] iv = new byte[IV_LENGTH];
		new SecureRandom().nextBytes(iv);
		return new IvParameterSpec(iv);
	}

	/**
	 * Encrypts the given data using AES/CBC/PKCS5Padding.
	 * 
	 * @param data The data to encrypt.
	 * @return The encrypted data encoded in Base64.
	 * @throws Exception If an encryption error occurs.
	 */
	public static String encrypt(String data) throws Exception {
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		SecretKey secretKey = getSecretKey();
		IvParameterSpec ivParameterSpec = generateIv();
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
		byte[] encrypted = cipher.doFinal(data.getBytes());
		byte[] encryptedIvAndText = new byte[IV_LENGTH + encrypted.length];
		System.arraycopy(ivParameterSpec.getIV(), 0, encryptedIvAndText, 0, IV_LENGTH);
		System.arraycopy(encrypted, 0, encryptedIvAndText, IV_LENGTH, encrypted.length);
		return Base64.getEncoder().encodeToString(encryptedIvAndText);
	}

	/**
	 * Decrypts the given encrypted data using AES/CBC/PKCS5Padding.
	 * 
	 * @param encryptedData The encrypted data in Base64 format.
	 * @return The decrypted data as a string.
	 * @throws Exception If a decryption error occurs.
	 */
	public static String decrypt(String encryptedData) throws Exception {
		byte[] encryptedIvAndText = Base64.getDecoder().decode(encryptedData);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(encryptedIvAndText, 0, IV_LENGTH);
		byte[] encryptedBytes = new byte[encryptedIvAndText.length - IV_LENGTH];
		System.arraycopy(encryptedIvAndText, IV_LENGTH, encryptedBytes, 0, encryptedBytes.length);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		SecretKey secretKey = getSecretKey();
		cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
		byte[] original = cipher.doFinal(encryptedBytes);
		return new String(original);
	}
}
