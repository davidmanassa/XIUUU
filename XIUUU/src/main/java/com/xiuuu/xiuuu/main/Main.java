package com.xiuuu.xiuuu.main;

import com.xiuuu.xiuuu.client.Client;
import com.xiuuu.xiuuu.design.A_modeSelect;
import com.xiuuu.xiuuu.design.C_clientList;
import com.xiuuu.xiuuu.encrypt.EncryptManager;
import com.xiuuu.xiuuu.server.Server;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    
    private static Main main;
    
    private int port;
    
    private boolean isServer = false;
    private Server server = null;
    private Client client = null;
    
    private C_clientList cl;
    private EncryptManager em;
    
    public static Main getIns() {
        return main;
    }
    
    public void setData(boolean isServer, Server server, Client client) {
        this.isServer = isServer;
        this.server = server;
        this.client = client;
    }
    
    public boolean isServer() {
        return isServer;
    }
    
    public Client getClient() {
        return client;
    }
    
    public Server getServer() {
        return server;
    }
    
    public EncryptManager getEncryptManager() {
        return this.em;
    }
    
    public C_clientList getC_clientList() {
        if (this.cl == null)
            cl = new C_clientList();
        return cl;
    }
    
    public int getPort() {
        if (isServer)
            return getServer().getPort();
        else
            return getClient().getPort();
    }
    
    public void update(ArrayList<String> connecteds) {
        if (cl != null)
            cl.update(connecteds);
    }
    
    public Main() {
        this.main = this;
        em = new EncryptManager();
        
        new A_modeSelect().setVisible(true);
    }
    
    public static void main(String[] args) throws IOException {
        new Main();  
    }
    
}
