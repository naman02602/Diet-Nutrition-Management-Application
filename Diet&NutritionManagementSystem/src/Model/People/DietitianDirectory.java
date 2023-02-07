/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.People;

import Model.Database.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Utilities.UtilityFunctions;
import UI.Dietitian.ManageDietitiansSA;
import UI.SystemAdmin.ManageUsersSA;
import java.time.LocalDate;
import java.time.Period;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Vipul
 */
public class DietitianDirectory {
    
    public static ArrayList<Dietitian> dietitianList = new ArrayList<Dietitian>();
    
    public static ArrayList<Dietitian> getDietitianList() {
        return dietitianList;
    }

    public void setDietitianList(ArrayList<Dietitian> dietitianList) {
        this.dietitianList = dietitianList;
    }
    
//    public Dietitian addNewDietitian(String name, Date dob, int age, String gender, long phNumber, String address, Date doj, int experience, String qualification, int slotsAvailable, String associatedHospital, String type){
//        
//        Dietitian newDietitian = new Dietitian(  name,  dob,  age,  gender,  phNumber,  address,  doj,  experience, qualification,  slotsAvailable,  associatedHospital,  type);
//        
//        dietitianList.add(newDietitian);
//        
//        //Add user details to DB
//        addNewDietitianToDB( name,  dob,  age,  gender,  phNumber,  address,  doj, experience, qualification, slotsAvailable,  associatedHospital,  type);
//        return newDietitian;
//    }
    
   
    
    public void deletePatient(Dietitian p){
        dietitianList.remove(p);
    }
    
