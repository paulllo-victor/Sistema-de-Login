/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import entidades.Usuario;
import java.util.List;
/**
 *
 * @author Paulo Victor
 */
public interface InterfaceUsuario {
    public boolean conexaoBanco();
    public boolean addUsuario(Usuario usuarioNovo);
    public List<Usuario> listarUsuario();
    public boolean validacaoUsuario(String varLogin, String varSenha);
    public Usuario pegarUsuario(int id);
    public boolean excluirUsuario(Usuario usuarioExcluir);
    public boolean editarUsuario(String nome,String login,String senha,int id);
}
