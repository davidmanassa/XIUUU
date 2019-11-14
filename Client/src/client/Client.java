package client;

import java.io.*; 
import java.net.*; 
import java.util.Scanner; 


public class Client {
    
    public static void recived(String text) {
        System.out.println(text);
    }
    
    
    public static void main(String[] args) throws IOException {
        
        try {
            
            Scanner scn = new Scanner(System.in); 

            // getting localhost ip 
            InetAddress ip = InetAddress.getByName("localhost"); 

            // establish the connection with server port 5067
            Socket s = new Socket(ip, 5067); 

            // obtaining input and out streams 
            DataInputStream dis = new DataInputStream(s.getInputStream()); 
            DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
            
            // One thread for all received content from server
            Thread t = new Receiving(dis);
            t.start();
            
            
            while (true) {
                
                String tosend = scn.nextLine(); // Read from command line 
                dos.writeUTF(tosend); 

                // If client sends exit, close this connection and then break from the while loop 
                if (tosend.equalsIgnoreCase("exit")) {
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

