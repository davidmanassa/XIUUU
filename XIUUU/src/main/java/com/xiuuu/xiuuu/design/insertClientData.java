package com.xiuuu.xiuuu.design;

import com.xiuuu.xiuuu.client.Client;
import com.xiuuu.xiuuu.main.Main;

public class insertClientData extends javax.swing.JFrame {

    int port;
    
    public insertClientData(int port) {
        this.port = port;
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textInput_IP = new javax.swing.JTextField();
        text = new javax.swing.JLabel();
        textInput_username = new javax.swing.JTextField();
        button_confirm = new javax.swing.JButton();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        text.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        text.setText(" Username");

        textInput_username.setText("Nome de Utilizador");

        button_confirm.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        button_confirm.setText("Confirmar");
        button_confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_confirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textInput_username, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(button_confirm)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textInput_username, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(button_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textInput_IPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textInput_IPMouseClicked

    }//GEN-LAST:event_textInput_IPMouseClicked

    private void textInput_IPInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_textInput_IPInputMethodTextChanged

    }//GEN-LAST:event_textInput_IPInputMethodTextChanged

    private void textInput_IPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textInput_IPActionPerformed

    }//GEN-LAST:event_textInput_IPActionPerformed

    private void button_confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_confirmActionPerformed

        // NEED TO VERIFY USERNAME FOR ILEGAL INPUT
        
        Client client = new Client(port, textInput_username.getText()); 
        client.start();
        
        Main.getIns().setData(false, null, client);
        dispose();
        new listClient().setVisible(true);

    }//GEN-LAST:event_button_confirmActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_confirm;
    private javax.swing.JLabel text;
    private javax.swing.JTextField textInput_IP;
    private javax.swing.JTextField textInput_username;
    // End of variables declaration//GEN-END:variables
}
