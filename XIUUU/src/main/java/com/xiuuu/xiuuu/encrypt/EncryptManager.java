package com.xiuuu.xiuuu.encrypt;

import com.xiuuu.xiuuu.client.Client;
import java.util.ArrayList;
import java.util.HashMap;

public class EncryptManager {

    private EncryptType lastUsed;
    
    private HashMap<Client, EncryptType> using;

    
    public EncryptManager() {
        this.lastUsed = null;
        this.using = new HashMap<>();
    }
    
    public EncryptType getLastUsed() {
        return this.lastUsed;
    }
    
    public void setLastUsed(EncryptType et) {
        this.lastUsed = et;
    }
    
}
