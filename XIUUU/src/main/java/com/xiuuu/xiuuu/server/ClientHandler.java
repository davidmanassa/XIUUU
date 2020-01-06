package com.xiuuu.xiuuu.server;

import com.xiuuu.xiuuu.main.Main;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

class ClientHandler extends Thread { 
	
    final ObjectInputStream in; 
    final ObjectOutputStream out; 
    final Socket s; 
    final String username;
    final int port;

    public ClientHandler(Socket s, ObjectInputStream in, ObjectOutputStream out, String clientName, int port) { 
        this.s = s; 
        this.in = in; 
        this.out = out; 
        this.username = clientName;
        this.port = port;
    }
    
    public int getPort() {
        return this.port;
    }

    @Override
    public void run() {
        
        String received;
        
        while (true) {
            
            try {
                
                received = in.readUTF(); 

                if (received.equalsIgnoreCase("exit")) {
                    System.out.println("Client " + this.s + " sends exit..."); 
                    System.out.println("Closing this connection.");
                    
                    Server.connect_list.remove(username);
                    
                    this.in.close();
                    this.out.close();
                    this.s.close();
                    
                    System.out.println("Connection closed."); 
                    break;
                } else if (received.startsWith("tosend%")) {
                    
                    String toID = received.split("%")[1];
                    String message = received.split("%")[2];
                    
                    out.writeUTF("Message send to " + toID + ": " + message);
                    out.flush();
                    Server.connect_list.get(toID).out.writeUTF("messageFrom%" + username + "%" + message);
                    Server.connect_list.get(toID).out.flush();
                    
                } else if (received.startsWith("getUserList")) {
                
                    StringBuilder output = new StringBuilder("userList");
                    ArrayList<String> users = new ArrayList<>();
                    
                    for (String s : Server.connect_list.keySet()) {
                        output.append("%").append(s);
                        output.append("&").append(Server.connect_list.get(s).getPort());
                        users.add(s);
                    }
                    
                    out.writeUTF(output.toString());
                    out.flush();
                    
                    Main.getIns().getC_clientList().update(users);
                        
                } else {
                    
                    out.writeUTF("Invalid input: " + received);
                    out.flush();
                    
                }
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            // closing resources 
            this.in.close(); 
            this.out.close(); 
        }catch(IOException e){ 
                e.printStackTrace(); 
        }
            
    }
    
} 
