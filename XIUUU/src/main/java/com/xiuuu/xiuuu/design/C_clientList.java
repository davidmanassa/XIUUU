package com.xiuuu.xiuuu.design;

import com.xiuuu.xiuuu.main.Main;
import com.xiuuu.xiuuu.util.JFrameUtils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class C_clientList extends JFrame {
    
    clientListPanel clp;
    
    public C_clientList() {
        this.clp = new clientListPanel();
        
        if (Main.getIns().isServer())
            this.setTitle("XIUUU Server - " + Main.getIns().getPort());
        else
            this.setTitle("XIUUU Client - " + Main.getIns().getPort() + " - " + Main.getIns().getClient().getUsername());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrameUtils.setWindowPosition(this, 0);
        this.setMinimumSize(new Dimension(500, 500));
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(new BorderLayout());
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setViewportView(clp);
        this.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            
                if (!Main.getIns().isServer()) {
                    try {
                        Main.getIns().getClient().sendString("exit");
                    } catch (IOException ex) {
                        Logger.getLogger(C_clientList.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            
            }
        });
        
    }
    
    public void update(ArrayList<String> connecteds) {
        ArrayList<JPanel> toAdd = new ArrayList<>();
        for (String c : connecteds) {
            toAdd.add(getUserPanel(c, "avatar.png"));
        }
        clp.removeAll();
        clp.addPanel(getUserPanel("Gerar segredo apartir de PBKDF2", "key.png"), 2);
        for (JPanel jp : toAdd) {
            clp.addPanel(jp, 2);
        }
    }
    
    public JPanel getUserPanel(String username, String image) {
        JPanel panel = new JPanel();
        panel.setName(username);
        panel.setLayout(new BorderLayout());
        if (!image.equalsIgnoreCase("none"))
            try {
                ImageIcon ic = new ImageIcon(new C_clientList().getClass().getClassLoader().getResource(image));
                Image aux = ic.getImage();
                JLabel imgLabel = new JLabel();
                imgLabel.setIcon(new ImageIcon(aux));
                panel.add(imgLabel, BorderLayout.WEST);
            } catch (Exception e) {
                e.printStackTrace();
            }
        JLabel usernameLabel = new JLabel();
        usernameLabel.setText(username);
        usernameLabel.setFont(new java.awt.Font("Courier New", 0, 18));
        panel.add(usernameLabel);
        panel.setBackground(Color.white);
        if (username.contains("Gerar segredo apartir de PBKDF2")) {
            panel.setBackground(Color.yellow);
            panel.addMouseListener(new MouseAdapter() {
                    private Color background;

                    @Override
                    public void mousePressed(MouseEvent e) {
                        background = getBackground();
                        panel.setBackground(Color.red);
                        repaint();
                        new D_PBKDF2().setVisible(true);
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        panel.setBackground(background);
                    }

                });
        } else if (!Main.getIns().isServer()) {
            if (username.equalsIgnoreCase(Main.getIns().getClient().getUsername()))
                panel.setBackground(Color.gray);
            else
                panel.addMouseListener(new MouseAdapter() {
                    private Color background;

                    @Override
                    public void mousePressed(MouseEvent e) {
                        background = getBackground();
                        panel.setBackground(Color.red);
                        repaint();
                        new D_encryptMethod(username).setVisible(true);
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        panel.setBackground(background);
                    }

                });
        } else
            panel.setBackground(Color.red);
        
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
        for (int i = panels.size()-1; i >= 0; i--)
            removePanel(i);
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