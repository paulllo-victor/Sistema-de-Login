/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import javax.swing.JOptionPane;
import controle.ControleUsuario;
import entidades.Usuario;
import java.awt.Component;
import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
/**
 *
 * @author Paulo Victor
 */
public class Login extends javax.swing.JPanel {
    ControleUsuario todosControleUsuario = new ControleUsuario();
    JFrame jframe = new JFrame();
    /**
     * Creates new form Login
     */
    public Login() {
        if(todosControleUsuario.conexaoBd()){
            JOptionPane.showMessageDialog(null, "Banco de dados conectado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
             }else{
            JOptionPane.showMessageDialog(null, "ERRO,Banco de dados não conectado", "ERRO", JOptionPane.INFORMATION_MESSAGE);
        }
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldLogin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        jButtonEntrar = new javax.swing.JButton();
        jButtonCadastro = new javax.swing.JButton();

        jLabel1.setText("Login");

        jLabel2.setText("Senha");

        jButtonEntrar.setText("Entrar");
        jButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });

        jButtonCadastro.setText("Cadastra-se");
        jButtonCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEntrar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(jTextFieldLogin)
                        .addComponent(jPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEntrar)
                    .addComponent(jButtonCadastro))
                .addContainerGap(112, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastroActionPerformed
        jTextFieldLogin.setText("");
        jPassword.setText("");        
        jframe.setSize(400, 400);
        CadastroUsuario  jpanel  = new CadastroUsuario();
        jframe.setContentPane(jpanel);
        jframe.setVisible(true);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
    }//GEN-LAST:event_jButtonCadastroActionPerformed

    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrarActionPerformed
        String login = jTextFieldLogin.getText();
        String senha = jPassword.getText();
        if(jTextFieldLogin.getText().length() >0 && jPassword.getText().length()>0){
            if(todosControleUsuario.verificacaoCadastroUsuario(login, senha)){
                JOptionPane.showMessageDialog(null, "Usuario com cadastro ativo!!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                jTextFieldLogin.setText("");
                jPassword.setText("");
                Component com = SwingUtilities.getRoot(this);
                ((Window) com).dispose();
                TelaInicial jpanel = new TelaInicial();
                jframe.setContentPane(jpanel);
                jframe.setSize(500, 400);
                jframe.setVisible(true);
                jframe.setResizable(false);                
                jframe.setLocationRelativeTo(null);
                
            }else{
                JOptionPane.showMessageDialog(null, "Usuario sem cadastro ativo!!", "erro", JOptionPane.YES_OPTION);
                jTextFieldLogin.setText("");
                jPassword.setText("");       
                
            }
        }else{
            JOptionPane.showMessageDialog(null, "Preencha primeiro todos os campos!!", "erro", JOptionPane.YES_OPTION);
        }
    }//GEN-LAST:event_jButtonEntrarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastro;
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JTextField jTextFieldLogin;
    // End of variables declaration//GEN-END:variables
}
