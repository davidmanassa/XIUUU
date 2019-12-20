package com.xiuuu.xiuuu.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server extends Thread {
    
    public static HashMap<Integer, ClientHandler> connect_list = new HashMap<>();
    int listening_port;
    
    public Server(int port) throws IOException {
        this.listening_port = port;
    }
    
    @Override
    public void run() {
        try {
            startServer();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void startServer() throws IOException {
          
        int id_client = 0;
        ServerSocket ss = new ServerSocket(listening_port);

        while (true) {
            
            Socket s = null;
            try {
                
                // socket object to receive incoming client requests 
                s = ss.accept(); 
                
                ++id_client;
                
                System.out.println("A new client (id = " + String.valueOf(id_client) + ") is connected : " + s);
                
                // obtaining input and out streams 
                DataInputStream dis = new DataInputStream(s.getInputStream()); 
                DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 

                System.out.println("Assigning new thread for this client"); 

                ClientHandler ch = new ClientHandler(s, dis, dos, id_client);
                Thread t = ch;
                t.start();
                
                connect_list.put(id_client, ch);

            } catch (Exception e) {
                s.close(); 
                e.printStackTrace(); 
            }
            
        }
        
    }
    
}

