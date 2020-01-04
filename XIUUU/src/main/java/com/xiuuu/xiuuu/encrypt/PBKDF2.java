package com.xiuuu.xiuuu.encrypt;

import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class PBKDF2 {
    
    Cipher dcipher;

    byte[] random = getRandom();
    int iterationCount = 1024;
    int keyLength = 128;  //tamanho da chave
    SecretKey key;
    byte[] iv;
    
    public PBKDF2(String passPhrase, int opcao_hash) throws Exception {
        SecretKeyFactory factory = null;
        switch (opcao_hash) {
            case 1: {        //SHA1
                factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
                break;
            }
            case 2: {        //SHA224
                factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA224");
                break;
            }
            case 3: {        //SHA256
                factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
                break;
            }
            case 4: {        //SHA384
                factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA384");
                break;
            }
            case 5: {        //SHA512
                factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
                break;
            }
        }

        KeySpec spec = new PBEKeySpec(passPhrase.toCharArray(), random, iterationCount, keyLength);
        SecretKey temp = factory.generateSecret(spec);
        key = new SecretKeySpec(temp.getEncoded(), "AES");
        dcipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    }

    public String encrypt(String data) throws Exception {
        dcipher.init(Cipher.ENCRYPT_MODE, key);
        AlgorithmParameters params = dcipher.getParameters();
        iv = params.getParameterSpec(IvParameterSpec.class).getIV();
        byte[] utf8EncryptedData = dcipher.doFinal(data.getBytes());
        String base64EncryptedData;
        base64EncryptedData = new sun.misc.BASE64Encoder().encodeBuffer(utf8EncryptedData);
        return base64EncryptedData;
    }
    
    //gera aleatório
    private static byte[] getRandom() throws NoSuchAlgorithmException { 
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] random = new byte[16];
        sr.nextBytes(random);
        return random;
    }
    
}
