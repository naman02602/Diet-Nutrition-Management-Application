/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.People;

import java.util.Date;

/**
 *
 * @author Vipul
 */
public class Person {
    
    private String name;
    private Date dob;
    private int age;
    private String gender;
    private long phNumber;
    private String address;
    
    public Person(String name, Date dob, int age,  String gender, long phNumber, String address){
        
        this.name = name;
        this.dob = dob;
        this.age = age;
        this.gender = gender;
        this.phNumber = phNumber;
        this.address = address;
    }     

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getPhNumber() {
        return phNumber;
    }

    public void setPhNumber(long phNumber) {
        this.phNumber = phNumber;
    }

    public Person(){
        
    }  
    
    @Override
    public String toString(){
        return name;
    }
    
} 
