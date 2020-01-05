package com.xiuuu.xiuuu.design;

import com.xiuuu.xiuuu.main.Main;
import com.xiuuu.xiuuu.server.Server;
import com.xiuuu.xiuuu.util.JFrameUtils;
import java.awt.Dimension;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class B_ipPortSelect extends javax.swing.JFrame {
    
    boolean isServer = true;
     
    public B_ipPortSelect(boolean isServer) {
        
        if (!isServer)
            this.isServer = false;
        
        initComponents();
        this.setTitle("XIUUU");
        JFrameUtils.setWindowPosition(this, 0);
        this.setMinimumSize(new Dimension(500, 200));

        this.textInput_IP.setEditable(false);
        
        if (isServer) {
            textInput_IP.setVisible(false);
            text_IP.setVisible(false);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textInput_IP = new javax.swing.JTextField();
        text_IP = new javax.swing.JLabel();
        textInput_PORT = new javax.swing.JTextField();
        button_start = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel1.setText(" PORTA");

        textInput_IP.setText("localhost");
        textInput_IP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textInput_IPMouseClicked(evt);
            }
        });

        text_IP.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        text_IP.setText(" IP");

        textInput_PORT.setText("65000");

        button_start.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        button_start.setText("Iniciar");
        button_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_startActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textInput_IP)
                    .addComponent(text_IP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addComponent(textInput_PORT)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(button_start, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(text_IP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textInput_IP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textInput_PORT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(button_start, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_startActionPerformed
        
        // start Client or server
        int port = 65000;
        String ip = "localhost";
        try {
            port = Integer.parseInt(textInput_PORT.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Numero esperado em porta.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        // IPs ainda não suportados
        
        if (isServer) {
            try {
                Server th = new Server(port);
                th.start();
                
                Main.getIns().setData(true, th, null);
                
                dispose();
                Main.getIns().getC_clientList().setVisible(true);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                "Erro ao iniciar servidor.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
                System.out.println("AAAAAAAAAA");
                Logger.getLogger(B_ipPortSelect.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            dispose();
            new B_insertClientData(port).setVisible(true);
        }
        
        
    }//GEN-LAST:event_button_startActionPerformed

    private void textInput_IPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textInput_IPMouseClicked
        JOptionPane.showMessageDialog(this,
                "IPs ainda não suportados.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_textInput_IPMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_start;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField textInput_IP;
    private javax.swing.JTextField textInput_PORT;
    private javax.swing.JLabel text_IP;
    // End of variables declaration//GEN-END:variables
}