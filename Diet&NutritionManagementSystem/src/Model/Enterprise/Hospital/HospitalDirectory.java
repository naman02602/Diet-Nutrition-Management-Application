/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Enterprise.Hospital;


import Model.Database.DBconnection;
import Model.Organization.ProductDirectory;
import Model.People.Dietitian;
import Model.People.PersonDirectory;
import Model.People.UserDirectory;
import Model.Utilities.UtilityFunctions;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import model.Hospital;

/**
 *
 * @author anuja
 */
public class HospitalDirectory {
    
      public static ArrayList<Hospital> hospitalList = new ArrayList<Hospital>();
    
    public static ArrayList<Hospital> getHospitalList() {
        return hospitalList;
    }

    public void setHospitalList(ArrayList<Hospital> hospitalList) {
        this.hospitalList = hospitalList;
    }
    
   public Hospital addNewHospital(String licenseNo, String name, long phNumber, String address, String email, String pwd, String type){
        
        Hospital newHospital = new Hospital(email, pwd, type,  licenseNo,  name,  phNumber,  address);
        
        return newHospital;
    }
    
   
    
   public void deleteHospital(Hospital p){
      hospitalList.remove(p);
  // 
   }
    
    public void addNewHospitalToDB(String license, String name, long phNumber, String address,String email){
    
        Connection dbconn = DBconnection.connectDB();
        try {
            
            
           
//            PreparedStatement query = (PreparedStatement)dbconn.prepareStatement("")
            PreparedStatement st = (PreparedStatement)dbconn.prepareStatement("INSERT INTO Hospital(licenseNo,HospitalName,PhoneNo,Email, address) VALUES(?,?,?,?,?)");
            st.setString(1,license);
            st.setString(2, name);
            st.setLong(3,phNumber);
            st.setString(4,email);
              st.setString(5, address);
                 
            
            int res = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteHospitalFromDB(int id){
        
        Connection dbconn = DBconnection.connectDB();
        try {
            PreparedStatement st = (PreparedStatement)dbconn.prepareStatement("DELETE * FROM hospital WHERE ID = ?");
            st.setString(1, String.valueOf(id));
            
            
        } catch (SQLException ex) {
            Logger.getLogger(HospitalDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet selectAllRecords(){
        Connection dbconn = DBconnection.connectDB();
        PreparedStatement st;
        
        try{
            st = (PreparedStatement)dbconn.prepareStatement("SELECT * from hospital");
            
            ResultSet res = st.executeQuery();
            return res;
//            tableView.setModel(DbUtils.resultSetToTableModel(res));
        }
        catch(SQLException ex){
            Logger.getLogger(HospitalDirectory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
    }
    
    public void updateRecordsByID(String license, String name, Long contact, String address,String email,int  id){
    
        Connection dbconn = DBconnection.connectDB();
        PreparedStatement st;
        
        try{
            String query = "UPDATE hospital SET licenseNo = ?, HospitalName = ?, PhoneNo = ?, Email = ?, Address = ? WHERE Id = ?";
            st = (PreparedStatement)dbconn.prepareStatement(query);
            st.setString(1, license); //bg
            st.setString(2, name);
            st.setLong(3, contact);
            st.setString(4, email);                
           
            st.setString(5, address);
            st.setInt(6, id);
            st.executeUpdate();
            
        }
        catch(SQLException ex){
            Logger.getLogger(HospitalDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
        
    }
    
    public ResultSet selectRecordsByID(int id){
    
        Connection dbconn = DBconnection.connectDB();
        PreparedStatement st;
        
        try{
            st = (PreparedStatement)dbconn.prepareStatement("SELECT * FROM hospital WHERE Id = ?");
            st.setInt(1, id);
            ResultSet res = st.executeQuery();
            return res;
//            tableView.setModel(DbUtils.resultSetToTableModel(res));
        }
        catch(SQLException ex){
            Logger.getLogger(HospitalDirectory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ResultSet getHospitalNameByEmail(String email){
    
        Connection dbconn = DBconnection.connectDB();
        PreparedStatement st;
        
        try{
            st = (PreparedStatement)dbconn.prepareStatement("SELECT HospitalName from hospital WHERE Email=?");
            st.setString(1, email);
            ResultSet res = st.executeQuery();
            
            return res;
        }
        catch(SQLException ex){
            Logger.getLogger(HospitalDirectory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
     
    }
    
    public List<String> getAllHospitalsList(){
        List<String> list = new ArrayList<String>();
        try {
            Connection dbconn = DBconnection.connectDB();
            
            PreparedStatement st;
            
            st = (PreparedStatement)dbconn.prepareStatement("""
                                                            select DISTINCT HospitalName  
                                                            from hospital 
                                                            """);

            ResultSet res = st.executeQuery();
            
            
            while(res.next()){
                list.add(res.getString("HospitalName"));
                
            }
            list.add("NA");
            
        } catch (SQLException ex) {
            Logger.getLogger(HospitalDirectory.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return list;
    }
    
}
