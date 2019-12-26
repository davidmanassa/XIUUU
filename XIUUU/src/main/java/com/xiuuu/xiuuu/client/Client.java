package com.xiuuu.xiuuu.client;

import com.xiuuu.xiuuu.design.Z_messageReceived;
import com.xiuuu.xiuuu.main.Main;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

public class Client extends Thread {
    
    int port;
    String username;
    
    private DataInputStream dis = null; 
    private DataOutputStream dos = null;
    
    public Client(int port, String username) {
        this.port = port;
        this.username = username;
    }
    
    public static void recived(String text) {
        
        // userList%username1%username2
        if (text.startsWith("userList%")) {
            ArrayList<String> al = new ArrayList<>();
            String[] s = text.split("%");
            int i = 0;
            for (String s1 : s) {
                if (i >= 1 && i <= (s.length-1))
                    al.add(s1);
                i++;
            }
            
            Main.getIns().update(al);
        } else if (text.startsWith("messageFrom%")) {
            
            String author = text.split("%")[1], msg = text.split("%")[2];
            new Z_messageReceived(author, msg).setVisible(true);
            
        }
        
        System.out.println(text + "\n");
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public int getPort() {
        return this.port;
    }
    
    @Override
    public void run() {
        startClient();
    }
    
    public void sendSecret(String tosend, String message) throws IOException {
        this.dos.writeUTF("tosend%" + tosend + "%" + message);
    }
    
    public void send(String message) throws IOException {
        this.dos.writeUTF(message);
    }
    
    public void startClient() {
        
        try {
            
            // getting localhost ip 
            InetAddress ip = InetAddress.getByName("localhost"); 

            Socket s = new Socket(ip, port); 

            // obtaining input and out streams 
            this.dis = new DataInputStream(s.getInputStream()); 
            this.dos = new DataOutputStream(s.getOutputStream()); 

            dos.writeUTF(username);
            
            // One thread for all received content from server
            Thread t = new Receiving(dis);
            t.start();
            
            ClientService cs = new ClientService();
            cs.start();
            
            /**
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
            **/
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

