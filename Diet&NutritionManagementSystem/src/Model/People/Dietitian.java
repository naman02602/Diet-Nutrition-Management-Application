/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.People;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Vipul
 */
public class Dietitian extends Person {
    
    public Date doj;
    public int experience;
    public String qualification;
    public int slotsAvailable;
    public String associatedHospital;
    public String type;

    public Dietitian(){
        
    }
    
    public Dietitian(String name, Date dob, int age, String gender, long phNumber, String address, Date doj, int experience, String qualification, int slotsAvailable, String associatedHospital, String type) {
        super( name,  dob, age, gender,  phNumber,  address);
        this.doj = doj;
        this.experience = experience;
        this.qualification = qualification;
        this.slotsAvailable = slotsAvailable;
        this.associatedHospital = associatedHospital;
        this.type = type;
    }

    public int getSlotsAvailable() {
        return slotsAvailable;
    }

    public void setSlotsAvailable(int slotsAvailable) {
        this.slotsAvailable = slotsAvailable;
    }
    
    
    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getAssociatedHospital() {
        return associatedHospital;
    }

    public void setAssociatedHospital(String associatedHospital) {
        this.associatedHospital = associatedHospital;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
    
    

}
