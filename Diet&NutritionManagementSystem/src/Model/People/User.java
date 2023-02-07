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
public class User extends Person {
    
    public String bloodGroup;
    public float weight;
    public float height;
    public boolean diabetic;
    public String allergies;
    
    public String purposeOfDiet;
    public String foodPreference;
    public String workoutFrequency;
    public List<String> favorites;
    
//    private VitalSigns vitalSigns;
//    private EncounterHistory encounterHistory;

    public User(){
        
    }
    
    public User(String name, Date dob, int age, String gender, long phNumber, String address, String bloodGroup, float height, float weight, boolean diabetic, String allergies, String purposeOfDiet, String foodPreference, String workoutFrequency, List<String> favorites) {
        super( name,  dob, age, gender,  phNumber,  address);
        this.height = height;
        this.weight = weight;
        this.bloodGroup = bloodGroup;
        
        this.diabetic = diabetic;
        this.allergies = allergies;
        
        this.purposeOfDiet = purposeOfDiet;
        this.foodPreference = foodPreference;
        this.workoutFrequency = workoutFrequency;
        this.favorites = favorites;
    }

    public String getFoodPreference() {
        return foodPreference;
    }

    public void setFoodPreference(String foodPreference) {
        this.foodPreference = foodPreference;
    }
    
    public String getPurposeOfDiet() {
        return purposeOfDiet;
    }

    public void setPurposeOfDiet(String purposeOfDiet) {
        this.purposeOfDiet = purposeOfDiet;
    }

    public String getWorkoutFrequency() {
        return workoutFrequency;
    }

    public void setWorkoutFrequency(String workoutFrequency) {
        this.workoutFrequency = workoutFrequency;
    }

    public List<String> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<String> favorites) {
        this.favorites = favorites;
    }
    
    
    
    public boolean isDiabetic() {
        return diabetic;
    }

    public void setDiabetic(boolean diabetic) {
        this.diabetic = diabetic;
    }

    public String getAllergies() {
        return allergies;
    }
    
    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }
    
    

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

}
