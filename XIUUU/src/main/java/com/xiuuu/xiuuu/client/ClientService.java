package com.xiuuu.xiuuu.client;

import com.xiuuu.xiuuu.main.Main;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientService extends Thread {
    
    @Override
    public void run() {
        
        while(true) {
            
            try {
                
                Main.getIns().getClient().sendString("getUserList");
                
                this.sleep(2000);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
    }
    
    
}
