/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ProductWorkArea;

import Model.EcoSystem;
import Model.Enterprise.Enterprise;
import Model.Product.ProductList;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import userinterface.SystemAdminWorkArea.SystemAdminWorkAreaJPanel;

/**
 *
 * @author felicia
 */
public class AddProductJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AddProductJPanel
     */
    JPanel userProcessContainer;
    Enterprise enterprise;
    EcoSystem ecosystem;
    public AddProductJPanel(JPanel userProcessContainer, Enterprise enterprise, EcoSystem ecosystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecosystem = ecosystem;
        this.enterprise = enterprise;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCost = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAvailQuant = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTotalCost = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("ADD NEW PRODUCT");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 282, 33));

        jLabel2.setText("Product Name :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 88, -1, -1));
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 83, 200, -1));

        jLabel3.setText("Product Description :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 144, -1, -1));
        add(txtDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 139, 200, -1));

        jLabel4.setText("Product Cost :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 200, -1, -1));
        add(txtCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 195, 200, -1));

        jLabel5.setText("Quantity :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 251, -1, -1));
        add(txtAvailQuant, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 251, 200, -1));

        jLabel6.setText("Total Cost :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 312, -1, -1));

        txtTotalCost.setEditable(false);
        add(txtTotalCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 307, 200, -1));

        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 363, 145, -1));

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 363, 103, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ProductsBG1.png"))); // NOI18N
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 650));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       
        ProductList enterpriseList = ecosystem.getEquipmentList();
        String ProductName = txtName.getText();
        String productDesc = txtDesc.getText();
        String productAvail = txtAvailQuant.getText();
        String productCost = txtCost.getText();
        if(ProductName.isEmpty() || productDesc.isEmpty() || productAvail.isEmpty() ||  productCost.isEmpty() )
        {
             JOptionPane.showMessageDialog(null,"Please fill all Fields");
             return;
        }
        
        double Totalcost = Integer.parseInt(productAvail) * Double.parseDouble(productCost);
        txtTotalCost.setText(String.valueOf(Totalcost));
        enterpriseList.addNewEquip(ProductName, productDesc, productAvail, Double.parseDouble(productCost),Totalcost);
        JOptionPane.showMessageDialog(null,"Product Added Successfully");
                
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
           userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ProductWorkAreaJPanel sysAdminwjp = (ProductWorkAreaJPanel) component;
        sysAdminwjp.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtAvailQuant;
    private javax.swing.JTextField txtCost;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtTotalCost;
    // End of variables declaration//GEN-END:variables
}
