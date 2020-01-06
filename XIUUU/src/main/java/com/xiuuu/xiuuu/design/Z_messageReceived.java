package com.xiuuu.xiuuu.design;

import com.xiuuu.xiuuu.util.JFrameUtils;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Z_messageReceived extends javax.swing.JFrame {

    public Z_messageReceived(String author, String message) {
        initComponents();
        
        this.setTitle("XIUUU - Segredo recebido");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        JFrameUtils.setWindowPosition(this, 0);
        this.setMinimumSize(new Dimension(500, 200));
        
        setLayout(new GridLayout(0, 1));
        
        JLabel title = new JLabel();
        title.setText("Novo segredo de " + author + ":");
        if (author.equalsIgnoreCase("ERROR"))
            title.setText("ERRO AO RECEBER SEGREDO");
        title.setFont(new Font("Courier New", 1, 18));
        JTextArea jta = new JTextArea(message);
        jta.setFont(new Font("Courier New", 0, 18));
        jta.setLineWrap(true);
        jta.setWrapStyleWord(true);
        
        add(title, BorderLayout.NORTH);
        add(jta, BorderLayout.NORTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 309, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
