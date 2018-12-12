/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import domain.CorOrderDomain;
import domain.CorporateCustomer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Chun Haur Lim
 */
public class CorCustDA {
    private String host = "jdbc:derby://localhost:1527/flowershopdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "COR_CUST";
    private Connection conn;
    private PreparedStatement stmt;
    
    
    public CorCustDA(){
        createConnection();
    }
    
    public CorporateCustomer Login(String name,String password) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE NAME = ? and PASSWORD = ? ";
       CorporateCustomer cCust = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, name);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
              
               cCust = new CorporateCustomer(rs.getString(1),name,rs.getString(3),password,rs.getString(5),rs.getString(6),rs.getDouble(7));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return cCust;
    }
    
     public CorporateCustomer getRecord(String Ccust_id) {
         
      String queryStr="SELECT * FROM " + tableName + " WHERE ID = ?";
         CorporateCustomer member = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1,Ccust_id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                member = new CorporateCustomer(Ccust_id,rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5),rs.getString(6), rs.getDouble(7));
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return member;
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
    
    public static void main(String[] args) {
        
       CorCustDA da = new CorCustDA();
       CorporateCustomer cc = da.Login("Ali","abcd1234");
       
       CorporateCustomer cc2 = da.getRecord("CC001");
       
        System.out.println(cc2);
        
    }
}


