/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StaffGUI;

import Classes.*;
import java.util.HashMap;
import javax.swing.ButtonGroup;

/**
 *
 * @author 30137568
 */
public class SAddProduct extends javax.swing.JFrame
{

    // Gloabal Variables
    HashMap<String, Clothing> clothes = new HashMap<>();
    HashMap<String, Footwear> shoes = new HashMap<>();
    HashMap<Integer, Clothing> iClothes = new HashMap<>();
    HashMap<Integer, Footwear> iShoes = new HashMap<>();
    GUI gui = new GUI();
    Product prod;
    Clothing garment;
    Footwear shoe;
    String action = "added.";
    Boolean isClothing = false;
    DBManager db = new DBManager();
    boolean isFound = false;

    //Group radio buttons together so they can go from one category to another
    private void groupButton()
    {
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(rbClothing);
        bg1.add(rbFootwear);
    }

    /**
     * Creates new form SAddProduct
     */
    public SAddProduct()
    {
        initComponents();
        // Grouping Radio Buttons
        groupButton();
        // Hide textboxes
        txtName.setVisible(false);
        txtPrice.setVisible(false);
        txtStockLevel.setVisible(false);
        txtChoice.setVisible(false);
        
        // loads all clothing and footwear
        iClothes = db.loadAllClothing();
        iShoes = db.loadAllFootwear();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rbClothing = new javax.swing.JRadioButton();
        rbFootwear = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtStockLevel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lblChoice = new javax.swing.JLabel();
        txtChoice = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblResult = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Add New Product");

        jLabel2.setText("Type Of Product");

        rbClothing.setText("Clothing");
        rbClothing.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rbClothingActionPerformed(evt);
            }
        });

        rbFootwear.setText("Footwear");
        rbFootwear.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rbFootwearActionPerformed(evt);
            }
        });

        jLabel3.setText("Name");

        txtName.setMinimumSize(new java.awt.Dimension(6, 50));

        txtPrice.setMinimumSize(new java.awt.Dimension(6, 50));
        txtPrice.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtPriceActionPerformed(evt);
            }
        });

        jLabel4.setText("Price");

        txtStockLevel.setMinimumSize(new java.awt.Dimension(6, 50));

        jLabel5.setText("Stock Level");

        txtChoice.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtChoiceActionPerformed(evt);
            }
        });

        btnAdd.setText("Submit");
        btnAdd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnClearActionPerformed(evt);
            }
        });

        btnBack.setText("Return To Product Select");
        btnBack.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel3))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(4, 4, 4)))))
                                .addGap(25, 25, 25))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(lblChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbClothing)
                                .addGap(28, 28, 28)
                                .addComponent(rbFootwear))
                            .addComponent(btnBack)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtChoice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                        .addComponent(txtStockLevel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.LEADING)))))))
                .addContainerGap(299, Short.MAX_VALUE))
            .addComponent(lblResult, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rbClothing)
                    .addComponent(rbFootwear))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStockLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btnAdd)
                .addGap(18, 18, 18)
                .addComponent(btnClear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblResult, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void rbClothingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbClothingActionPerformed
        // When clothing radio button is pressed text fields are visible
        // Label text is set to measurement
        txtName.setVisible(true);
        txtPrice.setVisible(true);
        txtStockLevel.setVisible(true);
        lblChoice.setText("Measurement");
        txtChoice.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_rbClothingActionPerformed

    private void rbFootwearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFootwearActionPerformed
        // When footwear radio button is pressed text fields are visible
        // Label text is set to size
        txtName.setVisible(true);
        txtPrice.setVisible(true);
        txtStockLevel.setVisible(true);
        lblChoice.setText("Size");
        txtChoice.setVisible(true);
    }//GEN-LAST:event_rbFootwearActionPerformed

    private void txtChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChoiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChoiceActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // If the clothing radio button is selected
        if (rbClothing.isSelected())
        {

            //Taking data from text boxes and adding them to variables
            isClothing = true;
            String cName = txtName.getText();
            String price = txtPrice.getText();
            String stockLevel = txtStockLevel.getText();
            //double cPrice = Double.parseDouble(price);
            String cMeasurement = txtChoice.getText();

            // Makes sure all text fields are filled
            if (cName.equals("") || price.equals("") || stockLevel.equals("") || cMeasurement.equals(""))
            {
                lblResult.setText("Please enter an input in all fields");
            }

            else
            {
                // Checks to see if user input for cPrice and cStocklevel are the right data type
                // They can be converted to a double and integer respectively
                try
                {
                    for (Clothing c : iClothes.values())
                    {
                        if (c.getProductName().equals(cName))
                        {
                            isFound = true;
                            break;
                        }
                    }

                    if (isFound == false)
                    {
                        //Converts the string variable into a double
                        double cPrice = Double.parseDouble(price);
                        //Converts the string variable into a integer
                        int cStockLevel = Integer.parseInt(stockLevel);

                        // Creates a new clothing object
                        Clothing cloth = new Clothing(cName, cPrice, cStockLevel, cMeasurement);
                        // Adds it to the hashmap using the product name is  the key
                        clothes.put(cName, cloth);

                        // Saves clothing to the database using the clothing object
                        db.saveClothing(cloth);
                        // Loads data from the database to the hashmap that uses productId as the key
                        iClothes = db.loadAllClothing();
                        // Label to show its been added
                        gui.success(lblResult, cloth, action);
                        isFound = false;
                    }

                    else
                    {
                        lblResult.setText("Clothing's name has already been entered please enter a different name.");
                    }
                }

                // if cPrice and cStocklevel are the wrong data type
                catch (Exception ex)
                {
                    lblResult.setText("Please enter a decimal value for price and a number for stock level");
                    System.out.println(ex.getMessage());
                }
            }
        }
        // If the footwear radio button is selected
        else if (rbFootwear.isSelected())
        {
            //Taking data from text boxes and adding them to variables
            String fName = txtName.getText();
            String price = txtPrice.getText();
            String stockLevel = txtStockLevel.getText();
            String size = txtChoice.getText();
            isClothing = false;
            // Makes sure all text fields are filled
            if (fName.equals("") || price.equals("") || stockLevel.equals("") || size.equals(""))
            {
                lblResult.setText("Please enter an input in all fields");
            }

            else
            {
                // Checks to see if user input for fPrice fStocklevel and fSize are the right data type
                // They can be converted to a double and integer respectively
                try
                {
                    for (Footwear f : iShoes.values())
                    {
                        if (f.getProductName().equals(fName))
                        {
                            isFound = true;
                            break;
                        }
                    }

                    if (isFound == false)
                    {
                        //Converts the string variable into a double
                        double fPrice = Double.parseDouble(price);
                        //Converts the string variable into a integer
                        int fStockLevel = Integer.parseInt(stockLevel);
                        int fSize = Integer.parseInt(size);

                        // Creates a new footwear object
//                    Product prodF = new Product(fName, fPrice, fStockLevel);
//                    db.saveProducts(prodF);
//                    int prodFId = db.prodId(prodF);
                        Footwear fwear = new Footwear(fName, fPrice, fStockLevel, fSize);
                        // Adds it to the hashmap using the product name is  the key
                        shoes.put(fName, fwear);
                        // Saves footwear to the database using the footwear object
                        db.saveFootwear(fwear);
                        // Loads data from the database to the hashmap that uses productId as the key
                        iShoes = db.loadAllFootwear();
                        // Label to show its been added
                        gui.success(lblResult, fwear, action);
                    }

                    else
                    {

                    }

                }
                // if fPrice, fStocklevel and fSize are the wrong data type
                catch (Exception ex)
                {
                    lblResult.setText("Please enter a decimal value for price and a number for stock level and size.");
                    System.out.println(ex.getMessage());
                }
            }
        }
        //If radio button has not been selected
        else
        {
            lblResult.setText("Please select clothing or footwear");
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        // Clears user input
        txtName.setText("");
        txtPrice.setText("");
        txtStockLevel.setText("");
        txtChoice.setText("");

    }//GEN-LAST:event_btnClearActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        // Takes you to the modify product page takes in iClothes and iShoes as parameters
        SModifyProducts mp = new SModifyProducts(iClothes, iShoes);
        this.dispose();
        mp.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(SAddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(SAddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(SAddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(SAddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new SAddProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblChoice;
    private javax.swing.JLabel lblResult;
    private javax.swing.JRadioButton rbClothing;
    private javax.swing.JRadioButton rbFootwear;
    private javax.swing.JTextField txtChoice;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtStockLevel;
    // End of variables declaration//GEN-END:variables
}
