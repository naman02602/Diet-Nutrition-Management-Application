/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.WorkRequest;

import Model.Database.DBconnection;
import UI.SystemAdmin.ManageUsersSA;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author naman
 */
public class PrescribeDietPlan {

    public PrescribeDietPlan() {
    }
    
    public void insertDietPlan(String name, float calories, float protein, float carbs, float fats, float sodium, float cholesterol){
        
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
    
    
}
