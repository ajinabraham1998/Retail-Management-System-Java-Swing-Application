/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Organization;

import Model.Role.AdminRole;
import Model.Role.EmergencyAdminRole;
import Model.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author felicia
 */
public class AdminOrganizatiion extends Organization{

    public AdminOrganizatiion(){
         super(Organization.Type.AdminDepartment.getValue());
    }
     @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new AdminRole());
        return roles;
    }
    
        @Override
    public Type getType() {
        return Organization.Type.AdminDepartment;
    } 

}
