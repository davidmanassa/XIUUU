package com.xiuuu.xiuuu.client;

import com.xiuuu.xiuuu.design.Z_messageReceived;
import com.xiuuu.xiuuu.encrypt.AES;
import com.xiuuu.xiuuu.encrypt.DiffieHellman;
import com.xiuuu.xiuuu.encrypt.EncryptManager;
import com.xiuuu.xiuuu.encrypt.EncryptType;
import com.xiuuu.xiuuu.encrypt.PBKDF2;
import com.xiuuu.xiuuu.encrypt.RSA;
import com.xiuuu.xiuuu.main.Main;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client extends Thread {
    
    static Client ins;
    
    int port;
    String username;
    
    private ObjectInputStream dis = null; 
    private ObjectOutputStream dos = null;
    
    private HashMap<String, Integer> connectedUsers = null; 
    
    public Client(int port, String username) {
        ins = this;
        this.port = port;
        this.username = username;
        this.connectedUsers = new HashMap<>();
    }
    
    public void showError(String error) {
        new Z_messageReceived("ERROR", error).setVisible(true);
    }
    
    public void showSecret(String fromUsername, String secret) {
        new Z_messageReceived(fromUsername, secret).setVisible(true);
    }
    
    public void recived(String text) {
        
        // userList%username1&port1%username2&port2
        if (text.startsWith("userList%")) {
            connectedUsers = new HashMap<>();
            ArrayList<String> al = new ArrayList<>();
            String[] s = text.split("%");
            int i = 0;
            for (String s1 : s) {
                if (i >= 1 && i <= (s.length-1)) {
                    String username = s1.split("&")[0];
                    int port = Integer.parseInt(s1.split("&")[1]);
                    al.add(username);
                    connectedUsers.put(username, port);
                }
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
    
    public String sendSecret(String username, String message, EncryptType et) {
        return sendSecret(username, message, et, "", 0);
    }
    
    public String sendSecret(String username, String message, EncryptType et, String PBKDF2pass, int PBKDF2option) {
        
        try {
            
            if (connectedUsers == null || connectedUsers.isEmpty())
                return "error";
            
            if (!connectedUsers.containsKey(username))
                return "user not found";
            
            InetAddress ip = InetAddress.getByName("localhost");
            Socket socket = new Socket(ip, connectedUsers.get(username) + 1);
            
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            
            out.writeObject(et);
            out.flush();

            if (et == EncryptType.DiffieHellman) {
                
                SecureRandom rnd = new SecureRandom();
                BigInteger P, G, x, X, Y, K;
                
                boolean b;
                do {
                    P = BigInteger.probablePrime(1024, rnd);
                    b = P.isProbablePrime(100);
                } while(!b);
                System.out.println("Generated P: " + P.toString());
                
                G = DiffieHellman.findPrimeRoot(P);
                System.out.println("Generated G: " + G.toString());
                
                x = DiffieHellman.findPrimeRoot(P);
                System.out.println("Generated x: " + x.toString());
                
                X = G.modPow(x, P);  // X = G^x mod P
                
                out.writeObject(P);
                out.flush();
                out.writeObject(G);
                out.flush();
                out.writeObject(X);
                out.flush();
                        
                Y = (BigInteger) in.readObject();
                
                K = Y.modPow(x, P);
                
                String criptograma = AES.encrypt(message, K.toString());
                out.writeObject(criptograma);
                out.flush();
                
            } else if (et == EncryptType.RSA) {
                
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream((String) in.readObject()));
              
                byte[] criptograma = RSA.encrypt(message,(PublicKey) inputStream.readObject());
                out.writeObject(criptograma);
                out.flush();
                
            } else if (et == EncryptType.MerklePuzzle) {
                
            } else if (et == EncryptType.PBKDF2) {
                
                PBKDF2 pbkdf2 = new PBKDF2(PBKDF2pass, PBKDF2option);
                String criptograma = pbkdf2.encrypt(message);
                
                out.writeObject(criptograma);
                
            }
            
            // Digital Signature
            
            PublicKey pk = EncryptManager.getIns().getDigitalSIgnature().getMyPk();
            out.writeUTF(username);
            out.flush();
            out.writeObject(pk);
            out.flush();
           
            byte[] signedMessage = EncryptManager.getIns().getDigitalSIgnature().getSignature(message);

            out.writeUTF(message);
            out.flush();
            out.writeObject(signedMessage);
            out.flush();
            
            return "success";
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | InvalidKeyException | SignatureException | NoSuchAlgorithmException | ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void sendString(String message) throws IOException {
        dos.writeUTF(message);
        dos.flush();
    }
    
    public void startClient() {
        
        try {
            
            InetAddress ip = InetAddress.getByName("localhost"); 

            Socket s = new Socket(ip, port);
            
            this.dos = new ObjectOutputStream(s.getOutputStream());
            this.dis = new ObjectInputStream(s.getInputStream());
            dos.flush();
            
            dos.writeUTF(username);
            dos.flush();
            
            // One thread for all received content from server
            Thread t = new Receiving(dis);
            t.start();
            
            Thread cs = new ClientService();
            cs.start();
            
            Thread rs = new ReceivingSecrets(s.getLocalPort());
            rs.start();
            
        }catch(Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}

class ReceivingSecrets extends Thread {
    
    int port;
    
    public ReceivingSecrets(int port) {
        this.port = port;
    }
    
    @Override
    public void run() {
        
        try {
            
            ServerSocket ss = new ServerSocket(port + 1);
            
            while (true) {
                
                Socket s = ss.accept();
                
                ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(s.getInputStream());
                
                EncryptType et = (EncryptType) in.readObject();
                
                String message = "";
                byte[] criptograma = null;
                BigInteger P = null, G = null, X, y, Y, K = null;
                
                if (et == EncryptType.DiffieHellman) {
                    
                    P = (BigInteger) in.readObject();
                    G = (BigInteger) in.readObject();
                    X = (BigInteger) in.readObject();

                    y = DiffieHellman.findPrimeRoot(P);
                
                    Y = G.modPow(y, P);  // X = g^x mod p
                    
                    out.writeObject(Y);
                    out.flush();
                    
                    K = X.modPow(y, P);
                    String cript = (String) in.readObject();
                    message = AES.decrypt(cript, K.toString());
                    
                } else if (et == EncryptType.MerklePuzzle) {
                    
                } else if (et == EncryptType.RSA) {
                    RSA.generateKey();
                    out.writeObject(RSA.PUBLIC_KEY_FILE);
                    out.flush();
                    
                    criptograma = (byte[]) in.readObject();
                    ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(RSA.PRIVATE_KEY_FILE));
                    PrivateKey privatekey = (PrivateKey) inputStream.readObject();
                    message = RSA.decrypt(criptograma,privatekey);
                    
                } else if (et == EncryptType.PBKDF2) {
                    
                    String cript = (String) in.readObject();
                    
                    // FALTA DESENCRIPTAR
                    
                    message = cript;
                    
                }
                
                // Digital Signature
                
                String receivedUsername = in.readUTF();
                PublicKey pk = (PublicKey) in.readObject();
                
                EncryptManager.getIns().getDigitalSIgnature().receivedIdentification(receivedUsername, pk);
                String messageToVerif = in.readUTF();
                byte[] signature = (byte[]) in.readObject();
                
                boolean validated = EncryptManager.getIns().getDigitalSIgnature().verifySignature(receivedUsername, messageToVerif, signature);
                if (!validated) {
                    Client.ins.showError("Recebido segredo com assinatura inválida.");
                    return;
                }
                
                    
                if (et == EncryptType.RSA) {
                    Client.ins.showSecret(receivedUsername, "Type= "+ et.toString() + 
                            "\nCriptograma= " + criptograma.toString() + 
                            "\nMensagem= " + message);
                } else if (et == EncryptType.DiffieHellman) {
                    Client.ins.showSecret(receivedUsername, "Type= " + et.toString() +
                            "\nP= " + P.toString() +
                            "\nG= " + G.toString() +
                            "\nK= " + K.toString() +
                            "\nMensagem= " + message);
                } else {
                    Client.ins.showSecret(receivedUsername, "Type= " + et.toString() +
                            "\nMensagem= " + message);
                }
                
            }
        
        } catch (ClassNotFoundException | NoSuchAlgorithmException | InvalidKeyException | SignatureException | IOException ex) {
            Logger.getLogger(ReceivingSecrets.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class Receiving extends Thread {
    
    ObjectInputStream dis;
    
    public Receiving(ObjectInputStream dis) {
        this.dis = dis;
    }
    
    @Override
    public void run() {
        
        while (true) {
            
            try {
           
                String received = dis.readUTF();
                Client.ins.recived(received);
            
            } catch (IOException ioe) {
             
                Client.ins.recived("DEBUG (message received exception): " + ioe.toString());
                
            }
        }
    }
}

