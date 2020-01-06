package com.xiuuu.xiuuu.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server extends Thread {
    
    static HashMap<String, ClientHandler> connect_list = new HashMap<>();
    int listening_port;
    
    public Server(int port) throws IOException {
        this.listening_port = port;
    }

    
    public int getPort() {
        return this.listening_port;
    }
    
    @Override
    public void run() {
        try {
            startServer();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
    }
    
    public void startServer() throws IOException {
        
        ServerSocket ss = new ServerSocket(listening_port);

        while (true) {
            
            Socket s = null;
            try {
                
                // socket object to receive incoming client requests 
                s = ss.accept();
                
                System.out.println("A new client (port = " + s.getPort()  + ") is connected : " + s);
                
                // obtaining input and out streams
                ObjectOutputStream dos = new ObjectOutputStream(s.getOutputStream());
                ObjectInputStream dis = new ObjectInputStream(s.getInputStream());
                dos.flush();

                System.out.println("Assigning new thread for this client");
                
                String clientName = dis.readUTF();
                
                ClientHandler ch = new ClientHandler(s, dis, dos, clientName, s.getPort());
                Thread t = ch;
                t.start();
                
                connect_list.put(clientName, ch);

            } catch (Exception e) {
                s.close(); 
                e.printStackTrace(); 
            }
            
        }
        
    }
    
}

