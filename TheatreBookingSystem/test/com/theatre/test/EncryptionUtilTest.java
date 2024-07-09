package com.theatre.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.theatre.util.EncryptionUtil;

/**
 * Unit tests for the EncryptionUtil class.
 */
public class EncryptionUtilTest {

    /**
	 * Test encrypting and decrypting data to ensure the original data is recovered.
	 */
    @Test
    public void testEncryptDecrypt() {
        String originalText = "SensitiveData123";

        try {
            // Encrypt the original text
            String encryptedText = EncryptionUtil.encrypt(originalText);
            assertNotNull(encryptedText, "Encrypted text should not be null");
            assertNotEquals(originalText, encryptedText, "Encrypted text should not be the same as the original text");

            // Decrypt the encrypted text
            String decryptedText = EncryptionUtil.decrypt(encryptedText);
            assertNotNull(decryptedText, "Decrypted text should not be null");
            assertEquals(originalText, decryptedText, "Decrypted text should match the original text");
        } catch (Exception e) {
            fail("Exception: " + e.getMessage());
        }
    }
}
