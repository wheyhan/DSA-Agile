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
    CatalogFlow catalogFlow = new CatalogFlow();
    private ResultSet rs;

    public CatalogDA() {
        createConnection();
    }
    
   
    public void addRecord(CatalogFlow catalogFlow) {
        
         String insertStr="INSERT INTO "+tableName+" VALUES(?,?,?,?,?)";
         try{         
         stmt=conn.prepareStatement(insertStr);
                   stmt.setString(1, catalogFlow.getFlower_id());
                    stmt.setString(2, catalogFlow.getFlower_name());
                    stmt.setString(3, catalogFlow.getFlower_description());
                    stmt.setString(4, catalogFlow.getFlower_price());
                    stmt.setString(5, catalogFlow.getFlower_status());
                   stmt.executeUpdate();
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
    }
    }
    
       public Queue getCurrentRecord() {
        CatalogFlow catalogFlow = null;
        Queue<CatalogFlow> queue = new LinkedList<>();
        try {
            stmt = conn.prepareStatement(sqlQueryStr);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            catalogFlow = new CatalogFlow(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
            queue.add(catalogFlow);
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return queue;
    }

       public void updateRecord(CatalogFlow catalogFlow) {
        
         String updateStr="UPDATE "+tableName+ " SET FLOWER_DESCRIPTION = ? ,FLOWER_PRICE =? ,FLOWER_STATUS = ? WHERE FLOWER_ID=?";
         try{         
         stmt=conn.prepareStatement(updateStr);
                    stmt.setString(1,catalogFlow.getFlower_description());
                    stmt.setString(2,catalogFlow.getFlower_price());
                    stmt.setString(3,catalogFlow.getFlower_status());
                    
                    stmt.executeUpdate();
                   
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
    }
    }
    
        public Queue getRecord(String id) {
        String queryStr = "SELECT * FROM " + tableName + " FLOWER_ID = ?";
        CatalogFlow catalogFlow = null;
        Queue<CatalogFlow> queue = new LinkedList<>();
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            
            rs = stmt.executeQuery();
            if(rs.next()){
            catalogFlow = new CatalogFlow(id, rs.getString("flower_name"), rs.getString("flower_description"),rs.getString("flower_price"),rs.getString("flower_status"));
            }
            
    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return queue;
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
        CatalogDA catalogDA = new CatalogDA();
      
    }
}


