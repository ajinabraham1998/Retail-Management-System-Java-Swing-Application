/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Role;

import Model.EcoSystem;
import Model.Enterprise.Enterprise;
import Model.Location.Location;
import Model.Organization.Organization;
import Model.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.CustomerServiceUnitAdminArea.CustomerServiceUnitAdminWorkAreaJPanel;
import userinterface.HumanResourceUnitAdminArea.HumanResourceUnitAdminWorkAreaJPanel;
import userinterface.HumanResourceUnitAdminArea.HumanResourceUnitAdminWorkAreaJPanel;

/**
 *
 * @author siddhisawant
 */
public class HumanResourceAdmin extends Role{
     @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account,Organization organization,Enterprise enterprise,Location network, EcoSystem business) {
        return new HumanResourceUnitAdminWorkAreaJPanel( userProcessContainer,enterprise, business);
    }
    
     @Override
    public String toString(){
        return (RoleType.MedicineAdmin.getValue());
    }
}
