/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;


import PaymentMaintenance.CustomerPayment;
import domain.CustPayDomain;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Chun Haur Lim
 */
public class CustPayment {
    private String host = "jdbc:derby://localhost:1527/flowershopdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "CUST_PAYMENT";
    private Connection conn;
    private PreparedStatement stmt;
          
    public CustPayment(){
        createConnection();
        
    }
    
   

    public void addRecord(CustPayDomain payRecord) {
        
         String insertStr="INSERT INTO "+tableName+ "(PAY_ID,ORDER_ID,TOTAL_PAY)" + " VALUES(?,?,?)";
         try{         
                    stmt=conn.prepareStatement(insertStr);
                    stmt.setString(1,payRecord.getPayment_id());
                    stmt.setString(2,payRecord.getOrder_id());
                    stmt.setDouble(3, payRecord.getTotal_Payment());
                   
                    
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Customer Payment Recorded ","Message",JOptionPane.INFORMATION_MESSAGE);
                 
                    
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
    }
    }
    
    public CustPayDomain getRecord(String code) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE PAY_ID= ?";
        CustPayDomain book = null;
        
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, code);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
               
              
               book=new CustPayDomain(code,rs.getString(2),rs.getDouble(3));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return book;
    }
    
    public String autoId(){
        
        String ftxt = null;
        try{
            String insertStr="SELECT PAY_ID FROM "+tableName+" ORDER BY PAY_ID DESC FETCH FIRST ROW ONLY";
            PreparedStatement PreparedStatement = conn.prepareStatement(insertStr);
            ResultSet rs = PreparedStatement.executeQuery();
            
                if(rs.next()){
                    String rnno=rs.getString("PAY_ID");
                    int co = rnno.length();
                    String txt=rnno.substring(0,1);
                    String num=rnno.substring(1, co);
                    int n=Integer.parseInt(num);
                    n++;
                    String s_num= Integer.toString(n);
                    ftxt = txt + s_num;
                }
                else{
                    ftxt ="P1001";
                }
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return ftxt;
    }
    
    
    private void createConnection() {
       try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
     private void shutDown() {
        if (conn != null)
            try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    /* public static void main(String args[]){
         CustPayDomain cpd = new CustPayDomain("P0005","O0008",60.0);//DA
         CustPayment cp = new CustPayment();
         cp.addRecord(cpd);
        
         
     }*/
}
