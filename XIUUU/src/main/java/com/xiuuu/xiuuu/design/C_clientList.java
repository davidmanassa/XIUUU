package com.xiuuu.xiuuu.design;

import com.xiuuu.xiuuu.client.Client;
import com.xiuuu.xiuuu.main.Main;
import com.xiuuu.xiuuu.util.JFrameUtils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class C_clientList extends JFrame {
    
    clientListPanel clp;
    
    public C_clientList() {
        this.clp = new clientListPanel();
        
        this.setTitle("XIUUU");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrameUtils.setWindowPosition(this, 0);
        this.setMinimumSize(new Dimension(500, 500));
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(new BorderLayout());
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setViewportView(clp);
        this.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
    }
    
    public void update(ArrayList<String> connecteds) {
        clp.removeAll();
        for (String c : connecteds) {
            System.out.println(" " + c);
                clp.addPanel(getUserPanel(c, "avatar.png"), 2);
        }
    }
    
    public JPanel getUserPanel(String username, String image) {
        JPanel panel = new JPanel();
        panel.setName(username);
        panel.setLayout(new BorderLayout());
        ImageIcon ic = new ImageIcon(getClass().getClassLoader().getResource("avatar.png"));
        Image aux = ic.getImage();
        JLabel imgLabel = new JLabel();
        imgLabel.setIcon(new ImageIcon(aux));
        panel.add(imgLabel, BorderLayout.WEST);
        JLabel usernameLabel = new JLabel();
        usernameLabel.setText(username);
        usernameLabel.setFont(new java.awt.Font("Courier New", 0, 18));
        panel.add(usernameLabel);
        panel.setBackground(Color.white);
        if (!Main.getIns().isServer()) {
            panel.addMouseListener(new MouseAdapter() {
                private Color background;

                @Override
                public void mousePressed(MouseEvent e) {
                    background = getBackground();
                    setBackground(Color.RED);
                    repaint();
                    new D_encryptMethod().setVisible(true);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    setBackground(background);
                }
                
            });
        }
        
        return panel;
    }
    
}


class clientListPanel extends JPanel {
    
    private JPanel fillerPanel;
    private ArrayList<JPanel> panels;

    public clientListPanel(List<JPanel> panels, int height) {
        this(panels, height, new Insets(2, 0, 2, 0));
    }

    public clientListPanel(List<JPanel> panels, int height, Insets insets) {
        this();
        for (JPanel panel : panels)
            addPanel(panel, height, insets);
    }

    public clientListPanel() {
        super();
        this.fillerPanel = new JPanel();
        this.fillerPanel.setMinimumSize(new Dimension(0, 0));
        this.panels = new ArrayList<JPanel>();
        setLayout(new GridBagLayout());
    }

    public void addPanel(JPanel p, int height) {
        addPanel(p, height, new Insets(2, 0, 2, 0));
    }

    public void addPanel(JPanel p, int height, Insets insets) {
        super.remove(fillerPanel);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = getComponentCount();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.ipady = height;
        gbc.insets = insets;
        gbc.weightx = 1.0;
        panels.add(p);
        add(p, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = getComponentCount();
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weighty = 1.0;
        add(fillerPanel, gbc);
        revalidate();
        invalidate();
        repaint();
    }
    
    @Override
    public void removeAll() {
        for (int i = 0; i < panels.size(); i++)
            removePanel(0);
    }

    public void removePanel(JPanel p) {
        removePanel(panels.indexOf(p));
    }

    public void removePanel(int i) {
        super.remove(i);
        panels.remove(i);
        revalidate();
        invalidate();
        repaint();
    }

    public ArrayList<JPanel> getPanels() {
        return this.panels;
    }

    
}