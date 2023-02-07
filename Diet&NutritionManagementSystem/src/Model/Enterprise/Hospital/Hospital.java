/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Enterprise.Hospital;

import Model.Account.Account;


/**
 *
 * @author anuja
 */
public class Hospital extends Account{
    
    
    public String licenseNo;
    public String name;
    public long phNumber;
    public String address;
    public String email;

   
    
    public Hospital(String email, String password, String type, String licenseNo, String name, long phNumber, String address ){
        super(email, password, type);
        this.licenseNo  = licenseNo;
        this.name = name;
        this.phNumber = phNumber;
        this.address = address;
       
    }     


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   

    public long getPhNumber() {
        return phNumber;
    }

    public void setPhNumber(long phNumber) {
        this.phNumber = phNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public Hospital(String email, String password, String type) {
        super(email, password, type);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    

}
