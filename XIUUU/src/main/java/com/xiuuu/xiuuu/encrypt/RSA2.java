package com.xiuuu.xiuuu.encrypt;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class RSA2 {
    
    PublicKey pk;
    PrivateKey sk;
    
    public void generateMyKeys() throws NoSuchAlgorithmException {
        
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair kp = kpg.generateKeyPair();
        
        pk = kp.getPublic();
        sk = kp.getPrivate();
        
    }
    
    
}
