package com.xiuuu.xiuuu.design;

import com.xiuuu.xiuuu.server.Server;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ipPortSelect extends javax.swing.JFrame {
    
    boolean isServer = true;
     
    public ipPortSelect(boolean isServer) {
        
        if (!isServer)
            this.isServer = false;
        
        initComponents();
        this.setTitle("XIUUU");
        this.textInput_IP.setEditable(false);
        
        if (isServer) {
            textInput_IP.setVisible(false);
            text_IP.setVisible(false);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        textInput_IP = new javax.swing.JTextField();
        text_IP = new javax.swing.JLabel();
        textInput_PORT = new javax.swing.JTextField();
        button_start = new javax.swing.JButton();

        jButton1.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jButton1.setText("Servidor");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel1.setText(" PORTA");

        textInput_IP.setText("localhost");
        textInput_IP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textInput_IPMouseClicked(evt);
            }
        });
        textInput_IP.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                textInput_IPInputMethodTextChanged(evt);
            }
        });
        textInput_IP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textInput_IPActionPerformed(evt);
            }
        });

        text_IP.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        text_IP.setText(" IP");

        textInput_PORT.setText("65000");
        textInput_PORT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textInput_PORTActionPerformed(evt);
            }
        });

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(button_start))
                    .addComponent(text_IP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textInput_IP, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textInput_PORT, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
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

    private void textInput_IPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textInput_IPActionPerformed
    }//GEN-LAST:event_textInput_IPActionPerformed

    private void textInput_PORTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textInput_PORTActionPerformed
    }//GEN-LAST:event_textInput_PORTActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    }//GEN-LAST:event_jButton1ActionPerformed

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
                Thread th = new Server(port);
                th.start();
                
                dispose();
                //new clientList().setVisible(true);
                new listClient().setVisible(true);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                "Erro ao iniciar servidor.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ipPortSelect.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            dispose();
            new insertClientData(port).setVisible(true);
        }
        
        
    }//GEN-LAST:event_button_startActionPerformed

    private void textInput_IPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textInput_IPMouseClicked
        JOptionPane.showMessageDialog(this,
                "IPs ainda não suportados.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_textInput_IPMouseClicked

    private void textInput_IPInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_textInput_IPInputMethodTextChanged

    }//GEN-LAST:event_textInput_IPInputMethodTextChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_start;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField textInput_IP;
    private javax.swing.JTextField textInput_PORT;
    private javax.swing.JLabel text_IP;
    // End of variables declaration//GEN-END:variables
}