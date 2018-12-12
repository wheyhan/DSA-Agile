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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author chbee
 */
public class GetOrderDA {
     private String host = "jdbc:derby://localhost:1527/flowershopdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "CUST_ORDER";
    private Connection conn;
    private PreparedStatement stmt;
   
    
    public GetOrderDA(){
        createConnection();
        
    }
    
    
     public ArrayList<CorOrderDomain> getRecord(String Ccust_id) {
         
      String queryStr="SELECT * FROM " + tableName + " WHERE CUST_ID = ?";
        
        ArrayList<CorOrderDomain> orderList = new ArrayList();
        CorOrderDomain order = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1,Ccust_id);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                order = new CorOrderDomain(rs.getString(1),Ccust_id,rs.getString(3),rs.getInt(4),rs.getString(5),rs.getDouble(6),rs.getString(7),rs.getString(8),rs.getString(9));
                orderList.add(order);
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return orderList;
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
    public static void main(String[] args){
       
        GetOrderDA order = new GetOrderDA(); 
        ArrayList<CorOrderDomain> co= order.getRecord("CC001");
        System.out.println(co);
    }
    
}
