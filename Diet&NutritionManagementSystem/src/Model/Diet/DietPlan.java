/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Diet;

import Model.Database.DBconnection;
import UI.User.UserHomePage;
import UI.SystemAdmin.ManageUsersSA;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vipul
 */
public class DietPlan {
    
    
    public void insertRecords( String name, float calories, float protein, float carbs, float fats, float sodium, float cholesterol){
    
        Connection dbconn = DBconnection.connectDB();
            PreparedStatement st;

            try{
                String query = "INSERT INTO dietplans(userName, calories, protein, carbs, fats, sodium, cholesterol) VALUES (?,?,?,?,?,?,?)";
                st = (PreparedStatement)dbconn.prepareStatement(query);
                st.setString(1, name); //bg
                st.setFloat(2, calories);
                st.setFloat(3, protein);
                st.setFloat(4, carbs);
                st.setFloat(5, fats);
                st.setFloat(6, sodium);
                st.setFloat(7, cholesterol);

                st.executeUpdate();

            }
            catch(SQLException ex){
                Logger.getLogger(ManageUsersSA.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }
    
    public ResultSet selectRecordsByName(String name){
    
        Connection dbconn = DBconnection.connectDB();
        
        
        PreparedStatement st;
        
        try{
            st = (PreparedStatement)dbconn.prepareStatement("SELECT * from dietplans WHERE username=?");
            st.setString(1, name);
            ResultSet res = st.executeQuery();
            
            return res;
        }
        catch(SQLException ex){
            Logger.getLogger(DietPlan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
    }
    
    
}
