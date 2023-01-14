/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.EmergencyCustomerService;

import Model.EcoSystem;
import Model.Enterprise.Enterprise;
import Model.RetailEmployment.Department;
import Model.RetailEmployment.Customer;
import Model.Location.Location;
import Model.Organization.Organization;
import Model.UserAccount.UserAccount;
import Model.WorkQueue.DepartmentWorkRequest;
import Model.WorkQueue.AgentWorkRequest;
import Model.WorkQueue.EmergencyCustomerRequest;
import Model.WorkQueue.WorkRequest;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

;

/**
 *
 * @author siddhisawant
 */
public class EmergencyCustomerServiceJPanel extends javax.swing.JPanel {

    /**
     * Creates new form EmergencyCustomerServiceJPanel
     */
     JPanel userProcessContainer;
    UserAccount account;
    Organization organization;
    Enterprise enterprise;
    Location network;
    EcoSystem business;
    public EmergencyCustomerServiceJPanel(JPanel userProcessContainer, 
            UserAccount account,Organization organization,Enterprise enterprise,Location network,
            EcoSystem business) {
        initComponents();
          this.userProcessContainer = userProcessContainer;
         this.account = account;
         this.organization = organization;
         this.enterprise = enterprise;
         this.network = network;
         this.business = business;
         populateTable();
    }

