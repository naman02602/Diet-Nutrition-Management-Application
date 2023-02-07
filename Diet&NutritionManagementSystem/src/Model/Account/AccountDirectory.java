/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Account;

import Model.Database.DBconnection;
import Model.Utilities.UtilityFunctions;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author naman
 */
public class AccountDirectory{
    
    public static ArrayList<Account> accountList = new ArrayList<Account>();

    public static ArrayList<Account> getAccountList() {
        return accountList;
    }

    public static void setAccountList(ArrayList<Account> accountList) {
        AccountDirectory.accountList = accountList;
    }
    
    
    public ResultSet checkCredential (String email, String password){
        try {
            Connection dbconn = DBconnection.connectDB();
            PreparedStatement st = (PreparedStatement)dbconn.prepareStatement(
                    "SELECT usertype FROM users WHERE email = ? AND password = ?");
            st.setString(1, email);
            st.setString(2, password);
            ResultSet res = st.executeQuery();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDirectory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void addUserCredential(String email, String password, String type){
        try {
            Connection dbconn = DBconnection.connectDB();
            
            PreparedStatement st = (PreparedStatement)dbconn.prepareStatement(
                    "INSERT INTO users (email,password,usertype) VALUES(?,?,?)");
            st.setString(1, email);
            st.setString(2, password);
            st.setString(3, type);
            int res = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addPerson(String email, String name,String gender,Date dob,
            String address,long mobile){
        try {
            Connection dbconn = DBconnection.connectDB();
            
            PreparedStatement st = (PreparedStatement)dbconn.prepareStatement(
                    "INSERT INTO person (email,name,gender,dob,address,contact) VALUES(?,?,?,?,?,?)");
            st.setString(1, email);
            st.setString(2, name);
            st.setString(3,gender);
            st.setDate(4,new UtilityFunctions().convertFromJAVADateToSQLDate(dob));
            st.setString(5,address);
            st.setLong(6,mobile);
            int res = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addUser(String email, String name,String gender,Date dob,
            String address,long mobile){
        //Add details to users table
        try {
            Connection dbconn = DBconnection.connectDB();
            
            PreparedStatement st = (PreparedStatement)dbconn.prepareStatement(
                    "INSERT INTO end_users (Email,Name,Gender,DOB,Address,Contact) VALUES(?,?,?,?,?,?)");
            st.setString(1, email);
            st.setString(2, name);
            st.setString(3,gender);
            st.setDate(4,new UtilityFunctions().convertFromJAVADateToSQLDate(dob));

            st.setString(5,address);
            st.setLong(6,mobile);
            int res = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
}
