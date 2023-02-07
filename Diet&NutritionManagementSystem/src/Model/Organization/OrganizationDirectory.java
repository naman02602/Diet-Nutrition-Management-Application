/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Organization;

import Model.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author vipul
 */
public class OrganizationDirectory {
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.AdminTeam.getValue())){
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.GSProductTeam.getValue())){
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Type.MSProductTeam.getValue())){
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.HospitalNutritionTeam.getValue())){
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Type.HospitalResearchTeam.getValue())){
            organizationList.add(organization);
        }else if (type.getValue().equals(Type.Product.getValue())){
            organizationList.add(organization);
        }
        return organization;
    }
}
