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
import domain.Promotion;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author JianHao
 */
public class PromotionDA {
    
    private String host = "jdbc:derby://localhost:1527/CatalogDB";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "PROMOTION";
    private String sqlQueryStr = "SELECT * from " + tableName;
    private Connection conn;
    private PreparedStatement stmt;
    Promotion promo = new Promotion();
    private ResultSet rs;

    public PromotionDA() {
        createConnection();
    }
    
   
    public void addRecord(Promotion promo) {
        
         String insertStr="INSERT INTO "+tableName+" VALUES(?,?,?,?,?)";
         try{         
         stmt=conn.prepareStatement(insertStr);
                   stmt.setString(1, promo.getPromotion_month());
                    stmt.setString(2, promo.getProduct_type());
                    stmt.setString(3, promo.getProduct());
                    stmt.setString(4, promo.getDiscount());
                    stmt.setString(5, promo.getPromotion_status());
                   stmt.executeUpdate();
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
    }
    }
    
       public Queue getCurrentRecord() {
        Promotion promotion = null;
        Queue<Promotion> queue = new LinkedList<>();
        try {
            stmt = conn.prepareStatement(sqlQueryStr);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            promotion = new Promotion(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
            queue.add(promotion);
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return queue;
    }

    
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
        PromotionDA promotionDA = new PromotionDA();
      
    }
}
