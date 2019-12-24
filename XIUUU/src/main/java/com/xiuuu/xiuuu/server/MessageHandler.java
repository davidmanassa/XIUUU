package com.xiuuu.xiuuu.server;

import com.xiuuu.xiuuu.encrypt.EncryptType;

public class MessageHandler {
    
    String encryptedMessage;
    EncryptType encType;
    
    public MessageHandler(String encryptedMessage) {
        this.encryptedMessage = encryptedMessage;
        this.encType = EncryptType.None;
    }
    
    // ...
    
}
