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

//IMPORTAÇÃO DO BANCO
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//USUARIODAO SERVE PARA ORGANIZAR E CONVERSA/ACESSA COM O BD
//CRUD
public class UsuarioDAO {
    
    public void criarTabela(){
        String sql = "CREATE TABLE IF NOT EXISTS usuario (" +
                      "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                      "nome TEXT, " +
                      "senha TEXT)";
        
        try(Connection conn = Database.conectar(); Statement stmt = conn.createStatement()){
            stmt.execute(sql);
        }catch(Exception e){
            e.printStackTrace();
        }   
    }
    
    public void inserir(String nome, String senha){
        String sql = "INSERT INTO usuario (nome, senha) VALUES(?,?)";
        
        try(Connection conn = Database.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setString(1, nome);
            stmt.setString(2, senha);
            
            stmt.executeUpdate();
            System.out.println("Usuário Cadastrado");
            
        }
        //TRATAMENTO DE ERRO MOSTRANDO ONDE ESTA 
        catch(Exception e){
            e.printStackTrace();
        }  
    }
    
    public List<Usuario> listar(){
        
        List<Usuario> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM usuario";
            
            try{
               Connection conn = Database.conectar();
               Statement stmt = conn.createStatement();
               ResultSet rs  = stmt.executeQuery(sql);
               
               while(rs.next()){
                   Usuario u = new Usuario (rs.getInt("id"),
                                            rs.getString("nome"),
                                            rs.getString("senha")
                                            );
                   lista.add(u);
               }
            }catch(Exception e){
                e.printStackTrace();
            }
            return lista;
        }
    
    public void atualizar(String nome, String senha, int id){
        String sql = "UPDATE usuario SET nome = ?, senha = ? WHERE id = ? ";
        
        try{
           Connection conn = Database.conectar();
           PreparedStatement stmt = conn.prepareStatement(sql);
           
           stmt.setString(1, nome);
           stmt.setString(2, senha);
           stmt.setInt(3, id);
           
           stmt.executeUpdate();
            System.out.println("ATUALIZADO!");
           
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void deletar(int id){
        
        String sql = "DELETE FROM usuario WHERE id = ?";
        try{
            Connection conn = Database.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("DELETADO!");
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean existe(int id){
        String sql = "SELECT COUNT(*) AS total FROM usuario WHERE id = ?";
        
        try (Connection conn = Database.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                return rs.getInt("total") > 0; //RETORNA VERDADEIRO SE FUNCIONAR
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
