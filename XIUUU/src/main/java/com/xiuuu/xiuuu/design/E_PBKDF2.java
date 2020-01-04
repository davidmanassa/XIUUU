package com.xiuuu.xiuuu.design;

import com.xiuuu.xiuuu.encrypt.EncryptType;
import com.xiuuu.xiuuu.encrypt.PBKDF2;
import com.xiuuu.xiuuu.main.Main;
import com.xiuuu.xiuuu.util.JFrameUtils;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;

public class E_PBKDF2 extends javax.swing.JFrame {

    String to;

    public E_PBKDF2(String to) {
        initComponents();
        
        this.to = to;
        this.setTitle("XIUUU");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        JFrameUtils.setWindowPosition(this, 0);
        this.setMinimumSize(new Dimension(500, 350));
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        text_IP = new javax.swing.JLabel();
        palavra = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        segredo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        box = new javax.swing.JComboBox<>();
        button_send = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        text_IP.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        text_IP.setText("Palavra-Passe");

        palavra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                palavraMouseClicked(evt);
            }
        });
        palavra.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                palavraInputMethodTextChanged(evt);
            }
        });
        palavra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                palavraActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel1.setText("Segredo");

        segredo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                segredoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel2.setText("Função de hash");

        box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SHA1", "SHA224", "SHA256", "SHA384", "SHA512" }));
        box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxActionPerformed(evt);
            }
        });

        button_send.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        button_send.setText("Enviar");
        button_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_sendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text_IP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(palavra, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(segredo)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(button_send, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(box, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text_IP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(palavra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(segredo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button_send, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void palavraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_palavraMouseClicked

    }//GEN-LAST:event_palavraMouseClicked

    private void palavraInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_palavraInputMethodTextChanged

    }//GEN-LAST:event_palavraInputMethodTextChanged

    private void palavraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_palavraActionPerformed

    }//GEN-LAST:event_palavraActionPerformed

    private void segredoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_segredoActionPerformed

    }//GEN-LAST:event_segredoActionPerformed

    private void boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxActionPerformed

    }//GEN-LAST:event_boxActionPerformed

    private void button_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_sendActionPerformed
        if(palavra.getText().isEmpty() || segredo.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,
                "Preencha todos os campos..",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        } else {
            
            String pass = palavra.getText();
            String segr = segredo.getText();
            int opcao = box.getSelectedIndex() + 1;

            Main.getIns().getClient().sendSecret(this.to, segr, EncryptType.PBKDF2, pass, opcao);
            dispose();
            
        }
    }//GEN-LAST:event_button_sendActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> box;
    private javax.swing.JButton button_send;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField palavra;
    private javax.swing.JTextField segredo;
    private javax.swing.JLabel text_IP;
    // End of variables declaration//GEN-END:variables
}