    public void addNewDietitianToDB(String name, Date dob, int age, String gender, long phNumber, String address, Date doj, int experience, String qualification, int slotsAvailable, String associatedHospital, String type, String email){
    
        Connection dbconn = DBconnection.connectDB();
        try {
            
//            PreparedStatement query = (PreparedStatement)dbconn.prepareStatement("")
            PreparedStatement st = (PreparedStatement)dbconn.prepareStatement("INSERT INTO dietitians(Name, DOB, Age, Gender, Contact, Address, DOJ, Experience, Qualification, Hospital, Type, Slots, Email) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setString(1, name);
            st.setDate(2, new UtilityFunctions().convertFromJAVADateToSQLDate(dob));
            st.setInt(3, age);
            st.setString(4,gender);
            st.setLong(5, phNumber);
            st.setString(6, address);
            st.setDate(7, new UtilityFunctions().convertFromJAVADateToSQLDate(doj));
            st.setInt(8, experience);
            st.setString(9, qualification);
            st.setString(10, associatedHospital);
            st.setString(11, type);
            st.setInt(12, slotsAvailable);
            st.setString(13, email);
            
            int res = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteDietitianFromDB(int id){
        
        Connection dbconn = DBconnection.connectDB();
        PreparedStatement st;
        try {
            String query = "DELETE FROM dietitians WHERE ID = ?";
            st = (PreparedStatement)dbconn.prepareStatement(query);
            st.setInt(1, id);
            st.executeUpdate();
               
        } catch (SQLException ex) {
            Logger.getLogger(DietitianDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateSlots(String name){
        Connection dbconn = DBconnection.connectDB();
        PreparedStatement st;
        
        try{
                String query = "UPDATE dietitians SET Slots = Slots - 1 WHERE Name=?";
                st = (PreparedStatement)dbconn.prepareStatement(query);
                st.setString(1, name); //bg
                
                st.executeUpdate();
                
            }
            catch(SQLException ex){
                Logger.getLogger(DietitianDirectory.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }
    
    public ResultSet viewDietitians(String type, String hospital){
        
        
        PreparedStatement st;
        
        try{
            Connection dbconn = DBconnection.connectDB();
            st = (PreparedStatement)dbconn.prepareStatement("SELECT ID, Name, Gender, Age, Contact, Hospital, Type, Qualification, Experience, Slots from dietitians WHERE Type = ? AND Hospital = ?");
            st.setString(1, type);
            st.setString(2, hospital);
            ResultSet res = st.executeQuery();
            return res;
        }
        catch(SQLException ex){
            Logger.getLogger(DietitianDirectory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ResultSet getDietitianNameByEmail(String email){
    
        Connection dbconn = DBconnection.connectDB();
        PreparedStatement st;
        
        try{
            st = (PreparedStatement)dbconn.prepareStatement("SELECT Name from dietitians WHERE Email=?");
            st.setString(1, email);
            ResultSet res = st.executeQuery();
            
            return res;
        }
        catch(SQLException ex){
            Logger.getLogger(UserDirectory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
     
    }
    
    public void updateRecordsByID(String name, Date dob, String gender, Long contact, String address, Date doj, String qualification, String hospital, String type, int slots, int id){
    
        Connection dbconn = DBconnection.connectDB();
        PreparedStatement st;
        
        try{
             
            String query = "UPDATE dietitians SET Name = ?, DOB = ?, Gender = ?, Contact = ?, Address = ?, DOJ = ?, Experience = ?, Qualification = ?, Hospital = ? , Type = ?, Slots = ?, Age = ? WHERE ID = ?";
            st = (PreparedStatement)dbconn.prepareStatement(query);
            st.setString(1, name); //bg
            st.setDate(2, new UtilityFunctions().convertFromJAVADateToSQLDate(dob));
            st.setString(3, gender);
            st.setLong(4, contact);
            st.setString(5, address);
            
            LocalDate today = LocalDate.now();
            st.setDate(6, new UtilityFunctions().convertFromJAVADateToSQLDate(doj));
            int exp = Period.between(new ManageDietitiansSA().convertToLocalDateViaInstant(doj), today).getYears();
            st.setInt(7, exp); //age
            
            st.setString(8, qualification);
            st.setString(9, hospital);
            st.setString(10, type);
            st.setInt(11, slots);
            
            int age = Period.between(new ManageDietitiansSA().convertToLocalDateViaInstant(dob), today).getYears();
            
            st.setInt(12, age); 
            st.setInt(13, id);
            
            st.executeUpdate();
            
        }
        catch(SQLException ex){
            Logger.getLogger(DietitianDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    
    public ResultSet selectRecordsByID(int id){
    
        Connection dbconn = DBconnection.connectDB();
        PreparedStatement st;
        
        try{
            st = (PreparedStatement)dbconn.prepareStatement("SELECT * FROM dietitians WHERE ID = ?");
            st.setInt(1, id);
            ResultSet res = st.executeQuery();
            return res;
//            tableView.setModel(DbUtils.resultSetToTableModel(res));
        }
        catch(SQLException ex){
            Logger.getLogger(DietitianDirectory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ResultSet selectAllRecords(){
        Connection dbconn = DBconnection.connectDB();
        PreparedStatement st;
        
        try{
            st = (PreparedStatement)dbconn.prepareStatement("SELECT ID, Name, Gender, Age, Contact, Address, Hospital, Type, Qualification, Experience, Slots from dietitians");
            ResultSet res = st.executeQuery();
            return res;
//            tableView.setModel(DbUtils.resultSetToTableModel(res));
        }
        catch(SQLException ex){
            Logger.getLogger(DietitianDirectory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
    }

    public ResultSet selectRecordsByName(String name){
    
        Connection dbconn = DBconnection.connectDB();
        PreparedStatement st;
        
        try{
            st = (PreparedStatement)dbconn.prepareStatement("SELECT * FROM dietitians WHERE Name = ?");
            st.setString(1, name);
            ResultSet res = st.executeQuery();
            return res;
//            tableView.setModel(DbUtils.resultSetToTableModel(res));
        }
        catch(SQLException ex){
            Logger.getLogger(DietitianDirectory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
