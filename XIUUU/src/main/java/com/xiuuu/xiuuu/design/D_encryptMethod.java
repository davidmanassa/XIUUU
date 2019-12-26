package com.xiuuu.xiuuu.design;

import com.xiuuu.xiuuu.encrypt.EncryptType;
import com.xiuuu.xiuuu.main.Main;
import com.xiuuu.xiuuu.util.JFrameUtils;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class D_encryptMethod extends javax.swing.JFrame {

    ArrayList<JRadioButton> buttons;
    String to;
    
    public D_encryptMethod(String to) {
        initComponents();
        
        this.to = to;
        buttons = new ArrayList<>();
        
        this.setTitle("XIUUU");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        JFrameUtils.setWindowPosition(this, 0);
        this.setMinimumSize(new Dimension(500, 200));
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(new GridLayout(0, 1));
        
        JLabel jl = new JLabel("Selecione o metodo de encriptação: ");
        jl.setFont(new Font("Courier New", 1, 18));
        add(jl, BorderLayout.NORTH);
        pack();
        
        JRadioButton jrb = new JRadioButton();
        jrb.setLayout(new GridLayout(0, 1));
        for (EncryptType et : EncryptType.values()) {
            JRadioButton j1 = new JRadioButton(et.name());
            j1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    for (JRadioButton j2 : buttons) {
                        j2.setSelected(false);
                    }
                    j1.setSelected(true);
                }
            });
            jrb.add(j1);
            buttons.add(j1);
        }
           
        add(jrb, BorderLayout.NORTH);
        pack();
        
        JButton button = new JButton();
        button.setFont(new Font("Courier New", 1, 18));
        button.setText("Seguinte");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (JRadioButton b : buttons)
                    if (b.isSelected())
                        for (EncryptType et1 : EncryptType.values())
                            if (et1.name().equalsIgnoreCase(b.getText())) {
                                Main.getIns().getEncryptManager().setLastUsed(et1);
                                dispose();
                                new E_newMessage(to).setVisible(true);
                            }
            }
        });
        
        add(button, BorderLayout.EAST);
        pack();
        setVisible(true);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
