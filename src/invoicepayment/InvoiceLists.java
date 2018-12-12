/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoicepayment;

import da.CorCustDA;
import da.GetOrderDA;
import domain.CorOrderDomain;
import domain.CorporateCustomer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chbee
 */
public class InvoiceLists extends javax.swing.JFrame {
    
    GetOrderDA orderda = new GetOrderDA();
    DefaultTableModel model;
    CorporateCustomer corCust;
    CorCustDA corCustDA = new CorCustDA();
    ArrayList<CorOrderDomain> orderList;
   
        int invoice_no =0;
        LocalDateTime l_DateTime;
        Date invoiceDate;
        Date invoiceDate2;
        
        double ttlPay = 0;
        String status;
        String invoice_date;
        Object[] row;
    
     private Date LocalCalender(){
        
        l_DateTime = LocalDateTime.now();
        Date CalenderDate = Date.from(l_DateTime.atZone(ZoneId.systemDefault()).toInstant());
        return CalenderDate;
    }
     
     public InvoiceLists() throws ParseException {
            initComponents();
            
//            this.model = (DefaultTableModel) jTable1.getModel();
//            corCust = corCustDA.Login(name, pwd);
//            
//            
//            orderList = orderda.getRecord("CC001");
//            ID.setText(orderList.get(0).getCustID());
//            row =new Object[4];
//           
//            String firstList = orderList.get(0).getInvoice_date(); //get the month from each order record 
//            String nextList;
//            DateFormat df = new SimpleDateFormat("d MMM yyyy");
//           
//           
//                for(int i=0;i<orderList.size();i++){
//            
//                    nextList = orderList.get(i).getInvoice_date();
//                    invoiceDate = df.parse(firstList);
//                   
//                   
//                           if(firstList.equals(nextList)){
//                               
//                                status = orderList.get(i).getStatus();
//                                ttlPay += orderList.get(i).getTtl_amount();
//                                
//                            }
//                           if(!firstList.equals(nextList)){
//                                
//                                if(invoiceDate.before(LocalCalender())){
//                                    showlist(firstList);
//                                }
//                                    firstList = nextList;
//                                    ttlPay = 0;
//                                    status = orderList.get(i).getStatus();
//                                    ttlPay += orderList.get(i).getTtl_amount();
//                                
//                           }
//                           
//                    
//                }
//                invoiceDate2 = df.parse(firstList);
//                    if(invoiceDate2.before(LocalCalender())){
//                               
//                           showlist(firstList);
//                    }
//               Print.setVisible(false);
    }

