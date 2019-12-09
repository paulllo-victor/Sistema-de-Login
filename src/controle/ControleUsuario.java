/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;
import interfaces.InterfaceUsuario;
import repositorio.BancoDeDadosUsuario;
import entidades.Usuario;
import java.util.List;
/**
 *
 * @author Paulo Victor
 */
public class ControleUsuario {
    private static InterfaceUsuario bancoDados;
    public ControleUsuario(){
        synchronized(InterfaceUsuario.class){
            if(bancoDados == null){
                bancoDados = new BancoDeDadosUsuario();
            }
        }
    }
    public boolean conexaoBd(){
        return bancoDados.conexaoBanco();
    }
    public boolean cadastroUsuario(String nome,String login,String senha){
        Usuario usuarioNovo = new Usuario(nome, login, senha);
        return bancoDados.addUsuario(usuarioNovo);
    }
    public boolean verificacaoCadastroUsuario(String login, String senha){
        return bancoDados.validacaoUsuario(login, senha);
    }
    public List<Usuario> listagemUsuario(){
        return bancoDados.listarUsuario();
    }
    public Usuario pegarUsuario(int id){
        return bancoDados.pegarUsuario(id);
    }
    public boolean excluirUsuario(int id){
        return  bancoDados.excluirUsuario(bancoDados.pegarUsuario(id));
    }
    public boolean editarUsuario(String nome,String login,String senha,int id){
        return bancoDados.editarUsuario( nome, login, senha, id);
    }
}
