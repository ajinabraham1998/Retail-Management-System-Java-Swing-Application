/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SubDepartmentWorkArea;

import Model.EcoSystem;
import Model.Enterprise.Enterprise;
import Model.Product.Product;
import Model.Location.Location;
import Model.Organization.EmergencyOrganization;
import Model.Organization.Organization;
import Model.UserAccount.UserAccount;
import Model.WorkQueue.BillingWorkRequest;
import Model.WorkQueue.EmergencyCustomerRequest;
import Model.WorkQueue.DeoartmentWorkRequest;
import Model.WorkQueue.WorkRequest;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felicia
 */
public class SubDepartmentAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SubDepartmentAreaJPanel
     */
     JPanel userProcessContainer;
    Enterprise enterprise;
    EcoSystem system;
    Organization organization;
    Location location;
    UserAccount account;
    DeoartmentWorkRequest labWorkReq;
    EmergencyOrganization emergencyOrg; 
    public SubDepartmentAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,
            Location location, EcoSystem business) {
        initComponents();
          this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.system = business;
        this.organization = organization;
        this.location = location;
        this.account = account;
        
        for (WorkRequest wr : organization.getWorkQueue().getWorkRequestList()) 
        {
            if(wr instanceof DeoartmentWorkRequest) {
               
                 labWorkReq = (DeoartmentWorkRequest)wr;
            }
        }
        
        populateTable();
    }
    
     public void populateTable(){
        DefaultTableModel model = (DefaultTableModel) WorkRequestTable.getModel();
        model.setRowCount(0);
        
        for (WorkRequest wr : organization.getWorkQueue().getWorkRequestList()) {
            if(wr instanceof DeoartmentWorkRequest) {
                
                DeoartmentWorkRequest epr = (DeoartmentWorkRequest)wr;
                System.out.println(epr.getRequestdate());
                Object[] row = new Object[model.getColumnCount()];
                row[0] = epr;
                row[1] = epr.getCustomer().getCustomerName();//epr.getSender().getEmployee().getName();
                row[2] = epr.getCustomer().getCustomerName();
                row[3] = epr.getCustomer().getCustomerId();
                row[4] = epr.getSpecialType();
                row[5] = epr.getLDepartmentTestName();// epr.getRequestdate();
                row[6] = epr.getDepartmentAdminFeedback();
                row[7] = epr.getRequestdate();
                row[8] = epr.getCustomer().getPhoneNumber();
               
                model.addRow(row);
            }
            
        }
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        WorkRequestTable = new javax.swing.JTable();
        btnAcknowledge = new javax.swing.JButton();
        btnReject = new javax.swing.JButton();
        btnProcess = new javax.swing.JButton();
        btnCompleteRequest = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        WorkRequestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "LabTestRequestId", "Sender", "Customer Name", "Customer ID", "SubDept Name", "SubDept Feedback", "Request Date", "Phone Number", "Special"
            }
        ));
        jScrollPane1.setViewportView(WorkRequestTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 830, 171));

        btnAcknowledge.setText("Accept Request");
        btnAcknowledge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcknowledgeActionPerformed(evt);
            }
        });
        add(btnAcknowledge, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 351, 160, -1));

        btnReject.setText("Reject Request");
        btnReject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectActionPerformed(evt);
            }
        });
        add(btnReject, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 351, 160, -1));

        btnProcess.setText("Process Request");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });
        add(btnProcess, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 351, 160, -1));

        btnCompleteRequest.setText("Complete Request");
        btnCompleteRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteRequestActionPerformed(evt);
            }
        });
        add(btnCompleteRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(742, 351, 160, -1));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("SUB DEPARTMENT WORK AREA");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 400, 56));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcknowledgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcknowledgeActionPerformed
        
         int count = WorkRequestTable.getSelectedRowCount();
        if(count != 1) {
            JOptionPane.showMessageDialog(null, "Select a request");
        }else {
            int selectedRow = WorkRequestTable.getSelectedRow();
            System.out.println( WorkRequestTable.getValueAt(selectedRow, 0));
            DeoartmentWorkRequest emerReq = (DeoartmentWorkRequest) WorkRequestTable.getValueAt(selectedRow, 0);
            
            System.out.println(emerReq.getStatus());
            
            if(emerReq.getStatus().equals("Rejected")) {
                JOptionPane.showMessageDialog(null, "Request is already Rejected");
            }else if(emerReq.getStatus().equals("Accepted")) {
                JOptionPane.showMessageDialog(null, "Request is already Accepted");
            }else if(emerReq.getStatus().equals("Processing")) {
                JOptionPane.showMessageDialog(null, "Request is already Processing");
            }else if(emerReq.getStatus().equals("Completed")) {
                JOptionPane.showMessageDialog(null, "Request is already Completed");
            }else if(emerReq.getStatus().equals("Cancelled")) {
                JOptionPane.showMessageDialog(null, "Request is already cancelled by sender");
            }
            else {
                String msg = JOptionPane.showInputDialog("Additional Message");
                emerReq.setStatus("Accepted");
                emerReq.setMessage(msg);
                populateTable();
            }
        }
    }//GEN-LAST:event_btnAcknowledgeActionPerformed

    private void btnRejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectActionPerformed
        
        int count = WorkRequestTable.getSelectedRowCount();
        if(count != 1) {
            JOptionPane.showMessageDialog(null, "Select a request");
        }else {
            int selectedRow = WorkRequestTable.getSelectedRow();
            DeoartmentWorkRequest emerReq = (DeoartmentWorkRequest) WorkRequestTable.getValueAt(selectedRow, 0);
            if(emerReq.getStatus().equals("Rejected")) {
                JOptionPane.showMessageDialog(null, "Request is already Rejected");
            }if(emerReq.getStatus().equals("Processing")) {
                JOptionPane.showMessageDialog(null, "Request is already Accepted and Processing");
            }else if(emerReq.getStatus().equals("Completed")) {
                JOptionPane.showMessageDialog(null, "Request is already Completed");
            }else if(emerReq.getStatus().equals("Cancelled")) {
                JOptionPane.showMessageDialog(null, "Request is already cancelled by sender");
            }             
            else {
                String msg = JOptionPane.showInputDialog("Additional Message");
                emerReq.setStatus("Rejected");
                emerReq.setMessage(msg);
                populateTable();
            }
        }
        
    }//GEN-LAST:event_btnRejectActionPerformed

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
       int count = WorkRequestTable.getSelectedRowCount();
        if (count != 1) {
            JOptionPane.showMessageDialog(null, "Select one row", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            int selectedRow = WorkRequestTable.getSelectedRow();
            DeoartmentWorkRequest emerReq = (DeoartmentWorkRequest) WorkRequestTable.getValueAt(selectedRow, 0);
            if(emerReq.getStatus().equals("Cancelled")) {
                JOptionPane.showMessageDialog(null, "Request is already cancelled by sender");
            }else if(emerReq.getStatus().equals("Processing")){
                JOptionPane.showMessageDialog(null, "Request is already Processing");
            }else if(emerReq.getStatus().equals("Rejected")){
                JOptionPane.showMessageDialog(null, "Request is already Rejected");
            }else if(emerReq.getStatus().equals("Completed")){
                JOptionPane.showMessageDialog(null, "Request is already Completed");
            }else if(emerReq.getStatus().equals("Requested")) {
                JOptionPane.showMessageDialog(null, "Request is not yet Accepted");
            }
            else {
                String msg = JOptionPane.showInputDialog("Additional Message");                
                emerReq.setStatus("Processing");
                emerReq.setMessage(msg);
                populateTable();
            }            
        }
    }//GEN-LAST:event_btnProcessActionPerformed

    private void btnCompleteRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteRequestActionPerformed
        int count = WorkRequestTable.getSelectedRowCount();
        if(count != 1) {
            JOptionPane.showMessageDialog(null, "Select a request");
        }else {
            int selectedRow = WorkRequestTable.getSelectedRow();
            DeoartmentWorkRequest emerReq = (DeoartmentWorkRequest) WorkRequestTable.getValueAt(selectedRow, 0);
            String childStatus = emerReq.getStatus();        
           
            if(childStatus.equals("Rejected")) {
                JOptionPane.showMessageDialog(null, "Request is already Rejected");
            }else if(childStatus.equals("Accepted")) {
                JOptionPane.showMessageDialog(null, "Request should be in processing state before marking complete");
            }else if(childStatus.equals("Completed")) {
                JOptionPane.showMessageDialog(null, "Request is already Completed");
            }else if(childStatus.equals("Cancelled")) {
                JOptionPane.showMessageDialog(null, "Request is already cancelled by sender");
            }else if(childStatus.equals("Requested")) {
                JOptionPane.showMessageDialog(null, "Request is not yet Accepted");
            }else {
                String msg = JOptionPane.showInputDialog("Additional Message");
                emerReq.setStatus("Completed");         
                emerReq.setMessage(msg);
                emerReq.setLabTestAdminFeedback(msg);
                emerReq.setResolveDate(new Date());
                populateTable();
            }
        }
    }//GEN-LAST:event_btnCompleteRequestActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable WorkRequestTable;
    private javax.swing.JButton btnAcknowledge;
    private javax.swing.JButton btnCompleteRequest;
    private javax.swing.JButton btnProcess;
    private javax.swing.JButton btnReject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
