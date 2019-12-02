package com.xiuuu.xiuuu.main;

import java.util.Scanner;

import com.xiuuu.xiuuu.client.Client;
import com.xiuuu.xiuuu.design.mainfx;
import com.xiuuu.xiuuu.server.Server;
import java.io.IOException;

public class Main {
    
    private static Server server;
    private static Client client;
    
    public static void main(String[] args) throws IOException {
        
        mainfx m = new mainfx();
        m.call();
        /**
        System.out.println("Digite 'server %port%' para iniciar como servidor ou 'client %port%' para iniciar como cliente.");
        
        Scanner scn = new Scanner(System.in);
        * ola
        
        while(true) {
        
            String input = scn.nextLine();

            if (input.startsWith("server ")) {

                int port = Integer.parseInt(input.split(" ")[1]);
                System.out.println("Iniciando como servidor (Porta: " + port + ")...\n");
                server = new Server(port);
                server.startServer();
                break;

            } else if (input.startsWith("client ")) {

                int port = Integer.parseInt(input.split(" ")[1]);
                System.out.println("Iniciando como cliente (Porta: " + port + ")...\n");
                client = new Client(port);
                client.startClient();
                break;

            } else {

                System.out.println("Input inválido.\n");

            }
        
        }**/
        
    }
    
}
