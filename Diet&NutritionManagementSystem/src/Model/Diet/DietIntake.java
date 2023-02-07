/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Diet;

import Model.Database.DBconnection;
import Model.Organization.ProductDirectory;
import UI.SystemAdmin.ManageUsersSA;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author vipul
 */
public class DietIntake {
    
    public String userName;
    public float calories;
    public float protein;
    public float carbs;
    public float fats;
    public float sodium;
    public float cholesterol;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public float getProtein() {
        return protein;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }

    public float getCarbs() {
        return carbs;
    }

    public void setCarbs(float carbs) {
        this.carbs = carbs;
    }

    public float getFats() {
        return fats;
    }

    public void setFats(float fats) {
        this.fats = fats;
    }

    public float getSodium() {
        return sodium;
    }

    public void setSodium(float sodium) {
        this.sodium = sodium;
    }

    public float getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(float cholesterol) {
        this.cholesterol = cholesterol;
    }
    
    public void updateRecordsByUser(float calories, float protein, float carbs, float fats, float sodium, float cholesterol, String name){
        Connection dbconn = DBconnection.connectDB();
        try {
            String query = """
                            UPDATE dailyintake
                             SET calories = calories+?,
                                 protein = protein+?,
                                 carbs = carbs+?,
                                 fats = fats+?,
                                 sodium = sodium+?,
                                 cholesterol = cholesterol+?
                            WHERE username = ?
                            """;
            PreparedStatement st = (PreparedStatement)dbconn.prepareStatement(query);
            st.setFloat(1, calories);
            st.setFloat(2, protein);
            st.setFloat(3, carbs);
            st.setFloat(4, fats);
            st.setFloat(5, sodium);
            st.setFloat(6, cholesterol);
            st.setString(7, name);
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("update failed");
            Logger.getLogger(DietIntake.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    public ResultSet selectRecordsByUser(String name){
    
        Connection dbconn = DBconnection.connectDB();
        
        PreparedStatement st;
        
        try{
            st = (PreparedStatement)dbconn.prepareStatement("SELECT * from dailyintake WHERE username=?");
            st.setString(1, name);
            ResultSet res = st.executeQuery();
            return res;
            
        }
        catch(SQLException ex){
            Logger.getLogger(DietIntake.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
    }

    public void createDailyIntakeDefaultRecord(String username){
         Connection dbconn = DBconnection.connectDB();
            PreparedStatement st;

            try{
                String query = "INSERT INTO dailyintake(userName) VALUES (?)";
                st = (PreparedStatement)dbconn.prepareStatement(query);
                st.setString(1, username);

                st.executeUpdate();

            }
            catch(SQLException ex){
                Logger.getLogger(DietIntake.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
