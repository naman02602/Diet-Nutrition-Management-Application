/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.WorkRequest;

import Model.Database.DBconnection;
import UI.Dietitian.ManageDietitiansSA;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vipul
 */
public class DietitianAppointmentRequest extends WorkRequest{
    
    public String userName;
    public String dietitianName;
    public Date date;
    public LocalTime time;

    public DietitianAppointmentRequest() {
    }
    
    
    public DietitianAppointmentRequest(int id, String status, String userName, String dietitianName, Date date, LocalTime time) {
        super(id, status);
        this.userName = userName;
        this.dietitianName = dietitianName;
        this.date = date;
        this.time = time;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDietitianName() {
        return dietitianName;
    }

    public void setDietitianName(String dietitianName) {
        this.dietitianName = dietitianName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
    
    public ResultSet selectOwnConfirmedAppointmentDetails(String name){
    
        Connection dbconn = DBconnection.connectDB();
        PreparedStatement st;
        
        try{
            
            String query = "SELECT u.Name, u.Gender, u.Age, u.Food_preference, u.Purpose, u.Workout_Frequency, a.dietitianName, a.date, a.time , a.appointmentID, a.status FROM end_users as u RIGHT JOIN appointments as a ON u.Name = a.userName WHERE a.dietitianName=? AND a.status=?";
            st = (PreparedStatement)dbconn.prepareStatement(query);
            st.setString(1, name);
            st.setString(2, "Confirmed");
            ResultSet res = st.executeQuery();
            return res;
        }
        catch(SQLException ex){
            Logger.getLogger(DietitianAppointmentRequest.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
    
    }
    
    public ResultSet selectOwnAllAppointmentDetails(String name){
    
        Connection dbconn = DBconnection.connectDB();
        PreparedStatement st;
        
        try{
            
            String query = "SELECT u.Name, u.Gender, u.Age, u.contact, u.Food_preference, u.Purpose, u.Workout_Frequency, a.dietitianName, a.appointmentID, a.date, a.time, a.hospital, a.status FROM end_users as u RIGHT JOIN appointments as a ON u.Name = a.userName WHERE a.dietitianName=? AND a.status != ?";
            st = (PreparedStatement)dbconn.prepareStatement(query);
            st.setString(1, name);
            st.setString(2, "Pending");
            ResultSet res = st.executeQuery();
            return res;
        }
        catch(SQLException ex){
            Logger.getLogger(DietitianAppointmentRequest.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
    
    }
    
    public void acceptRequestByID(int id){
        
        Connection dbconn = DBconnection.connectDB();
        PreparedStatement st;

        try{

            String query = "UPDATE appointments SET status = ? WHERE appointmentID = ?";
            st = (PreparedStatement)dbconn.prepareStatement(query);
            st.setString(1, "Confirmed"); //bg
            st.setInt(2, id);
            st.executeUpdate();

        }
        catch(SQLException ex){
            Logger.getLogger(DietitianAppointmentRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    public void rejectRequestByID(int id){
        
        Connection dbconn = DBconnection.connectDB();
        PreparedStatement st;

        try{

            String query = "UPDATE appointments SET status = ? WHERE appointmentID = ?";
            st = (PreparedStatement)dbconn.prepareStatement(query);
            st.setString(1, "Declined"); //bg
            st.setInt(2, id);
            st.executeUpdate();

        }
        catch(SQLException ex){
            Logger.getLogger(DietitianAppointmentRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    public void requestRequestByID(int id){
        
        Connection dbconn = DBconnection.connectDB();
        PreparedStatement st;

        try{

            String query = "UPDATE appointments SET status = ? WHERE appointmentID = ?";
            st = (PreparedStatement)dbconn.prepareStatement(query);
            st.setString(1, "Requested"); //bg
            st.setInt(2, id);
            st.executeUpdate();

        }
        catch(SQLException ex){
            Logger.getLogger(DietitianAppointmentRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
}
