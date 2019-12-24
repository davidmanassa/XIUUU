package com.xiuuu.xiuuu.design;

import com.xiuuu.xiuuu.encrypt.EncryptType;
import com.xiuuu.xiuuu.main.Main;
import com.xiuuu.xiuuu.util.JFrameUtils;
import java.awt.Dimension;
import javax.swing.JOptionPane;

public class E_newMessage extends javax.swing.JFrame {

    public E_newMessage() {
        initComponents();
        
        this.setTitle("XIUUU");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        JFrameUtils.setWindowPosition(this, 0);
        this.setMinimumSize(new Dimension(500, 350));
        
        EncryptType et = Main.getIns().getEncryptManager().getLastUsed();
        if (et == null) {
            JOptionPane.showMessageDialog(this, "Erro ao iniciar mensagem.", "Erro", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        text = new javax.swing.JLabel();
        textInput_Secret = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        text.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        text.setText(" Insira o segredo:");

        textInput_Secret.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textInput_SecretMouseClicked(evt);
            }
        });
        textInput_Secret.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                textInput_SecretInputMethodTextChanged(evt);
            }
        });
        textInput_Secret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textInput_SecretActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Courier 10 Pitch", 0, 18)); // NOI18N
        jButton1.setText("Enviar para %username%");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(text, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textInput_Secret))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text)
                .addGap(18, 18, 18)
                .addComponent(textInput_Secret, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textInput_SecretMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textInput_SecretMouseClicked
        JOptionPane.showMessageDialog(this,
            "IPs ainda não suportados.",
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_textInput_SecretMouseClicked

    private void textInput_SecretInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_textInput_SecretInputMethodTextChanged

    }//GEN-LAST:event_textInput_SecretInputMethodTextChanged

    private void textInput_SecretActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textInput_SecretActionPerformed

    }//GEN-LAST:event_textInput_SecretActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel text;
    private javax.swing.JTextField textInput_Secret;
    // End of variables declaration//GEN-END:variables
}
