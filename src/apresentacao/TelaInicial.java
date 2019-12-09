/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;
import controle.ControleUsuario;
import entidades.Usuario;
import java.awt.Component;
import java.awt.Window;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import oracle.jrockit.jfr.JFR;
import repositorio.BancoDeDadosUsuario;
/**
 *
 * @author Paulo Victor
 */
public class TelaInicial extends javax.swing.JPanel {
    ControleUsuario todosControleUsuario = new ControleUsuario();
    /**
     * Creates new form TelaInicial
     */
    public TelaInicial() {
        initComponents();
        DefaultTableModel modelTable = (DefaultTableModel) jTableUsuarioCadastrados.getModel();//colocar um modelo defaulf na tabela dos usuario cadastrados
        List<Usuario> listaTodosUsuario = todosControleUsuario.listagemUsuario();
        for(Usuario usuarioListado : listaTodosUsuario){
            modelTable.addRow(new Object[]{usuarioListado.getId(),usuarioListado.getNome(),usuarioListado.getLogin(),usuarioListado.getSenha()});
        }      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsuarioCadastrados = new javax.swing.JTable();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();

        jTableUsuarioCadastrados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nome", "Login", "Senha"
            }
        ));
        jScrollPane1.setViewportView(jTableUsuarioCadastrados);

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEditar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonExcluir))
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
      if(jTableUsuarioCadastrados.getSelectedRow() != -1){
          int id = (int) jTableUsuarioCadastrados.getModel().getValueAt(jTableUsuarioCadastrados.getSelectedRow(), 0);
          int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja mesmo editar esse usuario?", "Confirmacao", JOptionPane.YES_OPTION);
          Usuario editarUsuario = todosControleUsuario.pegarUsuario(id);
            if(confirmacao == JOptionPane.YES_OPTION){
                if(editarUsuario != null){                      
                      JFrame jframe = new JFrame();
                      jframe.setSize(400, 400); 
                      CadastroUsuario jpanel = new CadastroUsuario(editarUsuario);
                      jframe.setContentPane(jpanel);
                      jframe.setVisible(true);
                      jframe.setResizable(false);
                      jframe.setLocationRelativeTo(null);
                      Component com = SwingUtilities.getRoot(this);
                      ((Window) com).dispose();
                    
              }
            }
      }
      
      
      
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        if(jTableUsuarioCadastrados.getSelectedRow() != -1){      
            int id  =  (int) jTableUsuarioCadastrados.getModel().getValueAt(jTableUsuarioCadastrados.getSelectedRow(), 0); // pega o valor do id do objeto que está selecionado na tabela!! o (int) converte o getvalue para inteiro  
            
            int conf = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir esse usuario?", "Confirmacao", JOptionPane.YES_OPTION);
            if(conf == JOptionPane.YES_OPTION){
                if(todosControleUsuario.excluirUsuario(id)){
                    JOptionPane.showMessageDialog(null, "Usuario deletado com Sucesso!!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    Component com = SwingUtilities.getRoot(this);
                    ((Window) com).dispose();
                    TelaInicial novo = new TelaInicial();
                    JframePrincipal jf  = new JframePrincipal(novo);
                    jf.setResizable(false);
                
                }else{
                    JOptionPane.showMessageDialog(null, "Usuario não foi deletado!!", "Erro", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsuarioCadastrados;
    // End of variables declaration//GEN-END:variables
}
