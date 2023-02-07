/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Utilities;

import java.util.Arrays;
import java.sql.Date;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vipul
 */
public class UtilityFunctions {
    
    
    public String commaSeparate(List<String> list){
        
        String st = String.join((","), list);
        return st;
    }
    
    public List<String> covertToList(String st){
        List<String> list;
        if(st != null){
            list = Arrays.asList(st.split(",", -1));
        }
        else{
            list = new ArrayList<String>();
        }
        return list;
    }
    
    public java.sql.Date convertFromJAVADateToSQLDate(java.util.Date javaDate) {
        java.sql.Date sqlDate = null;
        if (javaDate != null) {
            sqlDate = new Date(javaDate.getTime());
        }
        return sqlDate;
    }
    
    public java.sql.Time convertJavaTimeToSQLTime(LocalTime javaTime){
    
        java.sql.Time sqlTime = java.sql.Time.valueOf(javaTime);
        return sqlTime;
    }
    
}
