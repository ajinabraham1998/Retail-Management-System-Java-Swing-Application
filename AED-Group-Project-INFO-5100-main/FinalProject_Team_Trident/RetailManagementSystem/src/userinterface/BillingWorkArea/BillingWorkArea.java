/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.BillingWorkArea;

import Model.EcoSystem;
import Model.Enterprise.Enterprise;
import Model.Product.Product;
import Model.RetailEmployment.Department;
import Model.RetailEmployment.Agent;
import Model.Location.Location;
import Model.Organization.QueryDepartmentOrganization;
import Model.Organization.BillingOrganization;
import Model.Organization.AgentOrganization;
import Model.Organization.Organization;
import Model.UserAccount.UserAccount;
import Model.WorkQueue.DepartmentWorkRequest;
import Model.WorkQueue.BillingWorkRequest;
import Model.WorkQueue.AgentWorkRequest;
import Model.WorkQueue.EmergencyCustomerRequest;
import Model.WorkQueue.WorkRequest;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author singh
 */
public class BillingWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form BillingWorkArea
     */
      JPanel userProcessContainer;
    Enterprise enterprise;
    EcoSystem ecosystem;
    Location network;
    UserAccount userAccount;
    Organization organization;
    public BillingWorkArea(JPanel userProcessContainer, Location network,Enterprise enterprise,Organization organization
            ,UserAccount userAccount, EcoSystem ecosystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecosystem = ecosystem;
        this.enterprise = enterprise;
        this.network = network;
        this.userAccount =userAccount;
        this.organization = organization;
        populateRequestTable();
    }

    
    public void populateRequestTable()
    {
        DefaultTableModel model = (DefaultTableModel) WorkRequestTable1.getModel();

        model.setRowCount(0);
         Organization Billingorg = null;
       for(Location network : ecosystem.getLocationList())
       {
            for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList())  
            {
              for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                  if(organization instanceof BillingOrganization)
                  {
                         Billingorg =  organization;
                         BillingOrganization billorg = (BillingOrganization)organization;
                         lblfund.setText(String.valueOf(billorg.getFunds()));
                         break;
                     }
                 }
            }
       }
       
       for(WorkRequest wr : Billingorg.getWorkQueue().getWorkRequestList())
       {
           if(wr instanceof BillingWorkRequest )
           {
               BillingWorkRequest billWrkReq = (BillingWorkRequest)wr;
                Object[] row = new Object[11];
                
                row[0] = billWrkReq;
                row[1] = billWrkReq.getSender().getEmployee().getName();
                row[2] = billWrkReq.getProductId();
                row[3] = billWrkReq.getProductName();
                row[4] = billWrkReq.getProduct().getAvailableQuant() ;
                row[5] = billWrkReq.getProduct().getCost();
                row[6] = billWrkReq.getProductPrice();
                row[7] = billWrkReq.getFundAllocated();
              
                row[8] = billWrkReq.getStatus();
                row[9] = billWrkReq.getRequestdate();
                row[10] = billWrkReq.getResolveDate();
                model.addRow(row);
           }
           
       }
           //BillingWorkRequest
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        WorkRequestTable1 = new javax.swing.JTable();
        btnAcknowledge = new javax.swing.JButton();
        btnReject = new javax.swing.JButton();
        btnAccept = new javax.swing.JButton();
        btnCompleteRequest = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblfund = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        WorkRequestTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "BillingRequestId", "Sender", "EquipmentId", "EquipmentName", "No of Units", "Equipment Price", "totalEquipmentCost", "Fund Allocated", "Status", "Request Date", "Resolve Date"
            }
        ));
        jScrollPane2.setViewportView(WorkRequestTable1);

        btnAcknowledge.setText("Acknowledge");
        btnAcknowledge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcknowledgeActionPerformed(evt);
            }
        });

        btnReject.setText("Reject Request");
        btnReject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectActionPerformed(evt);
            }
        });

        btnAccept.setText("Accept");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        btnCompleteRequest.setText("Complete Request");
        btnCompleteRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteRequestActionPerformed(evt);
            }
        });

        jLabel2.setText("Funds Available :");

        lblfund.setText("<fund>");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("BILLING COUNTER");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(327, 327, 327)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(lblfund, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(272, 272, 272))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAcknowledge, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(btnReject, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(btnCompleteRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1045, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAccept, btnAcknowledge, btnCompleteRequest, btnReject});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblfund, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAcknowledge)
                    .addComponent(btnReject)
                    .addComponent(btnAccept)
                    .addComponent(btnCompleteRequest))
                .addContainerGap(245, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAccept, btnAcknowledge, btnCompleteRequest, btnReject});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcknowledgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcknowledgeActionPerformed

        int count = WorkRequestTable1.getSelectedRowCount();
        if(count != 1) {
            JOptionPane.showMessageDialog(null, "Select a request");
        }else {
            int selectedRow = WorkRequestTable1.getSelectedRow();
            BillingWorkRequest emerReq = (BillingWorkRequest) WorkRequestTable1.getValueAt(selectedRow, 0);
            
            System.out.println(emerReq.getStatus());
            
            if(emerReq.getStatus().equals("Rejected - Funds Not Available this time")) {
                JOptionPane.showMessageDialog(null, "Request is already Rejected");
            }else if(emerReq.getStatus().equals("Accepted")) {
                JOptionPane.showMessageDialog(null, "Request is already Accepted funds");            
            }else if(emerReq.getStatus().equals("Completed")) {
                JOptionPane.showMessageDialog(null, "Request is already Completed");
            }else if(emerReq.getStatus().equals("Acknowledged")) {
                JOptionPane.showMessageDialog(null, "Request is already Acknowledged");
            }           
            else {
                String msg = JOptionPane.showInputDialog("Additional Message");
                if(msg != null)
                {
                    emerReq.setStatus("Acknowledged");
                    emerReq.setMessage(msg);
                }
                populateRequestTable();
            }
            //emerReq.setStatus("Accepted");
        }
    }//GEN-LAST:event_btnAcknowledgeActionPerformed

    private void btnRejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectActionPerformed

        int count = WorkRequestTable1.getSelectedRowCount();
        if(count != 1) {
            JOptionPane.showMessageDialog(null, "Select a request");
        }else {
            int selectedRow = WorkRequestTable1.getSelectedRow();
            BillingWorkRequest emerReq = (BillingWorkRequest) WorkRequestTable1.getValueAt(selectedRow, 0);
            if(emerReq.getStatus().equals("Rejected - Funds Not Available this time")) {
                JOptionPane.showMessageDialog(null, "Request is already Rejected");
            }else if(emerReq.getStatus().equals("Accepted")) {
                JOptionPane.showMessageDialog(null, "Request is already Accepted");
            }else if(emerReq.getStatus().equals("Processing")) {
                JOptionPane.showMessageDialog(null, "Request is already Accepted and Processing");
            }else if(emerReq.getStatus().equals("Completed")) {
                JOptionPane.showMessageDialog(null, "Request is already Completed");
            }else if(emerReq.getStatus().equals("Cancelled")) {
                JOptionPane.showMessageDialog(null, "Request is already cancelled by sender");
            }else if(emerReq.getStatus().equals("Assigned Ambulance")) {
                JOptionPane.showMessageDialog(null, "Request is already Assigned for Ambulance");
            }else if(emerReq.getStatus().equals("Assigned Doctor")) {
                JOptionPane.showMessageDialog(null, "Request is already Assigned a Doctor");
            }             
            else {
                String msg = JOptionPane.showInputDialog("Additional Message");
                  if(msg != null)
                {
                emerReq.setStatus("Rejected - Funds Not Available this time");
                emerReq.setMessage(msg);
                }
                populateRequestTable();
            }
        }
        
    }//GEN-LAST:event_btnRejectActionPerformed

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed

        int count = WorkRequestTable1.getSelectedRowCount();
        if(count != 1) {
            JOptionPane.showMessageDialog(null, "Select a request");
        }else {
            int selectedRow = WorkRequestTable1.getSelectedRow();
            BillingWorkRequest emerReq = (BillingWorkRequest) WorkRequestTable1.getValueAt(selectedRow, 0);
            
            System.out.println(emerReq.getStatus());
            
            if(emerReq.getStatus().equals("Rejected - Funds Not Available this time")) {
                JOptionPane.showMessageDialog(null, "Request is already Rejected");
            }else if(emerReq.getStatus().equals("Accepted")) {
                JOptionPane.showMessageDialog(null, "Request is already Accepted");            
            }else if(emerReq.getStatus().equals("Completed")) {
                JOptionPane.showMessageDialog(null, "Request is already Completed");
            }else if(emerReq.getStatus().equals("Cancelled")) {
                JOptionPane.showMessageDialog(null, "Request is already cancelled by sender");
            }           
            else {
                String msg = JOptionPane.showInputDialog("Additional Message");
               Organization Billingorg = null;
               double funds = 0;
                 for(Location network : ecosystem.getLocationList())
       {
            for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList())  
            {
              for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                  if(organization instanceof BillingOrganization)
                  {
                         Billingorg =  organization;
                         BillingOrganization billorg = (BillingOrganization)organization;
                         funds = billorg.getFunds() - emerReq.getTotalProductCost() ;
                         lblfund.setText(String.valueOf(funds));
                         billorg.setFunds(funds);
                        // emerReq.setFundsAvailable(funds);
                         break;
                     }
                 }
            }
       }
                
                emerReq.setStatus("Accepted");
                double allocatedfunds = emerReq.getTotalProductCost();
                emerReq.setFundAllocated(allocatedfunds);
                
                emerReq.setMessage(msg);
                populateRequestTable();
            }
            //emerReq.setStatus("Accepted");
        }
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void btnCompleteRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteRequestActionPerformed

         int count = WorkRequestTable1.getSelectedRowCount();
        if(count != 1) {
            JOptionPane.showMessageDialog(null, "Select a request");
        }else {
            int selectedRow = WorkRequestTable1.getSelectedRow();
            BillingWorkRequest emerReq = (BillingWorkRequest) WorkRequestTable1.getValueAt(selectedRow, 0);
            String childStatus = emerReq.getStatus();
         
           
            if(childStatus.equals("Rejected")) {
                JOptionPane.showMessageDialog(null, "Request is already Rejected");            
            }else if(childStatus.equals("Completed")) {
                JOptionPane.showMessageDialog(null, "Request is already Completed");
            }else if(childStatus.equals("Cancelled")) {
                JOptionPane.showMessageDialog(null, "Request is already cancelled by sender");
            }else if(childStatus.equals("Requested")) {
                JOptionPane.showMessageDialog(null, "Request is not yet Accepted");
            }else {
                String msg = JOptionPane.showInputDialog("Additional Message");
                  if(msg != null)
                {
                    System.out.println("Completed");
                emerReq.setFundAllocated(emerReq.getProductPrice());
                emerReq.setStatus("Completed");
                Product equipment = emerReq.getProduct();
                int qunat = Integer.parseInt(equipment.getAvailableQuant());
                int addQuant = emerReq.getNoOfUnits();
                int total = qunat +addQuant;
                System.out.println("addQuant " + addQuant);
                System.out.println("qunat " + qunat);
                System.out.println("total " + total);
                 
                equipment.setAvailableQuant(String.valueOf(total) );
                
                 BillingOrganization Billingorg = null;
               double funds = 0;
                 for(Location network : ecosystem.getLocationList())
       {
            for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList())  
            {
              for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                  if(organization instanceof BillingOrganization)
                  {
                       Billingorg = (BillingOrganization) organization;
                        
                  }
              }
            }
       }
                double oldfund = Billingorg.getFunds();
                double newfund = oldfund - emerReq.getProductPrice();
                System.out.print(oldfund);
                   System.out.print(newfund);
                Billingorg.setFunds(newfund);
                lblfund.setText(String.valueOf(newfund));
                emerReq.setMessage(msg);
                emerReq.setResolveDate(new Date());
                }
                populateRequestTable();
            }
        }
    }//GEN-LAST:event_btnCompleteRequestActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable WorkRequestTable1;
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnAcknowledge;
    private javax.swing.JButton btnCompleteRequest;
    private javax.swing.JButton btnReject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblfund;
    // End of variables declaration//GEN-END:variables
}
