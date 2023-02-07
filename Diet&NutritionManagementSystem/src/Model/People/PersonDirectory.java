/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.People;

import java.util.ArrayList;
import Model.Database.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Vipul
 */
public class PersonDirectory {
    
    ArrayList<Person> personList;
    
    public PersonDirectory(){
        this.personList = new ArrayList<Person>();
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }
    
    public void addNewPersonToDB(String name, Date dob, int age, String gender, long contact, String address){
    
        Connection dbconn = DBconnection.connectDB();
        try {
            PreparedStatement st = (PreparedStatement)dbconn.prepareStatement("INSERT INTO person(`Name`, `DOB`, 'Age', `Gender`, `Contact`, `Address`) VALUES(?,?,?,?,?,?)");
            st.setString(1, name);
            st.setDate(2, (java.sql.Date)dob);
            st.setInt(3, age);
            st.setString(4,gender);
            st.setLong(5, contact);
            st.setString(6, address);
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
