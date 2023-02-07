/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author vipul
 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterpriseList;
   

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    public EnterpriseDirectory(){
        enterpriseList=new ArrayList<Enterprise>();
    }
    
    public Enterprise createAndAddEnterprise(String name,Enterprise.EnterpriseType type){
        Enterprise enterprise=null;
        if(type==Enterprise.EnterpriseType.Hospital){
            enterprise=new HospitalEnterprise(name, type);
            enterpriseList.add(enterprise);
        }
        if(type==Enterprise.EnterpriseType.GroceryStores){
            enterprise=new GroceryStoresEnterprise(name,type);
            enterpriseList.add(enterprise);
        }
        if(type==Enterprise.EnterpriseType.MealService){
            enterprise=new MealServiceEnterprise(name,type);
            enterpriseList.add(enterprise);
        }if(type==Enterprise.EnterpriseType.NGO){
            enterprise=new NGOEnterprise(name,type);
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }
}
