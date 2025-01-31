/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Organization;

import Model.Employee.EmployeeDirectory;
import Model.Role.Role;
import Model.UserAccount.UserAccountDirectory;
import Model.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author felicia
 */
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter = 0;
    public ArrayList<Role> roles;
    private Type type;
    
    public enum Type{
        LabDepartment("Lab Department"),
        CustomerAgentDepartment("Customer Agent Department"),
        CustomerServiceAdminDepartment("Customer Service Admin Department"),
        CustomerQueryDepartment("Customer Query Department"),
        CustomerServiceDepartment("Customer Service Department"),
        CustomertDepartment("Customer Department"),                
        BillingDepartment("Billing Department"),
        HumanResourceDepartment("Medicine Department"),
        ProductDepartment("Equipment Department"),
        PersonDepartment("Person Department"),
        AdminDepartment("Admin Department");
        
        
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
        
        @Override
        public String toString(){
        return value;
        }
    }
    
        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }


    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = counter;
        ++counter;
    }
    public Organization(){
        
    }
    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
