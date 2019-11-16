package com.xiuuu.xiuuu.server;

public class MessageHandler {
    
    String encryptedMessage;
    EncryptType encType;
    
    public MessageHandler(String encryptedMessage) {
        this.encryptedMessage = encryptedMessage;
        this.encType = EncryptType.None;
    }
    
    // ...
    
}
