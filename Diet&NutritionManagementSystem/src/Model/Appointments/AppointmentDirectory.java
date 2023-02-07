/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Appointments;

import Model.Database.DBconnection;
import Model.Utilities.UtilityFunctions;
import UI.SystemAdmin.ManageUsersSA;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vipul
 */
public class AppointmentDirectory {
    
    public static ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();

    public static ArrayList<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public static void setAppointmentList(ArrayList<Appointment> appointmentList) {
        AppointmentDirectory.appointmentList = appointmentList;
    }
    
    public void addAppointment(String userName, String dietitianName, String hospitalName, Date date, LocalTime time, String status){
        Connection dbconn = DBconnection.connectDB();
            PreparedStatement st;
        
            try{
                String query = "INSERT INTO appointments(userName, dietitianName, hospital, date, time, status) VALUES (?,?,?,?,?,?)";
                st = (PreparedStatement)dbconn.prepareStatement(query);
                st.setString(1, userName); //bg
                st.setString(2, dietitianName);
                st.setString(3, hospitalName);
                st.setDate(4, new UtilityFunctions().convertFromJAVADateToSQLDate(date));
                st.setTime(5, new UtilityFunctions().convertJavaTimeToSQLTime(time));
                st.setString(6, status);
                
                st.executeUpdate();
                
            }
            catch(SQLException ex){
                Logger.getLogger(AppointmentDirectory.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    } 
}
