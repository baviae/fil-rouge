package com.ecocommerce.utile;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CrypteFile {
	
	 
    private static SecretKeySpec secretKey;
    private static byte[] key;
 
    public static void setKey(String myKey) 
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); 
            secretKey = new SecretKeySpec(key, "AES");
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } 
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
 
    // Crypter le fichier de log
    public static byte[] encrypt(File strToEncrypt, String secret) 
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return cipher.doFinal(Files.readAllBytes(strToEncrypt.toPath()));
        } 
        catch (Exception e) 
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
 
    
    // Decrypter le fichier de log
    public static byte[] decrypt(File strToDecrypt, String secret) 
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return cipher.doFinal(Files.readAllBytes(strToDecrypt.toPath()));
        } 
        catch (Exception e) 
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
		return null;
    }

}
