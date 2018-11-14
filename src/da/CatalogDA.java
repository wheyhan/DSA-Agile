/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import domain.CatalogFlow;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author JianHao
 */
public class CatalogDA {
    
    private String host = "jdbc:derby://localhost:1527/CatalogDB";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "FLOWER";
    private String sqlQueryStr = "SELECT * from " + tableName;
    private Connection conn;
    private PreparedStatement stmt;
    CatalogFlow catalog = new CatalogFlow();
    private ResultSet rs;

    public CatalogDA() {
        createConnection();
    }
    
   
//    public void addRecord(CatalogFlow cat) {
//        
//         String insertStr="INSERT INTO "+tableName+" VALUES(?,?,?)";
//         try{         
//         stmt=conn.prepareStatement(insertStr);
//                   stmt.setString(1, bb.getBbId());
//                    stmt.setString(2,bb.getBtype());
//                    stmt.setInt(3,bb.getQuantity());
//            
//                    
//                   stmt.executeUpdate();
//    }catch(SQLException ex){
//        JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
//    }
//    }
    
//     public CatalogFlow getRecord(String id) {
//        String queryStr = "SELECT * FROM " + tableName + " FLOWER_ID = ?";
//        CatalogFlow ctl = null;
//        ResultSet rs = null;
//        try {
//            stmt = conn.prepareStatement(queryStr);
//            stmt.setString(1, id);
//            
//            rs = stmt.executeQuery();
//            if(rs.next()){
//            ctl = new CatalogFlow(id, rs.getString("flower_name"), rs.getString("flower_description"),rs.getString("flower_price"));
//            }
//            
//    
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
//        }
//        return ctl;
//    }
       public Queue getCurrentRecord() {
        CatalogFlow catalog = null;
        Queue<CatalogFlow> queue = new LinkedList<>();
        try {
            stmt = conn.prepareStatement(sqlQueryStr);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            catalog = new CatalogFlow(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            queue.add(catalog);
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return queue;
    }
//    public void UpdateRecord(BloodBank bloodbank) {
//        
//         String updateStr="UPDATE "+tableName+ " SET BLOOD_TYPE =? ,BLOOD_QUANTITY = ? WHERE BLOOD_BANK_ID = ? ";
//         try{         
//         stmt=conn.prepareStatement(updateStr);
//
//                    stmt.setString(3,bloodbank.getBbId());
//                    stmt.setString(1,bloodbank.getBtype());
//                    stmt.setInt(2,bloodbank.getQuantity());                 
//                    stmt.executeUpdate();
//                   
//    }catch(SQLException ex){
//        JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
//    }
//    }
    
    
    
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
        CatalogDA catalogDA = new CatalogDA();
      
    }
}


