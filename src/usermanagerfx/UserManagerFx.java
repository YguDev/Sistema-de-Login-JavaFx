/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanagerfx;

import java.sql.Connection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author papac
 */

//INICIA O SISTEMA
public class UserManagerFx extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        UsuarioDAO dao = new UsuarioDAO();
        dao.criarTabela();
        
        Parent root = FXMLLoader.load(getClass().getResource("user.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("Sistema CRUD");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        launch(args);
    }
    
}
