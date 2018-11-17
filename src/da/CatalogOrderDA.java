/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import domain.CatalogOrderDomain;

/**
 *
 * @author USER
 */
public class CatalogOrderDA {
    private String host = "jdbc:derby://localhost:1527/CatalogOrderdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "NBUSER.\"CATALOGORDER\"";
    private Connection conn;
    private PreparedStatement stmt;

    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Date date = new Date();
  
    public boolean AddOrder(CatalogOrderDomain order){
        String insertStr = "INSERT INTO " + tableName + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        boolean answer = false;
        try {
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, order.getOrderID());
            stmt.setString(2, order.getCustName());
            stmt.setString(3, order.getCustEmail());
            stmt.setString(4, order.getCustContact());
            stmt.setString(5, order.getDeliverAdd());
            stmt.setInt(6, order.getQuantity());
            stmt.setString(7, order.getPickUpDate());
            stmt.setString(8, order.getPickUpTime());
            stmt.setString(9, order.getPaymentMethod());
            stmt.setString(10, order.getPickUpMethod());
            stmt.executeUpdate();
            answer = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

     return answer;
    }
    
     private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
      public CatalogOrderDA(){
      createConnection();
    }
      
}
