/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Organization;

import Model.Database.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author naman
 */
public class ProductDirectory {

    
    public void addProduct(String product_name, String product_type, float reference_qty, float calorie, 
            float fat, float cholesterol, float sodium, float carbohydrates, float protein, 
            String addedBy){
        Connection dbconn = DBconnection.connectDB();
        try {
            PreparedStatement st = (PreparedStatement)dbconn
                    .prepareStatement("""
                                    INSERT INTO productcatalog (product_name, product_type, reference_qty, 
                                    calorie, fat, cholesterol, sodium, carbohydrates, protein, added_by) 
                                    VALUES(?,?,?,?,?,?,?,?,?,?)""");
            st.setString(1,product_name);
            st.setString(2,product_type);
            st.setFloat(3,reference_qty);
            st.setFloat(4,calorie);
            st.setFloat(5,fat);
            st.setFloat(6,cholesterol);
            st.setFloat(7,sodium);
            st.setFloat(8,carbohydrates);
            st.setFloat(9,protein);
            st.setString(10,addedBy);
            
            int res = st.executeUpdate();
            System.out.println("product added"); 
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    public void approveProduct(String product_name){
//        Connection dbconn = DBconnection.connectDB();
//        
//         try {
//             PreparedStatement st = (PreparedStatement)dbconn.prepareStatement("""
//                                                                                 UPDATE productcatalog
//                                                                                 SET status = 'Approved'
//                                                                                 WHERE product_name = ?""");
//             st.setString(1, product_name);
//             int res = st.executeUpdate();
//         } catch (SQLException ex) {
//             Logger.getLogger(ProductDirectory.class.getName()).log(Level.SEVERE, null, ex);
//         }
//     }
//    
//     public void sendProduct(String product_name){
//        Connection dbconn = DBconnection.connectDB();
//        
//         try {
//             PreparedStatement st = (PreparedStatement)dbconn.prepareStatement("""
//                                                                                 UPDATE productcatalog
//                                                                                 SET status = 'Pending'
//                                                                                 WHERE product_name = ?
//                                                                               """);
//             st.setString(1, product_name);
//             st.executeUpdate();
//         } catch (SQLException ex) {
//             Logger.getLogger(ProductDirectory.class.getName()).log(Level.SEVERE, null, ex);
//         }
//     }
    
     public ResultSet exactProductLookup(String product_name){
         
        Connection dbconn = DBconnection.connectDB();
        
    try {
        PreparedStatement st = (PreparedStatement)dbconn.prepareStatement("""
                                                                    SELECT product_name, product_type
                                                                    ,reference_qty, calorie
                                                                    ,fat, cholesterol,sodium
                                                                    ,carbohydrates, protein, added_by
                                                                    FROM productcatalog
                                                                    WHERE product_name = ?""");
    
        st.setString(1, product_name);
        System.out.print("tryy");
        ResultSet res = st.executeQuery();
        System.out.print("found it");
        return res;
    } catch (SQLException ex) {
        Logger.getLogger(ProductDirectory.class.getName()).log(Level.SEVERE, null, ex);
    }
        return null;
}
    
    public ResultSet exactNutritionLookup(String product_name){
    
        Connection dbconn = DBconnection.connectDB();
            
        try {
            PreparedStatement st = (PreparedStatement)dbconn.prepareStatement("""
                                                                        SELECT perc_calories, perc_protein
                                                                        ,perc_carbs, perc_fats
                                                                        ,perc_sodium, perc_cholesterol
                                                                        FROM productcatalog
                                                                        WHERE product_name = ?""");
        
            st.setString(1, product_name);
            ResultSet res = st.executeQuery();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDirectory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
            
    }
    
    public void deleteProduct(String product_name){
        try {
            Connection dbconn = DBconnection.connectDB();
            
            PreparedStatement st = (PreparedStatement)dbconn.prepareStatement("""
                                                                            DELETE FROM productcatalog
                                                                            WHERE product_name = ? """);
        
            st.setString(1, product_name);
            ResultSet res = st.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateProduct(String type,float refqty,float calorie,float fat,
            float chol,float sodium,float carbs,float protein,String name){
        try {
            Connection dbconn = DBconnection.connectDB();
            PreparedStatement st = (PreparedStatement)dbconn.prepareStatement("""
                                                                            UPDATE productcatalog
                                                                            SET type = ?,
                                                                                reference_qty = ?,
                                                                                calorie = ?,
                                                                                fat = ?,
                                                                                cholestrol = ?,
                                                                                sodium = ?,
                                                                                carbohydrates = ?,
                                                                                protein = ?,
                                                                            WHERE product_name = ?""");
            st.setString(1, type);
            st.setFloat(2, refqty);
            st.setFloat(3, calorie);
            st.setFloat(4, fat);
            st.setFloat(5, chol);
            st.setFloat(6, sodium);
            st.setFloat(7, carbs);
            st.setFloat(8, protein);
            st.setString(9, name);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean alreadyExist(String product_name){
        Connection dbconn = DBconnection.connectDB();
        
            PreparedStatement st;
            boolean isExist = false;
        try {
            st = (PreparedStatement)dbconn.prepareStatement("SELECT * FROM productcatalog WHERE product_name = ?");
            st.setString(1, product_name);
            ResultSet res = st.executeQuery();
            if(res.next()){
                isExist = true;
            }
            return isExist;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDirectory.class.getName()).log(Level.SEVERE, null, ex);
            
            return isExist;
        }
            
    }
    
    public ResultSet getProductData(String search_name, String type){
        try {
            Connection dbconn = DBconnection.connectDB();
            
            PreparedStatement st;
            
            st = (PreparedStatement)dbconn.prepareStatement("""
                                                                    SELECT product_name, product_type, status
                                                                    FROM productcatalog
                                                                    WHERE product_name like ? AND
                                                                    product_type = ?
                                                                    """);
            
            st.setString(1, '%'+search_name+'%');
            st.setString(2, type);
            ResultSet res = st.executeQuery();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDirectory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ResultSet getPendingProductData(){
        try {
            Connection dbconn = DBconnection.connectDB();
            
            PreparedStatement st;
            
            st = (PreparedStatement)dbconn.prepareStatement("""
                                                                    SELECT product_name as Name, product_type as Type, status as Status
                                                                    FROM productcatalog
                                                                    WHERE status = 'Pending' """);

            ResultSet res = st.executeQuery();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDirectory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public String getTotalProducts(String type){
        try {
            Connection dbconn = DBconnection.connectDB();
            
            PreparedStatement st;
            
            st = (PreparedStatement)dbconn.prepareStatement("""
                                                            select count(product_name) as cnt 
                                                            from productcatalog where 
                                                            added_by = ?
                                                            """);
            st.setString(1,type);
//            'Grocery Store Product'
            ResultSet res = st.executeQuery();
            
            
            if (res.next()){
                String val = res.getString(1);
                return val;
            }
            else{
                return "0";
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDirectory.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }
    
    
    public List<String> getAllProducts(){
        List<String> list = new ArrayList<String>();
        try {
            Connection dbconn = DBconnection.connectDB();
            
            PreparedStatement st;
            
            st = (PreparedStatement)dbconn.prepareStatement("""
                                                            select product_name  
                                                            from productcatalog 
                                                            """);

            ResultSet res = st.executeQuery();
            
            
            while(res.next()){
                list.add(res.getString("product_name"));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDirectory.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return list;
    }

    public String getOverallProducts(){
        try {
            Connection dbconn = DBconnection.connectDB();
            
            PreparedStatement st;
            
            st = (PreparedStatement)dbconn.prepareStatement("""
                                                            select count(product_name) as cnt 
                                                            from productcatalog
                                                            """);
            ResultSet res = st.executeQuery();
            if (res.next()){
                String val = res.getString(1);
                return val;
            }
            else{
                return "0";
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDirectory.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }
    
    
    public String getApprovedProducts(String type){
        try {
            Connection dbconn = DBconnection.connectDB();
            
            PreparedStatement st;
            
            st = (PreparedStatement)dbconn.prepareStatement("""
                                                            select count(product_name) as cnt 
                                                            from productcatalog where 
                                                            product_type = ?
                                                            and status = 'Approved'
                                                                     """);
            st.setString(1,type);
            ResultSet res = st.executeQuery();
            if (res.next()){
                String val = res.getString(1);
                return val;
            }
            else{
                return "0";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDirectory.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }
    
    public String getOverallApprovedProducts(){
        try {
            Connection dbconn = DBconnection.connectDB();
            
            PreparedStatement st;
            
            st = (PreparedStatement)dbconn.prepareStatement("""
                                                            select count(product_name) as cnt 
                                                            from productcatalog where 
                                                            status = 'Approved'
                                                                     """);
            ResultSet res = st.executeQuery();
            if (res.next()){
                String val = res.getString(1);
                return val;
            }
            else{
                return "0";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDirectory.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }
    
    
    
    
    public String getPendingProducts(String type){
        try {
            Connection dbconn = DBconnection.connectDB();
            
            PreparedStatement st;
            
            st = (PreparedStatement)dbconn.prepareStatement("""
                                                            select count(product_name) as cnt 
                                                            from productcatalog where 
                                                            product_type = ?
                                                            and status = 'Pending'
                                                                     """);
            st.setString(1,type);
            ResultSet res = st.executeQuery();
            if (res.next()){
                String val = res.getString(1);
                return val;
            }
            else{
                return "0";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDirectory.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }
    
    public String getOverallPendingProducts(){
        try {
            Connection dbconn = DBconnection.connectDB();
            
            PreparedStatement st;
            
            st = (PreparedStatement)dbconn.prepareStatement("""
                                                            select count(product_name) as cnt 
                                                            from productcatalog where 
                                                            status = 'Pending'
                                                                     """);

            ResultSet res = st.executeQuery();
            if (res.next()){
                String val = res.getString(1);
                return val;
            }
            else{
                return "0";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDirectory.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }
    
}
