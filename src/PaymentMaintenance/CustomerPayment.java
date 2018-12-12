/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaymentMaintenance;

import Interface.CustomerPayInterface;
import Interface.ImplementCustPay;
import da.CustPayment;
import domain.CatalogFlow;
import domain.CatalogOrderDomain;
import domain.CustPayDomain;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Chun Haur Lim
 */
public class CustomerPayment extends javax.swing.JFrame {
   
   CustPayment cp=new CustPayment();
    
   //DATA FROM ORDER & PRODUCTS
         List PayDetails = new ArrayList<CatalogOrderDomain>();
         //CatalogOrderDomain order = new CatalogOrderDomain("O1002","Rose","Jammy","vbn@gmail.com","0162233332", "No. 45 11/19N Taman Passed, Jlan geting kelang , 54600 Selangor", 2, "12/12/2018"," 2.00pm", "Delivery");
   
         List FlowerDetails = new ArrayList<CatalogFlow>(); 
         CatalogFlow product = new CatalogFlow("F1001", "Rose", "Red in colour with nice fragrance", "RM 10", "Available");
   
         CustomerPayInterface  Pay_Amt=new ImplementCustPay();
         CustomerPayInterface  Total_Bill=new ImplementCustPay();
         CustomerPayInterface  Change=new ImplementCustPay();
   
            String order_id;
            int click_count =0;
            double bill;
            double sst;      
            double T_bill;      
   
    public CustomerPayment() throws ClassNotFoundException {
        
        initComponents();
        
        //conn = CustPayment.connect();//Connect to CustPayment database
        
        jTextArea1.setText("Payment ID : "+cp.autoId()+"\n");//auto generate payment id (call method)
        PAY_ID.setText(cp.autoId());
        PAY_ID.setVisible(false);
        Error.setVisible(false);
        
            //PayDetails.add(order);//add order data to PayDetails ArrayList
            FlowerDetails.add(product);//add product data to PayDetails ArrayList
                
            //Get specific data from arraylist
                order_id = ((CatalogOrderDomain)PayDetails.get(0)).getOrderID();
                int quantity = ((CatalogOrderDomain)PayDetails.get(0)).getQuantity();
                String p_name =  ((CatalogFlow)FlowerDetails.get(0)).getFlower_name();
                Double p_price = Double.parseDouble(((CatalogFlow)FlowerDetails.get(0)).getFlower_price().substring(2));
         
                    bill = quantity * p_price;
                    sst=bill *0.06;
                    T_bill = bill+sst;
        
                        jTextArea1.append("Order ID: "+order_id+"\n\nDescription \t\t\t\tAmount\n"
                        + "==========================================================\n"
                        +p_name+" x"+quantity+"\t\t\t\tRM"+String.format("%.2f",bill)+"\n"
                        + "==========================================================\n"
                        + "\t\t\t            SubTotal: RM "+String.format("%.2f",bill)+"\n"
                        + "\t\t\t             SST(6%): RM "+String.format("%.2f",sst)+"\n"
                        + "==========================================================\n"
                        + "\t\t\t                Total: RM "+String.format("%.2f",T_bill)+"\n");
        
      
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
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        Payment = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Error = new javax.swing.JLabel();
        PAY_ID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Pay Amount (RM)");

        jTextField1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Order Summary");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        Payment.setText("Confirm Payment");
        Payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentActionPerformed(evt);
            }
        });

        Reset.setText("Reset");
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });

        Error.setForeground(new java.awt.Color(255, 51, 51));
        Error.setText("Error");

        PAY_ID.setText("Pay_ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(Payment, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Error)))
                    .addComponent(PAY_ID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(174, 174, 174))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(PAY_ID)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Error, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Payment, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
   
    //Reset button
    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
       
       jTextField1.setText("");
       Error.setVisible(false);
       
    }//GEN-LAST:event_ResetActionPerformed

    //Payment Button
    private void PaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentActionPerformed
       
        try{
            Double enterAmt = Double.parseDouble(jTextField1.getText()); 
            
            Pay_Amt.setPayAmount(enterAmt); //Customer Pay amount
            Total_Bill.setPayAmount(T_bill);//Total Payment 
            Change = Pay_Amt.substact(Total_Bill); //Customer Pay amount - Total Payment Amount
         
                    if(Pay_Amt.getPayAmount()>= T_bill && click_count == 0){
             
                        jTextArea1.append("\n\t\t\t              Cash: RM "+String.format("%.2f",Pay_Amt.getPayAmount())+"\n");
                        jTextArea1.append("\t\t\t              Change: RM "+Change.toString());
                        
                        CustPayDomain cpd = new CustPayDomain(PAY_ID.getText(),order_id,T_bill);
                        cp.addRecord(cpd);
                        
                        click_count++;
                        Error.setVisible(false);
                        
                    }else if(Pay_Amt.getPayAmount()< T_bill ){
             
                        Error.setText("Pay amount not enough!!!!");
                        Error.setVisible(true);
                    }
                    
        }catch(NumberFormatException e){
            
             Error.setText("Invalid input!!!!");
             Error.setVisible(true);
        }
                   
                    
      
    }//GEN-LAST:event_PaymentActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try {
                    new CustomerPayment().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CustomerPayment.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Error;
    private javax.swing.JLabel PAY_ID;
    private javax.swing.JButton Payment;
    private javax.swing.JButton Reset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
//