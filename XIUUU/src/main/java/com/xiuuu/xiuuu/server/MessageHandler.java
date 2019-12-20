package com.xiuuu.xiuuu.server;

import com.xiuuu.xiuuu.util.EncryptType;

public class MessageHandler {
    
    String encryptedMessage;
    EncryptType encType;
    
    public MessageHandler(String encryptedMessage) {
        this.encryptedMessage = encryptedMessage;
        this.encType = EncryptType.None;
    }
    
    // ...
    
}
