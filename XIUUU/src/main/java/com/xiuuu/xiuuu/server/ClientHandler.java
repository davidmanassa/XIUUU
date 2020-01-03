package com.xiuuu.xiuuu.server;

import com.xiuuu.xiuuu.main.Main;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

class ClientHandler extends Thread { 
	
    final DataInputStream dis; 
    final DataOutputStream dos; 
    final Socket s; 
    final String id_client ;

    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos, String id_client) { 
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
                    
                    String toID = received.split("%")[1];
                    String message = received.split("%")[2];
                    
                    dos.writeUTF("Message send to " + toID + ": " + message);
                    Server.connect_list.get(toID).dos.writeUTF("messageFrom%" + id_client + "%" + message);
                    
                } else if (received.startsWith("getUserList")) {
                
                    StringBuilder out = new StringBuilder("userList");
                    ArrayList<String> users = new ArrayList<>();
                    
                    for (String s : Server.connect_list.keySet()) {
                        out.append("%").append(s);
                        users.add(s);
                    }
                    
                    dos.writeUTF(out.toString());
                    
                    Main.getIns().getC_clientList().update(users);
                        
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
                            dos.writeUTF("Invalid input: " + received);
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
