package com.xiuuu.xiuuu.encrypt;

import com.xiuuu.xiuuu.client.Client;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EncryptManager {

    private EncryptType lastUsed;
    
    private HashMap<Client, EncryptType> using;

    public DigitalSignature digitalSignature;
    
    public EncryptManager() {
        this.lastUsed = null;
        this.using = new HashMap<>();
        try {
            this.digitalSignature = new DigitalSignature();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EncryptManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public EncryptType getLastUsed() {
        return this.lastUsed;
    }
    
    public void setLastUsed(EncryptType et) {
        this.lastUsed = et;
    }
    
}
