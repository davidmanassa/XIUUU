package com.xiuuu.xiuuu.encrypt;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class MerklePuzzle {
    
    Cipher cipher;

    public SecureRandom random = new SecureRandom();

    public MerklePuzzle() {
        try {
            cipher = Cipher.getInstance("DES");
        } catch (javax.crypto.NoSuchPaddingException | java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String random_string(int length) {
        // Gera uma random string com o tamanho dado
        String k = new BigInteger(400, random).toString(32);
        k = k.substring(0, length);
        return k;
    }

    public SecretKey random_key(int length) {
        // Adiciona zeros á string como padding devido ao tamnho ser muito pequeno
        byte[] k = (this.random_string(length) + "00000000").getBytes();
        try {
            DESKeySpec sks = new DESKeySpec(k);
            SecretKeyFactory sf = SecretKeyFactory.getInstance("DES");
            return sf.generateSecret(sks);
        } catch (java.security.spec.InvalidKeySpecException | java.security.NoSuchAlgorithmException | java.security.InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] encrypt(SecretKey key, String data) {
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] utf8 = data.getBytes("UTF8");
            byte[] ciphertext = cipher.doFinal(utf8);
            return ciphertext;
        } catch (UnsupportedEncodingException | InvalidKeyException ex) {
            Logger.getLogger(MerklePuzzle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(MerklePuzzle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(MerklePuzzle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String decrypt(SecretKey key, byte[] ciphertext) {
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] utf8 = cipher.doFinal(ciphertext);
            return new String(utf8, "UTF8");
        } catch (UnsupportedEncodingException | java.security.InvalidKeyException ex) {
            Logger.getLogger(MerklePuzzle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(MerklePuzzle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(MerklePuzzle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
