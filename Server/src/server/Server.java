/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author Gabriel
 */

// Java implementation of Server side 
// It contains two classes : Server and ClientHandler 
// Save file as Server.java 

import java.io.*; 
import java.text.*; 
import java.util.*; 
import java.net.*; 


// Server class 
public class Server       
{ 
    
    public static Server ms;
    
    public static HashMap<Integer, Socket> connect_list = new HashMap<>();
	public static void main(String[] args) throws IOException 
	{         
            
            int id_client = 0;
		// server is listening on port 7000
		ServerSocket ss = new ServerSocket(7000); 
                
                
		
		// running infinite loop for getting 
		// client request 
		while (true) 
		{ 
			Socket s = null; 
			
			try
			{ 
				// socket object to receive incoming client requests 
				s = ss.accept(); 
				++id_client;
				System.out.println("A new client (id = " + String.valueOf(id_client) + ") is connected : " + s);
                                connect_list.put(id_client, s);
				// obtaining input and out streams 
				DataInputStream dis = new DataInputStream(s.getInputStream()); 
				DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
				
				System.out.println("Assigning new thread for this client"); 

				// create a new thread object 
				Thread t = new ClientHandler(s, dis, dos,id_client); //, Server

				// Invoking the start() method 
				t.start(); 
				
			} 
			catch (Exception e){ 
				s.close(); 
				e.printStackTrace(); 
			} 
		} 
	} 

    
} 

// ClientHandler class 
class ClientHandler extends Thread 
{ 
	
	final DataInputStream dis; 
	final DataOutputStream dos; 
	final Socket s; 
        final int id_client ;
        //MServer ms;
	

	// Constructor 
	public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos, int id_client) //, Server ms
	{ 
		this.s = s; 
		this.dis = dis; 
		this.dos = dos; 
                this.id_client = id_client;
                //this.ms = ms;
	} 

	@Override
	public void run() 
	{ 
		String received; 
		String toreturn; 
		while (true) 
		{ 
			try { 

				// Ask user what he wants 
				dos.writeUTF("Your ID = "+ String.valueOf(id_client) +"\n"+ 
							"Type Exit to terminate connection."); 
				
				// receive the answer from client 
				received = dis.readUTF(); 
				
				if(received.equals("Exit")) 
				{ 
					System.out.println("Client " + this.s + " sends exit..."); 
					System.out.println("Closing this connection."); 
					this.s.close(); 
					System.out.println("Connection closed"); 
					break; 
				} 
				
				// creating Date object 
				Date date = new Date(); 
				
				// write on output stream based on the 
				// answer from the client 
				switch (received) { 
				
					case "list" : 
						
						dos.writeUTF(Server.connect_list.keySet().toString()); //ms.connect_list.toString()
						break; 
						
					case "id" :  
						dos.writeUTF("Your id = " +id_client+"."); 
						break; 
						
					default: 
						dos.writeUTF("Invalid input"); 
						break; 
				} 
			} catch (IOException e) { 
				e.printStackTrace(); 
			} 
		} 
		
		try
		{ 
			// closing resources 
			this.dis.close(); 
			this.dos.close(); 
			
		}catch(IOException e){ 
			e.printStackTrace(); 
		} 
	} 
} 

