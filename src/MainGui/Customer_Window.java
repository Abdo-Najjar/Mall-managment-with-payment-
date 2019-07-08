package MainGui;

import Database.DBMaker;
import Entities.Department;
import Entities.Product;
import Entities.UnAvailableState;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author user
 */
public class Customer_Window extends javax.swing.JFrame {

    /**
     * Creates new form Customer_Window
     */
    public static DefaultListModel<String> departmentsModel;
    public static DefaultListModel<String> productsModel;
    private String selectedDepartmentName;
    private String selectedProductedName;
    private static int Cid;
    private int selectedDepartmentId;
    private int selectedProductId;

    public Customer_Window(double balance, int Cid) {
        initComponents();
        GuiMethods.addWindowListener(this);
        intialization();
        balanceLabel.setText("Balance : " + String.valueOf(balance));
        Customer_Window.Cid = Cid;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        Timelabel = new javax.swing.JLabel();
        Logout = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        departmentsList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        productsList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        balanceLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        descriptionArea = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        priceLabel = new javax.swing.JLabel();
        quantityLabel = new javax.swing.JLabel();
        stateLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        qOrder = new javax.swing.JSpinner();
        orderButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel16.setFont(new java.awt.Font("Ubuntu", 3, 18)); // NOI18N
        jLabel16.setForeground(java.awt.Color.lightGray);
        jLabel16.setText("Welcome  Customer\")");

        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        departmentsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                departmentsListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(departmentsList);

        jLabel1.setText("Departments :");

        productsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productsListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(productsList);

        jLabel2.setText("Products:");

        descriptionArea.setColumns(20);
        descriptionArea.setRows(5);
        jScrollPane3.setViewportView(descriptionArea);

        priceLabel.setText(" ");

        quantityLabel.setText(" ");

        stateLabel.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(quantityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(priceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantityLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stateLabel)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLabel4.setText("State:");

        jLabel3.setText("Price:");

        jLabel5.setText("Quantity:");

        jLabel6.setText("Description:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        orderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Quantity order :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(24, 24, 24)
                .addComponent(qOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(orderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(orderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Timelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(balanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(balanceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Timelabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        GuiMethods.Logout(this);
    }//GEN-LAST:event_LogoutActionPerformed

    private void departmentsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_departmentsListMouseClicked
        if (departmentsList.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "Depaertment list is Empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (selectedDepartmentName.equals(departmentsList.getSelectedValue())) {
            return;
        }
        viewDepartmentProbabilities();
    }//GEN-LAST:event_departmentsListMouseClicked

    private void productsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productsListMouseClicked

        if (productsList.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "Empty Product List", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (selectedProductedName.equals(productsList.getSelectedValue())) {
            return;
        }

        viewProductprobabilities();
    }//GEN-LAST:event_productsListMouseClicked

    private void orderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderButtonActionPerformed
        makeOrder();
    }//GEN-LAST:event_orderButtonActionPerformed

    private final Thread t = new Thread() {
        @Override
        public void run() {
            while (true) {
                Date date = new Date();
                String strDateFormat = "hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
                String formattedDate = dateFormat.format(date);
                Timelabel.setText("Time : " + formattedDate);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }
        }
    };

    private void viewDepartmentProbabilities() {
        selectedDepartmentName = departmentsList.getSelectedValue();
        Department selectedDepartment = DBMaker.getDBMaker().getDepartmentMaker(selectedDepartmentName);
        selectedDepartmentId = selectedDepartment.getDid();
        productsModel.removeAllElements();
        DBMaker.getDBMaker().getAllProductFromDepartmentMaker(selectedDepartment.getDid()).forEach((t) -> {
            productsModel.addElement(t.getProductName());
        });

    }

    private void viewProductprobabilities() {
        selectedProductedName = productsList.getSelectedValue();
        Product selectedProduct = DBMaker.getDBMaker().getProductMaker(productsList.getSelectedValue());
        selectedProductId = selectedProduct.getPid();
        priceLabel.setText(String.valueOf(selectedProduct.getPrice()));
        stateLabel.setText(selectedProduct.getState().isAvailable());
        quantityLabel.setText(String.valueOf(selectedProduct.getQuantity()));
        descriptionArea.setText(selectedProduct.getProductDescription());
        priceLabel.setForeground(Color.orange);
        descriptionArea.setForeground(Color.black);
        if (quantityLabel.getText().equalsIgnoreCase("0")) {
            qOrder.setEnabled(false);
            stateLabel.setForeground(Color.red);
            quantityLabel.setForeground(Color.red);
            descriptionArea.setForeground(Color.BLUE);

            return;
        }
        qOrder.setModel(new SpinnerNumberModel(1, 1, Integer.parseInt(quantityLabel.getText()), 1));
        qOrder.setEnabled(true);
        stateLabel.setForeground(Color.GREEN);
        quantityLabel.setForeground(Color.GREEN);
        descriptionArea.setForeground(Color.BLUE);

    }

    private void intialization() {
        departmentsModel = new DefaultListModel<>();
        departmentsList.setModel(departmentsModel);
        productsModel = new DefaultListModel<>();
        productsList.setModel(productsModel);
        GuiMethods.viewDepartmentsForCustomer();
        new GuiMethods().setIcon(Logout, "imgs/index.png", 100, 50);
        new GuiMethods().setIcon(orderButton, "imgs/order.jpg", 100, 50);
        descriptionArea.setLineWrap(false);
        selectedDepartmentName = "null";
        selectedProductedName = "null";
        t.start();
    }

    public static void main(String[] args) {
        new Customer_Window(10000, 7).setVisible(true);
    }

    private void makeOrder() {
        if(productsList.getSelectedValue()==null||departmentsList.getSelectedValue()==null){
            JOptionPane.showMessageDialog(Customer_Window.this, "Error message");
            return;
        }
        double balance = Double.parseDouble(balanceLabel.getText().substring(10));
        String balanceString = balanceLabel.getText().substring(0, 10);
        int quantity = Integer.valueOf(quantityLabel.getText());
        double price = Double.parseDouble(priceLabel.getText());
        int quantityOrder = (int) (qOrder.getValue());
        double totalOrder = price * quantityOrder;
        if (balance >= totalOrder && (int) (qOrder.getValue()) <= Integer.parseInt(quantityLabel.getText())) {
            String ObjButtons[] = {"Yes", "No"};
            int PromptResult = JOptionPane.showOptionDialog(null,
                    "Are you sure you want to Order?\ntotal order: " + totalOrder, "Order",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    ObjButtons, NORMAL);
            if (PromptResult == 0) {
                balance = balance - totalOrder;
                DBMaker.getDBMaker().updateCustomerMaker(DBMaker.getDBMaker().getCustomerMaker(Cid).setBalance(balance));
                balanceLabel.setText(balanceString + String.valueOf(balance));
                DBMaker.getDBMaker().updateProductMaker(selectedProductedName, price, quantity - quantityOrder, selectedDepartmentId, descriptionArea.getText(), selectedProductId);
                JOptionPane.showMessageDialog(this, "The opreation made successfully");
                quantityLabel.setText(String.valueOf(quantity - quantityOrder));

                if (quantityLabel.getText().equals("0")) {
                    stateLabel.setText(new UnAvailableState().isAvailable());
                    stateLabel.setForeground(Color.red);
                    quantityLabel.setForeground(Color.red);
                }
                DBMaker.getDBMaker().sendTransactionMaker(quantityOrder, selectedProductedName, DBMaker.getDBMaker().getCustomerMaker(Cid).getUserName());
            }
        } else {
            JOptionPane.showMessageDialog(this, "You Dont have enough Money to Make this order", "Error message", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Logout;
    private javax.swing.JLabel Timelabel;
    private javax.swing.JLabel balanceLabel;
    private javax.swing.JList<String> departmentsList;
    private javax.swing.JTextArea descriptionArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton orderButton;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JList<String> productsList;
    private javax.swing.JSpinner qOrder;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JLabel stateLabel;
    // End of variables declaration//GEN-END:variables
}
