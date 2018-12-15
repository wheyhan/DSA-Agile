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
        
         String insertStr="INSERT INTO "+tableName+" VALUES(?,?,?,?,?,?)";
         try{         
         stmt=conn.prepareStatement(insertStr);
                    stmt.setString(1, promo.getPromotion_id());
                   stmt.setString(2, promo.getPromotion_month());
                    stmt.setString(3, promo.getProduct_type());
                    stmt.setString(4, promo.getProduct());
                    stmt.setString(5, promo.getDiscount());
                    stmt.setString(6, promo.getPromotion_status());
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
            promotion = new Promotion(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6));
            queue.add(promotion);
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return queue;
    }

    public void updatePromo(Promotion promo) {
        
         String updateStr="UPDATE "+tableName+ " SET PROMOTION_MONTH = ? ,PRODUCT_TYPE =? ,PRODUCT = ? ,DISCOUNT = ?, PROMOTION_STATUS = ? WHERE PROMOTION_ID = ?";
         try{         
         stmt=conn.prepareStatement(updateStr);
                   
                   stmt.setString(1, promo.getPromotion_month());
                    stmt.setString(2, promo.getProduct_type());
                    stmt.setString(3, promo.getProduct());
                    stmt.setString(4, promo.getDiscount());
                    stmt.setString(5, promo.getPromotion_status());
                    stmt.setString(6, promo.getPromotion_id());
                    stmt.executeUpdate();
                   
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
    }
    }
    
        public Promotion getPromo(String promotion_id) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE PROMOTION_ID = ?";
        Promotion promo = null;

        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, promotion_id);
            
            rs = stmt.executeQuery();
            if(rs.next()){
            promo = new Promotion(promotion_id, rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }    
        return promo;
    }
       
    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            //System.out.println("***TRACE: Connection established.");
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
