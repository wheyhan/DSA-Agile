package da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import domain.CatalogFloral;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author JianHao
 */
public class CatalogFloralDA {
    
    private String host = "jdbc:derby://localhost:1527/CatalogDB";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "FLORALARRANGEMENT";
    private String sqlQueryStr = "SELECT * from " + tableName;
    private Connection conn;
    private PreparedStatement stmt;
    CatalogFloral catalogFloral = new CatalogFloral();
    private ResultSet rs;

    public CatalogFloralDA() {
        createConnection();
    }
    
    public void addRecord(CatalogFloral catalogFloral) {
        
         String insertStr="INSERT INTO "+tableName+" VALUES(?,?,?)";
         try{         
         stmt=conn.prepareStatement(insertStr);
                   stmt.setString(1, catalogFloral.getFloral_id());
                    stmt.setString(2, catalogFloral.getFloral_name());
                    stmt.setString(3, catalogFloral.getFloral_description());
                  
                   stmt.executeUpdate();
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
    }
    }
    
       public Queue getCurrentRecord() {
        CatalogFloral catalogFloral = null;
        Queue<CatalogFloral> queue = new LinkedList<>();
        try {
            stmt = conn.prepareStatement(sqlQueryStr);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            catalogFloral = new CatalogFloral(rs.getString(1), rs.getString(2), rs.getString(3));
            queue.add(catalogFloral);
            }
        } catch (SQLException ex) {
            ex.getMessage();
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
        CatalogFloralDA catalogFloDA = new CatalogFloralDA();
      
    }
}
