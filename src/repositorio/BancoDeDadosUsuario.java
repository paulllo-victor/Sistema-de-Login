/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;
import entidades.Usuario;
import interfaces.InterfaceUsuario;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Paulo Victor
 */
public class BancoDeDadosUsuario implements InterfaceUsuario {
     Connection coneccao;
     Statement statement;
    @Override
    public boolean addUsuario(Usuario usuarioNovo) {
        boolean confirmacao = false;
         String sql = "INSERT INTO todosUsuarios(nome,login,senha) VALUES (?,?,?);";
        if(validacaoUsuario(usuarioNovo.getLogin(), usuarioNovo.getSenha()) == false){
            try {
            PreparedStatement stmt = coneccao.prepareStatement(sql);
            
            stmt.setString(1, usuarioNovo.getNome());
            stmt.setString(2, usuarioNovo.getLogin());
            stmt.setString(3, usuarioNovo.getSenha());
            stmt.execute();
            stmt.close();
            confirmacao = true;
            
        } catch (Exception e) {
            System.out.println("Errooo,Ao cadastrar usuario!!" + e.getMessage());
        }
        }      
        
        return confirmacao;
    }
    @Override
    public List<Usuario> listarUsuario() {
        List<Usuario> listaTodosUsuario = new ArrayList<>();
        String sql = "SELECT * FROM todosUsuarios";        
         try {
             PreparedStatement stmt = coneccao.prepareStatement(sql);
             ResultSet result = stmt.executeQuery();
             while (result.next()) {                 
                 Usuario novoUsuario = new Usuario(result.getInt("id"),result.getString("nome"), result.getString("login"), result.getString("senha"));
                 listaTodosUsuario.add(novoUsuario);
             }
         } catch (SQLException ex) {
             Logger.getLogger(BancoDeDadosUsuario.class.getName()).log(Level.SEVERE, null, ex);
         }
         return listaTodosUsuario;
    }

    @Override
    public boolean conexaoBanco() {
        String url = "jdbc:mysql://localhost:3306/usuario";
        String usuario = "root";
        String password = "";
        boolean conf = false;
        try {
           coneccao = DriverManager.getConnection(url, usuario, password);
           conf = true;
        } catch (SQLException ex) {
             System.out.println("Errooo,conexão com o banco de dados!!" + ex.getMessage());  
        }
        return conf;
    }

    @Override
    public boolean validacaoUsuario(String varLogin, String varSenha) {
        String sql = "SELECT * FROM todosusuarios WHERE login = ? AND senha = ?";
        boolean confimacaoCadastro = false;
         try {
             PreparedStatement stmt = coneccao.prepareStatement(sql);
             stmt.setString(1, varLogin);
             stmt.setString(2, varSenha);
             ResultSet result;
             result = stmt.executeQuery();
             if(result.next()){
                 confimacaoCadastro = true;
             }
         } catch (SQLException ex) {
             System.out.println("Errooo,ao procurar usuario no banco de dados!!" + ex.getMessage());  
         }
        return  confimacaoCadastro;
    }

    @Override
    public Usuario pegarUsuario(int id) {
        String sql = "SELECT * FROM todosusuarios WHERE id = ?";
        Usuario UsuarioDoBancoDados = null;
        PreparedStatement stmt;
         try {
             stmt = coneccao.prepareStatement(sql);
             stmt.setInt(1, id);
             ResultSet result = stmt.executeQuery();
             while (result.next()) {                 
                 UsuarioDoBancoDados = new Usuario(result.getInt("id"),result.getString("nome"), result.getString("login"), result.getString("senha"));
             }
         } catch (SQLException ex) {
             System.out.println("Errooo,ao procurar usuario no banco de dados!!" + ex.getMessage());  
         }      
         return UsuarioDoBancoDados;
    }

    @Override
    public boolean excluirUsuario(Usuario UsuarioExcluir) {
        String sql = "DELETE FROM todosusuarios WHERE login = ? and senha = ?";
        
        boolean conf = false;
         try {
             PreparedStatement stmt = coneccao.prepareStatement(sql);
             stmt.setString(1, UsuarioExcluir.getLogin());
             stmt.setString(2, UsuarioExcluir.getSenha());
             stmt.executeUpdate(); // para editar e exclui precisar usar o executeUpdate() não apenas o executeQuery();
             conf = true;
         } catch (SQLException ex) {
             System.out.println("Errooo,ao exluir usuario no banco de dados!!" + ex.getMessage());  
         }
         return conf;
    }

    @Override
    public boolean editarUsuario(String nome,String login,String senha,int id) {
        String sql = "UPDATE todosusuarios SET nome = ?,login = ?, senha = ? WHERE id = ?";
        boolean confirmacaoEdicao = false;
        try {
            PreparedStatement stmt = coneccao.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, login);
            stmt.setString(3, senha);
            stmt.setInt(4, id);
            stmt.executeUpdate(); //executa a atualizacao no banco de dados 
            confirmacaoEdicao = true;
        } catch (Exception ex) {
             System.out.println("Errooo,ao editar usuario no banco de dados!!" + ex.getMessage());  
        }       
        return confirmacaoEdicao;
    }
    
}
