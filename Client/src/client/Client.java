package client;

import java.io.*; 
import java.net.*; 
import java.util.Scanner; 


public class Client {
    
    
    public static void main(String[] args) throws IOException {
        
        try {
            
            Scanner scn = new Scanner(System.in); 

            // getting localhost ip 
            InetAddress ip = InetAddress.getByName("localhost"); 

            // establish the connection with server port 7000
            Socket s = new Socket(ip, 7000); 

            // obtaining input and out streams 
            DataInputStream dis = new DataInputStream(s.getInputStream()); 
            DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 

            // the following loop performs the exchange of 
            // information between client and client handler
            
            boolean first = true;
            
            while (true) { 
                
                if (first) { first = false;
                    System.out.println(dis.readUTF());
                }
                
                String tosend = scn.nextLine(); 
                dos.writeUTF(tosend); 

                // If client sends exit,close this connection 
                // and then break from the while loop 
                if (tosend.equals("Exit")) {
                    
                    System.out.println("Closing this connection : " + s); 
                    s.close(); 
                    System.out.println("Connection closed"); 
                    break; 
                } 

                // printing date or time as requested by client 
                String received = dis.readUTF(); 
                System.out.println(received); 
                
            } 

            
            // closing resources
            scn.close();
            dis.close();
            dos.close();
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
}