     public InvoiceLists(String name, String pwd) throws ParseException {
            initComponents();
            
            this.model = (DefaultTableModel) jTable1.getModel();
            corCust = corCustDA.Login(name, pwd);
            String getID = corCust.getId();
            
            orderList = orderda.getRecord(getID);
            ID.setText(orderList.get(0).getCustID());
            row =new Object[4];
           
            String firstList = orderList.get(0).getInvoice_date(); //get the month from each order record 
            String nextList;
            DateFormat df = new SimpleDateFormat("d MMM yyyy");
           
           
                for(int i=0;i<orderList.size();i++){
            
                    nextList = orderList.get(i).getInvoice_date();
                    invoiceDate = df.parse(firstList);
                   
                   
                           if(firstList.equals(nextList)){
                               
                                status = orderList.get(i).getStatus();
                                ttlPay += orderList.get(i).getTtl_amount();
                                
                            }
                           if(!firstList.equals(nextList)){
                                
                                if(invoiceDate.before(LocalCalender())){
                                    showlist(firstList);
                                }
                                    firstList = nextList;
                                    ttlPay = 0;
                                    status = orderList.get(i).getStatus();
                                    ttlPay += orderList.get(i).getTtl_amount();
                                
                           }
                           
                    
                }
                invoiceDate2 = df.parse(firstList);
                    if(invoiceDate2.before(LocalCalender())){
                               
                           showlist(firstList);
                    }
               Print.setVisible(false);
    }
    
    
    private void showlist(String date){
         row[0]= ++invoice_no;
         row[1]= date;
         row[2]= String.valueOf(ttlPay);
         row[3]= status;
         model.addRow(row);
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        InvoiceStatement = new javax.swing.JTextArea();
        IDLabel = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        Print = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Title.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        Title.setText("Invoice");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice No", "Invoice Date", "Total Amount", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Status");
        }

        InvoiceStatement.setColumns(20);
        InvoiceStatement.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        InvoiceStatement.setRows(5);
        jScrollPane2.setViewportView(InvoiceStatement);

        IDLabel.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        IDLabel.setText("Customer ID:");

        ID.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        ID.setText("ID");

        Print.setText("Print");
        Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(IDLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ID)
                        .addGap(57, 57, 57)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Print, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(344, 344, 344))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Title)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(IDLabel)
                                .addComponent(ID)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(Print, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int i= jTable1.getSelectedRow();
        String getInvoicedate = model.getValueAt(i,1).toString();
        
        corCust = corCustDA.getRecord(ID.getText());
        orderList = orderda.getRecord(ID.getText());
        
                    InvoiceStatement.setText("FLOWER SHOP\n"+"No.102, JALAN PUDU, 55100 KUALA LUMPUR, MALAYSIA.\n"
                                            +"Tel: 03-2033 2233   Fax:03-2070 0345\n"+"E-mail:enquiry@flowershop.com.my");
                    InvoiceStatement.append("\n"+"_____________________________________________________________________________________________________");
        
                    InvoiceStatement.append("\nBill To: \t\t\t\t\t       Invoice date: "+ model.getValueAt(i, 1).toString()+"\n");
        
                    InvoiceStatement.append(corCust.getName()+"\n"+corCust.getCompanyName()+"\n"+corCust.getCompanyAddress()+"\n");
                    InvoiceStatement.append("=============================================================================================");
                    InvoiceStatement.append("\nOrderID  |     Order Date     | \tDescription\t\t |  Quantity  | Unit Price(RM) |  Total Amount(RM)\n");
                    InvoiceStatement.append("=============================================================================================\n");
        
        for(int j=0;j<orderList.size();j++){
            
            if(getInvoicedate.equals(orderList.get(j).getInvoice_date())){
                    InvoiceStatement.append(orderList.get(j).getOrderID()+"          "+orderList.get(j).getOrder_date()+
                                            "\t"+orderList.get(j).getProductName()+"\t\t       "+orderList.get(j).getQuantity()+
                                            "\t    "+orderList.get(j).getUnit_price()+"\t      "+orderList.get(j).getTtl_amount()+"\n\n");
                        
            }
        }
                    InvoiceStatement.append("=============================================================================================\n");
                    InvoiceStatement.append("\t\t\t\t\t       Total Payment : RM "+model.getValueAt(i,2).toString());
                    double ttl_pay = Double.parseDouble(model.getValueAt(i,2).toString());
                    String credit = String.valueOf(corCust.getCreditLimit()-ttl_pay);
                    InvoiceStatement.append("\n\t\t\t\t\t  Credit Remaining : RM "+credit);
                    
                    Print.setVisible(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintActionPerformed
        try{
            Boolean ppt = InvoiceStatement.print();
            if(ppt){
                JOptionPane.showMessageDialog(null,"Done");
            }else{
                JOptionPane.showMessageDialog(null,"Printing");
            }
        }catch(Exception ex){
            ex.getMessage();
        }
    }//GEN-LAST:event_PrintActionPerformed

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
            java.util.logging.Logger.getLogger(InvoiceLists.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvoiceLists.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvoiceLists.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvoiceLists.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new InvoiceLists().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(InvoiceLists.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ID;
    private javax.swing.JLabel IDLabel;
    private javax.swing.JTextArea InvoiceStatement;
    private javax.swing.JButton Print;
    private javax.swing.JLabel Title;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
