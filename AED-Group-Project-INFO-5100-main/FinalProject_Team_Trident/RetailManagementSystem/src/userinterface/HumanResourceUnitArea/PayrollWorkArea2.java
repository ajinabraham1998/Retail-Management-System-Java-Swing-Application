/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.HumanResourceUnitArea;

import Model.EcoSystem;
import Model.Enterprise.Enterprise;
import Model.HumanResource.HumanR;
import Model.HumanResource.HREmpList;
import Model.Location.Location;
import Model.Organization.HumanResourceOrganization;
import Model.Organization.Organization;

import Model.UserAccount.UserAccount;


import Model.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author felicia
 */
public class PayrollWorkArea2 extends javax.swing.JPanel {

    /**
     * Creates new form PayrollWorkArea2
     */
    JPanel userProcessContainer;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private EcoSystem ecoSystem;
//    private MedicalInventoryList mil;
    private Organization org;
    private HumanResourceOrganization payrollorg;
    private Location location;
    private static Logger log = Logger.getLogger(PayrollWorkArea2.class);
    private static final String CLASS_NAME = PayrollWorkArea2.class.getName();

    public PayrollWorkArea2(JPanel userProcessContainer, UserAccount userAccount, Organization organization, Enterprise enterprise, 
            Location loaction,EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
//        this.payrollorg = organization;
        this.location = loaction;
        this.ecoSystem = ecoSystem;
        reorderTable();
//        populateDocTable();
        log.debug(userAccount+" "+"logged in");
    }

    public void reorderTable() {
        int rowCount = reorderTable.getRowCount();
        DefaultTableModel model = (DefaultTableModel) reorderTable.getModel();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        for (HumanR mi : payrollorg.getHRList()) {
            Object row[] = new Object[6];
            row[0] = mi;
            row[1] = mi.getSerialNumber();
            row[2] = mi.getAvailQuantity();
            row[3] = mi.getRequiredQuantity();
            row[4] = mi.getReorderStatus();
            //row[5] = mi.getReorderStatus();
            model.addRow(row);
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
        reorderTable = new javax.swing.JTable();
        serialNumLbl = new javax.swing.JLabel();
        serialNumberTxtField = new javax.swing.JTextField();
        departmentNameLbl = new javax.swing.JLabel();
        departmentNameTxtField = new javax.swing.JTextField();
        availQuantityLbl = new javax.swing.JLabel();
        availQuantityTxtField = new javax.swing.JTextField();
        reqQuantityLbl = new javax.swing.JLabel();
        addDepartmentBtn = new javax.swing.JButton();
        payrollLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reorderTable.setBorder(new javax.swing.border.MatteBorder(null));
        reorderTable.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 20)); // NOI18N
        reorderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EMPLOYEE NAME", "EMPLOYEE NAME ", "AVAILABILE INCENTIVE", "STATUS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        reorderTable.setRowHeight(25);
        jScrollPane1.setViewportView(reorderTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 111, 871, 160));

        serialNumLbl.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 24)); // NOI18N
        serialNumLbl.setForeground(new java.awt.Color(0, 0, 102));
        serialNumLbl.setText("EMPLOYEE ID: ");
        add(serialNumLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 210, 23));

        serialNumberTxtField.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 20)); // NOI18N
        add(serialNumberTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 382, 252, 30));

        departmentNameLbl.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 24)); // NOI18N
        departmentNameLbl.setForeground(new java.awt.Color(0, 0, 102));
        departmentNameLbl.setText("EMPLOYEE NAME: ");
        add(departmentNameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 430, 230, 25));

        departmentNameTxtField.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 20)); // NOI18N
        add(departmentNameTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 423, 252, 30));

        availQuantityLbl.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 24)); // NOI18N
        availQuantityLbl.setForeground(new java.awt.Color(0, 0, 102));
        availQuantityLbl.setText("AVAILABLE INCENTIVE:");
        add(availQuantityLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 467, 282, -1));

        availQuantityTxtField.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 20)); // NOI18N
        add(availQuantityTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, 252, 30));

        reqQuantityLbl.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 24)); // NOI18N
        reqQuantityLbl.setForeground(new java.awt.Color(0, 0, 102));
        reqQuantityLbl.setText("Status :");
        add(reqQuantityLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 520, -1, -1));

        addDepartmentBtn.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 24)); // NOI18N
        addDepartmentBtn.setForeground(new java.awt.Color(0, 0, 102));
        addDepartmentBtn.setText("ADD");
        addDepartmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDepartmentBtnActionPerformed(evt);
            }
        });
        add(addDepartmentBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 580, 251, -1));

        payrollLbl.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 48)); // NOI18N
        payrollLbl.setForeground(new java.awt.Color(0, 0, 102));
        payrollLbl.setText("Payroll Work Area");
        add(payrollLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/pharamacy.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/medicine.jpg"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 570, 110, 60));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 520, 250, 30));

        jLabel2.setText("jLabel2");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void addDepartmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDepartmentBtnActionPerformed
        // TODO add your handling code here:

        HumanR m = new HumanR();
        String name = departmentNameTxtField.getText().trim();
        String error_message = "";
        String avail = availQuantityTxtField.getText();
        try {
            Integer.parseInt(avail);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Available quantity must be integer");
            return;

        }
        if(name.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please enter the name ");
            return;
        }
        
        m.setHRName(departmentNameTxtField.getText());
        try{
        int availableQuantity = Integer.parseInt(availQuantityTxtField.getText());
        m.setAvailQuantity(availableQuantity);
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "serial number must be integer!");
            return;
        }
        try{
        int serialNumber = Integer.parseInt(serialNumberTxtField.getText());
        m.setSerialNumber(serialNumber);
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "serial number must be integer!");
            return;
        }
        //String req = reqQuantityTxtField.getText();
        try {
           
           // m.setRequiredQuantity( Integer.parseInt(req));
        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(null, "Required quantity must be integer!");
            return;
        }
       

        payrollorg.addDepartment(m);
        m.setReorderStatus("N");

        DefaultTableModel dtm = (DefaultTableModel) reorderTable.getModel();

        dtm.setRowCount(0);
        for (HumanR mi : payrollorg.getHRList()) {
            Object row[] = new Object[5];
            row[0] = mi;
            row[1] = mi.getSerialNumber();
            row[2] = mi.getAvailQuantity();
            row[3] = mi.getRequiredQuantity();
            row[4] = mi.getReorderStatus();
            dtm.addRow(row);
        }

        JOptionPane.showMessageDialog(null, "Added Successfully", "Warning", JOptionPane.INFORMATION_MESSAGE);
        log.debug("added successfully");
        serialNumberTxtField.setText("");
        departmentNameTxtField.setText("");
        availQuantityTxtField.setText("");
        //reqQuantityTxtField.setText("");

    }//GEN-LAST:event_addDepartmentBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDepartmentBtn;
    private javax.swing.JLabel availQuantityLbl;
    private javax.swing.JTextField availQuantityTxtField;
    private javax.swing.JLabel departmentNameLbl;
    private javax.swing.JTextField departmentNameTxtField;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel payrollLbl;
    private javax.swing.JTable reorderTable;
    private javax.swing.JLabel reqQuantityLbl;
    private javax.swing.JLabel serialNumLbl;
    private javax.swing.JTextField serialNumberTxtField;
    // End of variables declaration//GEN-END:variables
}
