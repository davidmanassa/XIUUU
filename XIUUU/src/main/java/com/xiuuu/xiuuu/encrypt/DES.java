package com.xiuuu.xiuuu.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class DES {
    
    public static byte[] encrypt(String message, SecretKey key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        Cipher cipher1;
        cipher1 = Cipher.getInstance("DES");
        cipher1.init(Cipher.ENCRYPT_MODE, key);
        byte[] text = message.getBytes();
        return cipher1.doFinal(text);
        
    }

    public static String decrypt(byte[] message, SecretKey key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {

        Cipher cipher1;
        cipher1 = Cipher.getInstance("DES");
        cipher1.init(Cipher.DECRYPT_MODE, key);
        byte[] text = cipher1.doFinal(message);
        String value = new String(text, "UTF-8");
        return value;
        
    }
    
}
