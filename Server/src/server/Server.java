package server;

import java.io.*;
import java.util.*;
import java.net.*;

public class Server {
    
    public static Server ms;
    
    public static HashMap<Integer, ClientHandler> connect_list = new HashMap<>();
	
    public static void main(String[] args) throws IOException {
            
        int id_client = 0;
        
        // server is listening on port 5067
        ServerSocket ss = new ServerSocket(5067); 

        // running infinite loop for getting 
        // client request 
        while (true) {
            
            Socket s = null; 

            try {
                
                // socket object to receive incoming client requests 
                s = ss.accept(); 
                
                ++id_client;
                 // Put client in the list
                
                System.out.println("A new client (id = " + String.valueOf(id_client) + ") is connected: " + s + ".");
                
                // obtaining input and out streams 
                DataInputStream dis = new DataInputStream(s.getInputStream()); 
                DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 

                System.out.println("Assigning new thread for this client."); 

                
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

// ClientHandler class 
class ClientHandler extends Thread { 
	
    final DataInputStream dis; 
    final DataOutputStream dos; 
    final Socket s; 
    final int id_client ;

    
    // Constructor 
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos, int id_client) { 
            this.s = s; 
            this.dis = dis; 
            this.dos = dos; 
            this.id_client = id_client;
    } 

    @Override
    public void run() {
        
        String received;
        String toreturn;
        
        boolean first = true;
        
        while (true) {
            
            try {

                /// Just a welcome message
                if (first) { first = false;
                    dos.writeUTF("Your ID = "+ String.valueOf(id_client) +"\n Type 'exit' to terminate connection."); 
                }
                
                // receive the answer from client 
                received = dis.readUTF(); 

                if(received.equalsIgnoreCase("exit")) {
                    System.out.println("Client " + this.s + " sends exit..."); 
                    System.out.println("Closing this connection."); 
                    this.s.close();
                    System.out.println("Connection closed."); 
                    break;
                }

                // write on output stream based on the
                // answer from the client
                if (received.startsWith("tosend%")) {
                    
                    int toID = Integer.parseInt(received.split("%")[1]);
                    String message = received.split("%")[2];
                    
                    Server.connect_list.get(toID).dos.writeUTF("Message recived from " + id_client + ": " + message);
                    dos.writeUTF("Message send to " + toID + ": " + message);
                    
                } else {
                    switch (received) {

                        case "list": // Get a list of connected users
                            dos.writeUTF(Server.connect_list.keySet().toString());
                            break; 

                        case "id": // Get client ID
                            dos.writeUTF("Your ID = " + id_client + ".");
                            break;

                        case "sendmessage":
                            dos.writeUTF("Select ID: ");
                            break;

                        default:
                            dos.writeUTF("Invalid input.");
                            break;

                    }
                }
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            // closing resources 
            this.dis.close(); 
            this.dos.close(); 
        }catch(IOException e){ 
                e.printStackTrace(); 
        }
            
    }
    
} 

