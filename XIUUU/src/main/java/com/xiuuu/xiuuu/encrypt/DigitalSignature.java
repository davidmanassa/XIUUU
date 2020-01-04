package com.xiuuu.xiuuu.encrypt;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;

public class DigitalSignature {
    
    PublicKey myPk = null;
    PrivateKey mySk = null;
    
    HashMap<String, PublicKey> publicKeys = null;
    
    public DigitalSignature() throws NoSuchAlgorithmException {
        KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
        gen.initialize(2048);
        KeyPair key = gen.generateKeyPair();
        this.myPk = key.getPublic();
        this.mySk = key.getPrivate();
        this.publicKeys = new HashMap<>();
    }
    
    public String getMyPk(String nickname) throws NoSuchAlgorithmException {
        return (nickname + "%" + Base64.getEncoder().encodeToString(myPk.getEncoded()));
    }
    
    // author%pk
    public void receivedIdentification(String received) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] data = Base64.getDecoder().decode((received.split("%")[1].getBytes()));
        X509EncodedKeySpec spec = new X509EncodedKeySpec(data);
        KeyFactory fact = KeyFactory.getInstance("RSA");
        publicKeys.put(received.split("%")[0], fact.generatePublic(spec));
    }
    
    public boolean verifySignature(String author, String message, String signature) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature sign = Signature.getInstance("SHA256withRSA");
        sign.initVerify(publicKeys.get(author));
        byte[] bytes = message.getBytes();
        sign.update(bytes);
        return sign.verify(Base64.getDecoder().decode(signature));
    }
    
    public String getSignedMessage(String message) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature sign = Signature.getInstance("SHA256withRSA");
        sign.initSign(mySk);
        byte[] bytes = message.getBytes();
        sign.update(bytes);
        byte[] signature = sign.sign();
        return ( message + "%" + Base64.getEncoder().encodeToString(signature) );
    }
    
    /**
    public String getSHA256Hash(String text) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(text.getBytes("UTF-8"));
        StringBuffer hexString = new StringBuffer();

        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }**/
    
}