    public void populateTable()
    {
        DefaultTableModel model = (DefaultTableModel) WorkRequestTable.getModel();
        model.setRowCount(0);
        System.out.println("Total workreq "+account.getWorkQueue().getWorkRequestList().size());
        
        for (WorkRequest wr : account.getWorkQueue().getWorkRequestList()) {
            if(wr instanceof DepartmentWorkRequest) {
                
                DepartmentWorkRequest epr = (DepartmentWorkRequest)wr;
                
                Object[] row = new Object[model.getColumnCount()];
                row[0] = epr;
                row[1] = epr.getCustomer().getCustomerName();//epr.getSender().getEmployee().getName();
                row[2] = epr.getCustomer().getCustomerName();
                row[3] = epr.getCustomer().getAddress();
                row[4] = epr.getCriticality();
                row[5] = epr.getStatus();// epr.getRequestdate();
                row[6] = epr.getRequestDate();
                row[7] = epr.getCustomer().getPhoneNumber();
               // row[8] = "" ;
               // row[9] = "";//epr.getEmergencyAgent() != null ? epr.getEmergencyAgent().;
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
        btnCompleteRequest = new javax.swing.JButton();
        btnProcess = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        WorkRequestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "RequestId", "Sender", "Customer Name", "Customer Address", "Urgency", "Status", "Request Date", "Phone Number"
            }
        ));
        jScrollPane1.setViewportView(WorkRequestTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 140, 762, 169));

        btnAcknowledge.setText("Accept Request");
        btnAcknowledge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcknowledgeActionPerformed(evt);
            }
        });
        add(btnAcknowledge, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 344, 150, -1));

        btnReject.setText("Reject Request");
        btnReject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectActionPerformed(evt);
            }
        });
        add(btnReject, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 344, 150, -1));

        btnCompleteRequest.setText("Complete Request");
        btnCompleteRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteRequestActionPerformed(evt);
            }
        });
        add(btnCompleteRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 344, 150, -1));

        btnProcess.setText("Process Request");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });
        add(btnProcess, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 344, 150, -1));

        jButton1.setText("Refresh");
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 99, 150, -1));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText(" EMERGENCY CUSTOMER SERVICE DEPARTMENT");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 610, -1));
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 80));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/HappyCustomerBG1.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 480, 530));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcknowledgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcknowledgeActionPerformed
        int count = WorkRequestTable.getSelectedRowCount();
        if(count != 1) {
            JOptionPane.showMessageDialog(null, "Select a request");
        }else {
            int selectedRow = WorkRequestTable.getSelectedRow();
            DepartmentWorkRequest emerReq = (DepartmentWorkRequest) WorkRequestTable.getValueAt(selectedRow, 0);
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
            }else {
                String msg = JOptionPane.showInputDialog("Additional Message");
                  if(msg != null)
                {
                emerReq.setStatus("Accepted");
                emerReq.setMessage(msg);
                }
                populateTable();
            }
            //emerReq.setStatus("Accepted");
        }
        populateTable();
    }//GEN-LAST:event_btnAcknowledgeActionPerformed

    private void btnRejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectActionPerformed
        int count = WorkRequestTable.getSelectedRowCount();
        if(count != 1) {
            JOptionPane.showMessageDialog(null, "Select a request");
        }else {
            int selectedRow = WorkRequestTable.getSelectedRow();
            DepartmentWorkRequest emerReq = (DepartmentWorkRequest) WorkRequestTable.getValueAt(selectedRow, 0);
            if(emerReq.getStatus().equals("Rejected")) {
                JOptionPane.showMessageDialog(null, "Request is already Rejected");
            }else if(emerReq.getStatus().equals("Accepted")) {
                JOptionPane.showMessageDialog(null, "Request is already Accepted");
            }else if(emerReq.getStatus().equals("Processing")) {
                JOptionPane.showMessageDialog(null, "Request is already Accepted and Processing");
            }else if(emerReq.getStatus().equals("Completed")) {
                JOptionPane.showMessageDialog(null, "Request is already Completed");
            }else if(emerReq.getStatus().equals("Cancelled")) {
                JOptionPane.showMessageDialog(null, "Request is already cancelled by sender");
            }else {
                String msg = JOptionPane.showInputDialog("Additional Message");
                  if(msg != null)
                {
                emerReq.setStatus("Rejected");
                emerReq.setMessage(msg);
               // populateTable();
                }
            }
        }
        populateTable();
    }//GEN-LAST:event_btnRejectActionPerformed

    private void btnCompleteRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteRequestActionPerformed
        int count = WorkRequestTable.getSelectedRowCount();
        if(count != 1) {
            JOptionPane.showMessageDialog(null, "Select a request");
        }else {
            int selectedRow = WorkRequestTable.getSelectedRow();
            DepartmentWorkRequest emerReq = (DepartmentWorkRequest) WorkRequestTable.getValueAt(selectedRow, 0);
            if(emerReq.getStatus().equals("Rejected")) {
                JOptionPane.showMessageDialog(null, "Request is already Rejected");
            }else if(emerReq.getStatus().equals("Accepted")) {
                JOptionPane.showMessageDialog(null, "Request should be in processing state before marking complete");
            }else if(emerReq.getStatus().equals("Completed")) {
                JOptionPane.showMessageDialog(null, "Request is already Completed");
            }else if(emerReq.getStatus().equals("Cancelled")) {
                JOptionPane.showMessageDialog(null, "Request is already cancelled by sender");
            }else if(emerReq.getStatus().equals("Requested")) {
                JOptionPane.showMessageDialog(null, "Request is not yet Accepted");
            }else {
                String msg = JOptionPane.showInputDialog("Additional Message");
                  if(msg != null)
                {
                emerReq.setStatus("Completed");
                emerReq.setMessage(msg);
                }
                populateTable();
            }
        }
    }//GEN-LAST:event_btnCompleteRequestActionPerformed

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
        int count = WorkRequestTable.getSelectedRowCount();
        if (count != 1) {
            JOptionPane.showMessageDialog(null, "Select one row", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            int selectedRow = WorkRequestTable.getSelectedRow();
            DepartmentWorkRequest emerReq = (DepartmentWorkRequest) WorkRequestTable.getValueAt(selectedRow, 0);
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
            }else {
                String msg = JOptionPane.showInputDialog("Additional Message");
                  if(msg != null)
                {
                emerReq.setStatus("Processing");
                emerReq.setMessage(msg);
                }
                populateTable();
            }
        }
    }//GEN-LAST:event_btnProcessActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable WorkRequestTable;
    private javax.swing.JButton btnAcknowledge;
    private javax.swing.JButton btnCompleteRequest;
    private javax.swing.JButton btnProcess;
    private javax.swing.JButton btnReject;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
