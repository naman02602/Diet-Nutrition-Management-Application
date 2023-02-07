/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.WorkRequest;

import Model.Database.DBconnection;
import Model.Organization.ProductDirectory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author naman
 */
public class ProductApproval {
    public String product_name;

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public ProductApproval() {
    }

    public ProductApproval(String product_name) {
        this.product_name = product_name;
    }
    
    public void approveProduct(String product_name){
        Connection dbconn = DBconnection.connectDB();
        
         try {
             PreparedStatement st = (PreparedStatement)dbconn.prepareStatement("""
                                                                                 UPDATE productcatalog
                                                                                 SET status = 'Approved'
                                                                                 WHERE product_name = ?""");
             st.setString(1, product_name);
             int res = st.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ProductDirectory.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
    
     public void sendProduct(String product_name){
        Connection dbconn = DBconnection.connectDB();
        
         try {
             PreparedStatement st = (PreparedStatement)dbconn.prepareStatement("""
                                                                                 UPDATE productcatalog
                                                                                 SET status = 'Pending'
                                                                                 WHERE product_name = ?
                                                                               """);
             st.setString(1, product_name);
             st.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(ProductDirectory.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
    
    
}
