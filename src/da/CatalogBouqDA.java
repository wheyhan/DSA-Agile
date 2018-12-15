package da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import domain.CatalogBouq;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author JianHao
 */
public class CatalogBouqDA {
    
    private String host = "jdbc:derby://localhost:1527/CatalogDB";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "BOUQUETS";
    private String sqlQueryStr = "SELECT * from " + tableName;
    private Connection conn;
    private PreparedStatement stmt;
    CatalogBouq catalogBouq = new CatalogBouq();
    private ResultSet rs;

    public CatalogBouqDA() {
        createConnection();
    }
    
      public void addRecord(CatalogBouq catalogBouq) {
        
         String insertStr="INSERT INTO "+tableName+" VALUES(?,?,?,?,?,?)";
         try{         
         stmt=conn.prepareStatement(insertStr);
                   stmt.setString(1, catalogBouq.getBouquets_id());
                    stmt.setString(2, catalogBouq.getBouquets_name());
                    stmt.setString(3, catalogBouq.getBouquets_description());
                    stmt.setString(4, catalogBouq.getBouquets_price());
                    stmt.setString(5, catalogBouq.getBouquets_quantity());
                    stmt.setString(6, catalogBouq.getBouquets_status());
                   stmt.executeUpdate();
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
    }
    }
    
       public Queue getCurrentRecord() {
        CatalogBouq catalogBouq = null;
        Queue<CatalogBouq> queue = new LinkedList<>();
        try {
            stmt = conn.prepareStatement(sqlQueryStr);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            catalogBouq = new CatalogBouq(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6));
            queue.add(catalogBouq);
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return queue;
    }

         public void updateBouquet(CatalogBouq catalogBouq) {
        
         String updateStr="UPDATE "+tableName+ " SET BOUQUETS_DESCRIPTION = ? ,BOUQUETS_PRICE =? ,BOUQUETS_QUANTITY = ? ,BOUQUETS_STATUS = ? WHERE BOUQUETS_ID=?";
         try{         
         stmt=conn.prepareStatement(updateStr);
                    stmt.setString(1,catalogBouq.getBouquets_description());
                    stmt.setString(2,catalogBouq.getBouquets_price());
                    stmt.setString(3,catalogBouq.getBouquets_quantity());
                    stmt.setString(4,catalogBouq.getBouquets_status());
                    stmt.setString(5,catalogBouq.getBouquets_id());
                    stmt.executeUpdate();
                   
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
    }
    }
         
         public CatalogBouq getBouq(String bouquets_id) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE BOUQUETS_ID = ?";
        CatalogBouq catalogBouq = null;

        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, bouquets_id);
            
            rs = stmt.executeQuery();
            if(rs.next()){
            catalogBouq = new CatalogBouq(bouquets_id, rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }    
        return catalogBouq;
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
        CatalogBouqDA catalogBouqDA = new CatalogBouqDA();
      
    }
}