/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Enterprise.MealService;

import Model.Database.DBconnection;
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
public class MealServiceDirectory {
    public void addMealService(String name, String contact, String email){
        Connection dbconn = DBconnection.connectDB();
        try {
            PreparedStatement st = (PreparedStatement)dbconn
                    .prepareStatement("""
                                    INSERT INTO mealservice (name, contact, email) 
                                    VALUES(?,?,?)""");
            st.setString(1,name);            
            st.setString(2,contact);
            st.setString(3,email);            
            st.executeUpdate();
            
            System.out.println("meal service added"); 
            
        } catch (SQLException ex) {
            Logger.getLogger(MealServiceDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean alreadyExist(String service_name){
        Connection dbconn = DBconnection.connectDB();
        
            PreparedStatement st;
            boolean isExist = false;
        try {
            st = (PreparedStatement)dbconn.prepareStatement("""
                                                            SELECT * FROM mealservice 
                                                            WHERE name = ?""");
            st.setString(1, service_name);
            ResultSet res = st.executeQuery();
            if(res.next()){
                isExist = true;
            }
            return isExist;
        } catch (SQLException ex) {
            Logger.getLogger(MealServiceDirectory.class.getName()).log(Level.SEVERE, null, ex);
            
            return isExist;
        }
            
    }
    
    public void deleteService(String service_name){
        try {
            Connection dbconn = DBconnection.connectDB();
            
            PreparedStatement st = (PreparedStatement)dbconn.prepareStatement("""
                                                                            DELETE FROM mealservice
                                                                            WHERE name = ?""");
        
            st.setString(1, service_name);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MealServiceDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateService(String name, String contact, String email, String password){
        try {
            Connection dbconn = DBconnection.connectDB();
            PreparedStatement st = (PreparedStatement)dbconn.prepareStatement("""
                                                                            UPDATE mealservice
                                                                            SET name = ?,
                                                                            contact = ?
                                                                            WHERE name = ?""");
            st.setString(1, name);
            st.setString(2, contact);
            st.setString(3, name);
            st.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(MealServiceDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet getServiceData(String search_name){
        try {
            Connection dbconn = DBconnection.connectDB();
            
            PreparedStatement st;
            
            st = (PreparedStatement)dbconn.prepareStatement("""
                                                                    SELECT name, contact, email, created_at
                                                                    FROM mealservice
                                                                    WHERE name like ?""");
            
            st.setString(1, '%'+search_name+'%');
            ResultSet res = st.executeQuery();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(MealServiceDirectory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ResultSet exactServiceLookup(String service_name){
         
            Connection dbconn = DBconnection.connectDB();
            
        try {
            PreparedStatement st = (PreparedStatement)dbconn.prepareStatement("""
                                                                        SELECT name ,contact , 
                                                                              email
                                                                        FROM mealservice
                                                                        WHERE name = ?""");
        
            st.setString(1, service_name);
            System.out.print("tryy");
            ResultSet res = st.executeQuery();
            System.out.print("found it");
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(MealServiceDirectory.class.getName()).log(Level.SEVERE, null, ex);
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
            st.setString(3,"Meal Service Manager");
            int res = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MealServiceDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
