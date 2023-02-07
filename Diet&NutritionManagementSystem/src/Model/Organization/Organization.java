/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Organization;

import Model.People.DietitianDirectory;
import Model.People.UserDirectory;
import Model.WorkRequest.WorkRequest;
import java.util.ArrayList;

/**
 *
 * @author vipul
 */
public abstract class Organization {

    private String name;
    private WorkRequest workRequest;
    private UserDirectory userDirectory;
    private DietitianDirectory dietitianDirectory;
    private ProductDirectory productDirectory;
    private int organizationID;
    private static int counter=0;
    
    public enum Type{
        AdminTeam("Admin Organization"), 
        GSProductTeam("Grocery Stores Product Organization"),
        MSProductTeam("Meal Services Product Organization"),
        HospitalNutritionTeam("Hospital Nutrition Team Organization"),
        HospitalResearchTeam("Hospital Research Team Organization"),
        Product("Product Team Organization")
        ;
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        workRequest = new WorkRequest();
        userDirectory = new UserDirectory();
        dietitianDirectory = new DietitianDirectory();
        productDirectory = new ProductDirectory();
        organizationID = counter;
        ++counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDirectory getUserDirectory() {
        return userDirectory;
    }

    public void setUserDirectory(UserDirectory userDirectory) {
        this.userDirectory = userDirectory;
    }

    public DietitianDirectory getDietitianDirectory() {
        return dietitianDirectory;
    }

    public void setDietitianDirectory(DietitianDirectory dietitianDirectory) {
        this.dietitianDirectory = dietitianDirectory;
    }

    public ProductDirectory getProductDirectory() {
        return productDirectory;
    }

    public void setProductDirectory(ProductDirectory productDirectory) {
        this.productDirectory = productDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(int organizationID) {
        this.organizationID = organizationID;
    }

     
}
