package Model.Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author naman
 */
public class DBconnection {
    //Use below line Microsoft for SQL server
//    static final String connectionUrl = "jdbc:sqlserver://DESKTOP-2C1PKQK;databaseName=nutritiondb;integratedSecurity=true;encrypt=false";
    
    //Use below line for mysql db(Vipul)
    static final String connectionUrl = "jdbc:mysql://localhost:3306/nutritiondb";
    
    public static Connection connectDB(){
        Connection conn = null;
        
        try {
            //Use below for microsoft sql server
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Use below for mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            
//            conn =  DriverManager.getConnection(connectionUrl);

            conn =  DriverManager.getConnection(connectionUrl, "root", "NEUgrad2024");
//            System.out.println("Connected to the DB");

            return conn;
        } 
        catch (SQLException ex) {
            System.out.println("Could not connect to the DB");
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static void main(String[] args){
    
        DBconnection.connectDB();
   
    }
}
