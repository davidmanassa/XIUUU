package com.xiuuu.xiuuu.encrypt;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class DigitalSignature {
    
    
    
    public String getPrivateKey() throws NoSuchAlgorithmException {
        
        KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
        gen.initialize(2048);
        KeyPair key = gen.generateKeyPair();

        return Base64.getMimeEncoder().encodeToString(key.getPrivate().getEncoded());
    }
    
    public String getPublicKey() throws NoSuchAlgorithmException {
        
        KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
        gen.initialize(2048);
        KeyPair key = gen.generateKeyPair();

        return Base64.getMimeEncoder().encodeToString(key.getPublic().getEncoded());
    }
    
}
