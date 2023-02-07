/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.People;

import Model.Database.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Utilities.UtilityFunctions;
import UI.SystemAdmin.ManageUsersSA;
import java.awt.Color;
import java.sql.ResultSet;
/**
 *
 * @author Vipul
 */
public class UserDirectory {
    
    public static ArrayList<User> userList = new ArrayList<User>();
    
    public static ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }
    
   
    public void deleteUser(User p){
        userList.remove(p);
    }
    
    //name, dob, age, gender, contact, address, height, weight, diabetic, allergies, puposeList, preference, workoutFrequency, favorites,  email
    public void addNewUserToDB(String name, Date dob, int age, String gender, long phNumber, String address, float height, float weight, boolean diabetic, String allergies, String purposeOfDiet, String foodPreference, String workoutFrequency, List<String> favorites, String email){
    
        Connection dbconn = DBconnection.connectDB();
        try {
            PreparedStatement st = (PreparedStatement)dbconn.prepareStatement("INSERT INTO end_users(`Name`, `DOB`, `Age`, `Gender`, `Contact`, `Address`,`Height`, `Weight`, `Diabetic`, `Allergies`, `Purpose`, `Food_Preference`, `Workout_Frequency`, `Favorites`, `Email`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setString(1, name);
            st.setDate(2, new UtilityFunctions().convertFromJAVADateToSQLDate(dob));
            st.setInt(3, age);
            st.setString(4,gender);
            st.setLong(5, phNumber);
            st.setString(6, address);
            st.setFloat(7, height);
            st.setFloat(8, weight);
            
            
            st.setBoolean(9, diabetic);
            st.setString(10, allergies);
            st.setString(11, purposeOfDiet);
            st.setString(12, foodPreference);
            st.setString(13, workoutFrequency);
            st.setString(14, new UtilityFunctions().commaSeparate(favorites));
            st.setString(15, email);
            
            int res = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteUserFromDB(int id){
        
        Connection dbconn = DBconnection.connectDB();
        PreparedStatement st;
        try {
            String query = "DELETE FROM end_users WHERE UserID = ?";
            st = (PreparedStatement)dbconn.prepareStatement(query);
            st.setInt(1, id);
            st.executeUpdate();
               
        } catch (SQLException ex) {
            Logger.getLogger(UserDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet getUserNameByEmail(String email){
    
        Connection dbconn = DBconnection.connectDB();
        PreparedStatement st;
        
        try{
            st = (PreparedStatement)dbconn.prepareStatement("SELECT Name from end_users WHERE Email=?");
            st.setString(1, email);
            ResultSet res = st.executeQuery();
            
            return res;
        }
        catch(SQLException ex){
            Logger.getLogger(UserDirectory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
     
    }
    
    public void updateRecordsByID(String bp, float height, float weight, String diab, String allergies, String purpose, String preference, String workout, String favorite, int id){
    
        Connection dbconn = DBconnection.connectDB();
        PreparedStatement st;
        
        try{
            String query = "UPDATE end_users SET BloodGroup = ?, Height = ?, Weight = ?, Diabetic = ?, Allergies = ?, Purpose = ?, Food_Preference = ?, Workout_Frequency = ?, Favorites = ? WHERE UserID = ?";
            st = (PreparedStatement)dbconn.prepareStatement(query);
            st.setString(1, bp); //bg
            st.setFloat(2, height);
            st.setFloat(3, weight);
            st.setString(4, diab);                
           
            st.setString(5, allergies);
            st.setString(6, purpose);
            st.setString(7, preference);
            st.setString(8, workout);
            st.setString(9, favorite);
            st.setInt(10, id);
            st.executeUpdate();
            
        }
        catch(SQLException ex){
            Logger.getLogger(UserDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    
    public void updateRecordsByName(String bp, float height, float weight, String diab, String allergies, String purpose, String preference, String workout, String favorite, String name){
    
        Connection dbconn = DBconnection.connectDB();
        PreparedStatement st;
        
        try{
            String query = "UPDATE end_users SET BloodGroup = ?, Height = ?, Weight = ?, Diabetic = ?, Allergies = ?, Purpose = ?, Food_Preference = ?, Workout_Frequency = ?, Favorites = ? WHERE Name = ?";
            st = (PreparedStatement)dbconn.prepareStatement(query);
            st.setString(1, bp); //bg
            st.setFloat(2, height);
            st.setFloat(3, weight);
            st.setString(4, diab);                
           
            st.setString(5, allergies);
            st.setString(6, purpose);
            st.setString(7, preference);
            st.setString(8, workout);
            st.setString(9, favorite);
            st.setString(10, name);
            st.executeUpdate();
            
        }
        catch(SQLException ex){
            Logger.getLogger(UserDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    public ResultSet selectRecordsByID(int id){
    
        Connection dbconn = DBconnection.connectDB();
        PreparedStatement st;
        
        try{
            st = (PreparedStatement)dbconn.prepareStatement("SELECT * FROM end_users WHERE UserID = ?");
            st.setInt(1, id);
            ResultSet res = st.executeQuery();
            return res;
//            tableView.setModel(DbUtils.resultSetToTableModel(res));
        }
        catch(SQLException ex){
            Logger.getLogger(UserDirectory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ResultSet selectRecordsByName(String name){
    
        Connection dbconn = DBconnection.connectDB();
        PreparedStatement st;
        
        try{
            st = (PreparedStatement)dbconn.prepareStatement("SELECT * FROM end_users WHERE Name = ?");
            st.setString(1, name);
            ResultSet res = st.executeQuery();
            return res;
//            tableView.setModel(DbUtils.resultSetToTableModel(res));
        }
        catch(SQLException ex){
            Logger.getLogger(UserDirectory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ResultSet selectAllRecords(){
        Connection dbconn = DBconnection.connectDB();
        PreparedStatement st;
        
        try{
            st = (PreparedStatement)dbconn.prepareStatement("SELECT UserID, Name, Gender, Age, Contact, Address, Height, Weight, BloodGroup, Diabetic, Allergies from end_users");
            
            ResultSet res = st.executeQuery();
            return res;
//            tableView.setModel(DbUtils.resultSetToTableModel(res));
        }
        catch(SQLException ex){
            Logger.getLogger(UserDirectory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
    }
}
