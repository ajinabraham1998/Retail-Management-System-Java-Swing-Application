/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ProductWorkArea;

import Model.EcoSystem;
import Model.Employee.Employee;
import Model.Enterprise.Enterprise;
import Model.Product.Product;
import Model.Product.ProductList;
import Model.Location.Location;
import Model.Organization.Organization;
import Model.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.CustomerServiceUnitAdminArea.CustomerServiceUnitManageEmployeeJPanel;

/**
 *
 * @author felicia
 */
public class ProductWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ProductWorkAreaJPanel
     */
    JPanel userProcessContainer;
    Enterprise enterprise;
    EcoSystem ecosystem;
    ProductList productList;
    Location location;
    UserAccount userAccount;
    Organization organization;
    public ProductWorkAreaJPanel(JPanel userProcessContainer, UserAccount userAccount,Location location, Enterprise enterprise,
            Organization organization,EcoSystem ecosystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.ecosystem = ecosystem;
        this.productList = ecosystem.getEquipmentList();
        this.location = location;
        this.userAccount = userAccount;
        this.organization = organization;
        populateTable();
    }
    
    public void populateTable()
    {
         DefaultTableModel model = (DefaultTableModel) tblProductList.getModel();

        model.setRowCount(0);

        for (Product equipment : ecosystem.getEquipmentList().getproductList()) {
            Object[] row = new Object[5];
            double cost = equipment.getCost();
            int qunt = Integer.parseInt(equipment.getAvailableQuant());
            row[0] = equipment.getproductID();
            row[1] = equipment.getproductName();
            row[2] = equipment.getAvailableQuant();
            row[3] = equipment.getCost();
            row[4] = cost * qunt ;
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductList = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("PRODUCT CATALOG ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, 40));

        tblProductList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Available Quantity", "Product Cost", "Total Cost"
            }
        ));
        jScrollPane1.setViewportView(tblProductList);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 89, 668, 183));

        jButton1.setText("Add New Product");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 322, 220, -1));

        jButton2.setText("Request for Product");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(481, 322, 220, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ProductsBG1.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 620));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         AddProductJPanel mujp = new AddProductJPanel(userProcessContainer, enterprise, ecosystem);
        userProcessContainer.add("AddEquipmentJPanel",mujp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         ProductRequestJPanel mujp = new ProductRequestJPanel(userProcessContainer,location, enterprise,organization , userAccount,ecosystem);
        userProcessContainer.add("AddEquipmentJPanel",mujp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProductList;
    // End of variables declaration//GEN-END:variables
}