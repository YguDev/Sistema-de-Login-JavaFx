/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanagerfx;

/**
 *
 * @author papac
 */
public class Usuario {
    private int id;
    private String nome;
    private String senha;
    
    public Usuario (int id, String nome, String senha ){
        this.id = id;
        this.nome = nome;
        this.senha = senha;        
    }
    public int getId(){return id;}
    public String getNome(){return nome;}
    public String getSenha(){return senha;}
}
