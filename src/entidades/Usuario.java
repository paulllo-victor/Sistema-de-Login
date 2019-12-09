/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Paulo Victor
 */
public class Usuario {
    private int id;
    private String login;
    private String nome;
    private String senha;
    public Usuario(){
        this.login = "";
        this.nome = "";
        this.senha = "";
    }
    public Usuario(int varId,String varNome, String varLogin, String varSenha){
        setId(varId);
        setNome(varNome);
        setLogin(varLogin);
        setSenha(varSenha);
    }
    public Usuario(String varNome, String varLogin, String varSenha){
        this.id = 0;
        setNome(varNome);
        setLogin(varLogin);
        setSenha(varSenha);
    }
    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
