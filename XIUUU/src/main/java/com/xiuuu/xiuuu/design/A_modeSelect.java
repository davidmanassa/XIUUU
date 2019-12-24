package com.xiuuu.xiuuu.design;

import com.xiuuu.xiuuu.util.JFrameUtils;
import java.awt.Dimension;

public class A_modeSelect extends javax.swing.JFrame {

    public A_modeSelect() {
        initComponents();
        this.setTitle("XIUUU");
        JFrameUtils.setWindowPosition(this, 0);
        this.setMinimumSize(new Dimension(500, 200));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        serverButton = new javax.swing.JButton();
        clientButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 200));

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel1.setText("Como deseja iniciar o programa?");

        serverButton.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        serverButton.setText("Servidor");
        serverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serverButtonActionPerformed(evt);
            }
        });

        clientButton.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        clientButton.setText("Cliente");
        clientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(serverButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(serverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void serverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverButtonActionPerformed
     
        dispose();
        // Start server
        new B_ipPortSelect(true).setVisible(true);
        
    }//GEN-LAST:event_serverButtonActionPerformed

    private void clientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientButtonActionPerformed
        
        dispose();
        // Start client
        new B_ipPortSelect(false).setVisible(true);
        
    }//GEN-LAST:event_clientButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clientButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton serverButton;
    // End of variables declaration//GEN-END:variables
}
