/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanagerfx;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author papac
 */

//Conecta com o banco
public class Database {
    
    //C
    private static final String URL = "jdbc:sqlite:usuario.db";
    
    public static Connection conectar(){
        try{
            return
            DriverManager.getConnection(URL);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
}
