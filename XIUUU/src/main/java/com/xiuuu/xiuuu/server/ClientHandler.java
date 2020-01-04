package com.xiuuu.xiuuu.server;

import com.xiuuu.xiuuu.main.Main;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

class ClientHandler extends Thread { 
	
    final ObjectInputStream dis; 
    final ObjectOutputStream dos; 
    final Socket s; 
    final String id_client;
    final int port;

    public ClientHandler(Socket s, ObjectInputStream dis, ObjectOutputStream dos, String clientName, int port) { 
        this.s = s; 
        this.dis = dis; 
        this.dos = dos; 
        this.id_client = clientName;
        this.port = port;
    }
    
    public int getPort() {
        return this.port;
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
                
                System.out.println(received);
                
                if (received.startsWith("tosend%")) {
                    
                    String toID = received.split("%")[1];
                    String message = received.split("%")[2];
                    
                    dos.writeUTF("Message send to " + toID + ": " + message);
                    dos.flush();
                    Server.connect_list.get(toID).dos.writeUTF("messageFrom%" + id_client + "%" + message);
                    Server.connect_list.get(toID).dos.flush();
                    
                } else if (received.startsWith("getUserList")) {
                
                    StringBuilder out = new StringBuilder("userList");
                    ArrayList<String> users = new ArrayList<>();
                    
                    for (String s : Server.connect_list.keySet()) {
                        out.append("%").append(s);
                        out.append("&").append(Server.connect_list.get(s).getPort());
                        users.add(s);
                    }
                    
                    dos.writeUTF(out.toString());
                    dos.flush();
                    
                    Main.getIns().getC_clientList().update(users);
                        
                } else {
                    
                    dos.writeUTF("Invalid input: " + received);
                    dos.flush();
                    
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
