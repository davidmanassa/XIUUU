package com.xiuuu.xiuuu.design;

import com.xiuuu.xiuuu.util.JFrameUtils;
import java.awt.Dimension;
import javax.swing.JOptionPane;

public class A_modeSelect extends javax.swing.JFrame {

    public A_modeSelect() {
        initComponents();
        this.setTitle("XIUUU");
        this.setMinimumSize(new Dimension(500, 200));
        JFrameUtils.setWindowPosition(this, 0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        serverButton = new javax.swing.JButton();
        clientButton = new javax.swing.JButton();
        helpCommand = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        helpCommand.setFont(new java.awt.Font("Courier 10 Pitch", 0, 18)); // NOI18N
        helpCommand.setText("Ajuda");
        helpCommand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpCommandActionPerformed(evt);
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
                    .addComponent(serverButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(helpCommand, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(helpCommand)
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

    private void helpCommandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpCommandActionPerformed
        
        JOptionPane.showMessageDialog(this,
                    "Encontra aqui uma pequena ajuda caso tenha dúvidas ao operar com a nossa aplicação.\n" +
"\n" +
"Após iniciar o programa, será apresentada uma janela onde poderá optar por ser utilizador para poder enviar mensagens a outros utilizadores, ou escolher ser um servidor.\n" +
"\n" +
"1.Se escolher iniciar como Servidor poderá inserir o número da porta manualmenteou manter o que se encontra por defeito.\n" +
"\n" +
"2.Caso pretenda optar pelo modo cliente o utilizador fará o mesmo processo como para o Servidor pois o IP está predefinido para localhost.\n" +
"\n" +
"2.1.De seguida, pode inserir o nome de utilizador que pretende.\n" +
"\n" +
"2.2.Depois de seleccionar o modo cliente poderá escolher o utilizador para o qual pretende enviar um segredo ou gerar um segredo a partir de PBKDF2.\n" +
"\n" +
"2.3.Após escolher gerar um segredo a partir de PBKDF2 o utilizador terá de inseriruma palavra passe, o segredo a enviar e escolher a função de hash a utilizar.\n" +
"\n" +
"2.4.Ao clicar em cliente o utilizador poderá escolher a opção de encriptação.  As op-ções disponíveis são: RSA,DiffieHellman, MerkelPuzzle, PreDistributedKey.\n" +
"\n" +
"2.5.Se selecionar a opção RSA,DiffieHellman ou PreDistributedKey (figura 1.7) será redirecionado para uma interface igual à da figura 1.8. Nesta o utilizador poderá inserir o segredo e envia-lo. \n" +
"\n" +
"2.6.Caso o utilizador deseje utilizar o método de encriptação MerklePuzzle terá deinserir o segredo que deseja enviar e o modo de cifra.\n" +
"\n" +
"2.7.Depois de ser enviado o segredo criptográfico a partir do David, o João irá receber a informação numa nova janela com os tipo de encriptação usada, o segredo e o modo de cifra.",
                    "Info",
                JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_helpCommandActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clientButton;
    private javax.swing.JButton helpCommand;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton serverButton;
    // End of variables declaration//GEN-END:variables
}
