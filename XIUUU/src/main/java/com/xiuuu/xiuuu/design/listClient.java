package com.xiuuu.xiuuu.design;

import com.xiuuu.xiuuu.main.Main;
import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class listClient extends javax.swing.JFrame implements Cloneable {
    
    public listClient() {
        
        initComponents();
        
        // SERVER INTERFACE NOT ITERABLE ( JUST WITH A REFRESH LOOP )
        
        if (!Main.getIns().isServer()) { // CLIENT INTERFACE
            
            user_name.setText(Main.getIns().getClient().getUsername());
            
            ImageIcon ic = new ImageIcon(getClass().getClassLoader().getResource("avatar.png"));
            Image aux = ic.getImage();
            user_image.setIcon(new ImageIcon(aux));
            
            // another :  Criar loop de atualização 1-4 segundos
            JPanel newJp = new JPanel();
            
            // Set layout 
            
            for (Component c : default_client.getComponents()) {
                newJp.add(c);
            }
            
            newJp.setName("hello1");
            
            client_list.add(newJp);
            
            
        }
        
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        client_list = new javax.swing.JPanel();
        default_client = new javax.swing.JPanel();
        user_image = new javax.swing.JLabel();
        user_name = new javax.swing.JLabel();

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel2.setText(" Pesquisa");

        jTextField2.setText("Nome do cliente");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel3.setText(" Clientes conectados");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel4.setText(" Pesquisa");

        jTextField3.setText("Nome do cliente");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel5.setText(" Clientes conectados");

        user_image.setText("i");

        user_name.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        user_name.setText("Nome de utilizador");

        javax.swing.GroupLayout default_clientLayout = new javax.swing.GroupLayout(default_client);
        default_client.setLayout(default_clientLayout);
        default_clientLayout.setHorizontalGroup(
            default_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(default_clientLayout.createSequentialGroup()
                .addComponent(user_image, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(user_name)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        default_clientLayout.setVerticalGroup(
            default_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, default_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(user_image, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addComponent(user_name))
        );

        javax.swing.GroupLayout client_listLayout = new javax.swing.GroupLayout(client_list);
        client_list.setLayout(client_listLayout);
        client_listLayout.setHorizontalGroup(
            client_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(default_client, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        client_listLayout.setVerticalGroup(
            client_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(client_listLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(default_client, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(215, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(client_list, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(client_list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed

    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed

    }//GEN-LAST:event_jTextField3ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel client_list;
    private javax.swing.JPanel default_client;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel user_image;
    private javax.swing.JLabel user_name;
    // End of variables declaration//GEN-END:variables
}
