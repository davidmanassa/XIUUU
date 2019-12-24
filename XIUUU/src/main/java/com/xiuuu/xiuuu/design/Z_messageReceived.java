package com.xiuuu.xiuuu.design;

import com.xiuuu.xiuuu.util.JFrameUtils;
import java.awt.Dimension;

public class Z_messageReceived extends javax.swing.JFrame {

    public Z_messageReceived() {
        initComponents();
        
        this.setTitle("XIUUU");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        JFrameUtils.setWindowPosition(this, 0);
        this.setMinimumSize(new Dimension(500, 200));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        text = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        text.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        text.setText("Recebeu uma mensagem:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text)
                .addContainerGap(266, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel text;
    // End of variables declaration//GEN-END:variables
}
