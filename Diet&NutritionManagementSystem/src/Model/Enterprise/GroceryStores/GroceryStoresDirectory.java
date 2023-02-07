/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Enterprise.GroceryStores;

//import Model.Account.Account;
import Model.Database.DBconnection;
import Model.Organization.ProductDirectory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author naman
 */
public class GroceryStoresDirectory {
    
    public void addStore(String name, String contact, String email){
        Connection dbconn = DBconnection.connectDB();
        try {
            PreparedStatement st = (PreparedStatement)dbconn
                    .prepareStatement("""
                                    INSERT INTO grocerystores (name, contact, email) 
                                    VALUES(?,?,?)""");
            st.setString(1,name);            
            st.setString(2,contact);
            st.setString(3,email);            
            st.executeUpdate();
            
            System.out.println("store added"); 
            
        } catch (SQLException ex) {
            Logger.getLogger(GroceryStoresDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean alreadyExist(String store_name){
        Connection dbconn = DBconnection.connectDB();
        
            PreparedStatement st;
            boolean isExist = false;
        try {
            st = (PreparedStatement)dbconn.prepareStatement("""
                                                            SELECT * FROM grocerystores 
                                                            WHERE name = ?""");
            st.setString(1, store_name);
            ResultSet res = st.executeQuery();
            if(res.next()){
                isExist = true;
            }
            return isExist;
        } catch (SQLException ex) {
            Logger.getLogger(GroceryStoresDirectory.class.getName()).log(Level.SEVERE, null, ex);
            
            return isExist;
        }
            
    }
    
    public void deleteStore(String store_name){
        try {
            Connection dbconn = DBconnection.connectDB();
            
            PreparedStatement st = (PreparedStatement)dbconn.prepareStatement("""
                                                                            DELETE FROM grocerystores
                                                                            WHERE name = ? """);
        
            st.setString(1, store_name);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GroceryStoresDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateStore(String name, String contact, String email, String password){
        try {
            Connection dbconn = DBconnection.connectDB();
            PreparedStatement st = (PreparedStatement)dbconn.prepareStatement("""
                                                                            UPDATE grocerystores
                                                                            SET name = ?,
                                                                            contact = ?
                                                                            WHERE name = ?""");
            st.setString(1, name);
            st.setString(2, contact);
            st.setString(3, name);
            st.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(GroceryStoresDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet getStoreData(String search_name){
        try {
            Connection dbconn = DBconnection.connectDB();
            
            PreparedStatement st;
            
            st = (PreparedStatement)dbconn.prepareStatement("""
                                                                    SELECT name, contact, email, created_at
                                                                    FROM grocerystores
                                                                    WHERE name like ? """);
            
            st.setString(1, '%'+search_name+'%');
            ResultSet res = st.executeQuery();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(GroceryStoresDirectory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ResultSet exactStoreLookup(String store_name){
         
            Connection dbconn = DBconnection.connectDB();
            
        try {
            PreparedStatement st = (PreparedStatement)dbconn.prepareStatement("""
                                                                        SELECT name ,contact , 
                                                                              email
                                                                        FROM grocerystores
                                                                        WHERE name = ?""");
        
            st.setString(1, store_name);
            System.out.print("tryy");
            ResultSet res = st.executeQuery();
            System.out.print("found it");
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(GroceryStoresDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
            return null;
    }
    
    public void addUserCredential(String email, String password){
        try {
            Connection dbconn = DBconnection.connectDB();
            
            PreparedStatement st = (PreparedStatement)dbconn.prepareStatement(
                    "INSERT INTO users (email,password,usertype) VALUES(?,?,?)");
            st.setString(1, email);
            st.setString(2, password);
            st.setString(3,"Grocery Store Manager");
            int res = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GroceryStoresDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getUserNameFromEmail(String email_id){
        
        Connection dbconn = DBconnection.connectDB();
        PreparedStatement st;
        String name = null;
        try{
            st = (PreparedStatement)dbconn.prepareStatement("SELECT name from grocerystores WHERE email=?");
            st.setString(1, email_id);
            ResultSet res = st.executeQuery();
            
            while(res.next()){
                name = res.getString("Name");
                System.out.println(name);     
            }
            return name;
        }
        catch(SQLException ex){
            Logger.getLogger(GroceryStoresDirectory.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }
        
        
        
    }
}
