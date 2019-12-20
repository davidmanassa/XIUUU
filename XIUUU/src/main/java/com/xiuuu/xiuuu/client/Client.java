package com.xiuuu.xiuuu.client;

import com.xiuuu.xiuuu.server.Server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner; 
import java.util.logging.Level;
import java.util.logging.Logger;


public class Client extends Thread {
    
    int port;
    String username;
    
    public Client(int port, String username) {
        this.port = port;
        this.username = username;
    }
    
    public static void recived(String text) {
        System.out.println(text + "\n");
    }
    
    public String getUsername() {
        return this.username;
    }
    
    @Override
    public void run() {
        startClient();
    }
    
    public void startClient() {
        
        try {
            
            Scanner scn = new Scanner(System.in); 

            // getting localhost ip 
            InetAddress ip = InetAddress.getByName("localhost"); 

            Socket s = new Socket(ip, port); 

            // obtaining input and out streams 
            DataInputStream dis = new DataInputStream(s.getInputStream()); 
            DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 

            // One thread for all received content from server
            Thread t = new Receiving(dis);
            t.start();
            
            while (true) { 
                
                String tosend = scn.nextLine(); 
                dos.writeUTF(tosend); 

                if (tosend.equals("Exit")) {
                    
                    System.out.println("Closing this connection : " + s); 
                    s.close(); 
                    t.stop();
                    System.out.println("Connection closed"); 
                    break; 
                } 
                
            } 

            scn.close();
            dis.close();
            dos.close();
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}

class Receiving extends Thread {
    
    DataInputStream dis;
    
    public Receiving(DataInputStream dis) {
        this.dis = dis;
    }
    
    @Override
    public void run() {
        
        while (true) {
            
            try {
           
                String received = dis.readUTF();
                Client.recived(received);
            
            } catch (IOException ioe) {
             
                Client.recived("DEBUG (message received exception): " + ioe.toString());
                
            }
        }
    }
}

