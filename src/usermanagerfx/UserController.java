/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanagerfx;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author papac
 */

//CONTROLA A TELA E SE COMUNICA COM O USUARIODAO 
public class UserController implements Initializable {
    
    @FXML
    private TextField txtId;
    
    @FXML
    private TextField txtNome;
    
    @FXML
    private TextField txtSenha;
    private UsuarioDAO dao = new UsuarioDAO();
    
    @FXML
    private TextArea txtAreaUsuario;
    
    @FXML
    public void cadastrar(){
        dao.inserir(txtNome.getText(), txtSenha.getText());
        txtNome.clear();
        txtSenha.clear();
        listar();
    } 
    
    @FXML
    public void listar(){
        txtAreaUsuario.clear(); // limpa o que estava antes
        List<Usuario>usuarios = dao.listar();
        
        if(usuarios != null && !usuarios.isEmpty()){
            for (Usuario u : usuarios){
                txtAreaUsuario.appendText(u.getId() + " - " + u.getNome() + " - " + u.getSenha() + "\n" );
            }
        }
        else{
            txtAreaUsuario.appendText("Nenhum usuário cadastrado. \n");
        }
        
    }
    
    @FXML
    public void atualizar(){
        try {
            int id = Integer.parseInt(txtId.getText());

            if (!dao.existe(id)) {
                txtAreaUsuario.appendText("Erro: Usuário " + id + " não existe!\n");
                return;
            }

            if (txtNome.getText().isEmpty() || txtSenha.getText().isEmpty()) {
                txtAreaUsuario.appendText("Erro: Nome ou senha não podem estar vazios!\n");
                return;
            }

            dao.atualizar(txtNome.getText(), txtSenha.getText(), id);
            txtAreaUsuario.appendText("Usuário atualizado com sucesso!\n");

            txtId.clear();
            txtNome.clear();
            txtSenha.clear();

            listar();
        } catch (NumberFormatException e) {
            txtAreaUsuario.appendText("Erro: ID inválido!\n");
        }
    }
    
    @FXML
    public void deletar(){
        int id = Integer.parseInt(txtId.getText());
        dao.deletar(id);
        txtId.clear();
        txtNome.clear();
        txtSenha.clear();
        listar();
    }
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        dao.criarTabela();  // garante que a tabela exista
        listar();
    }    
    
}
