/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import domain.Order;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;
import java.util.Date;

/**
 *
 * @author user
 */
public class OrderDA {

    private String host = "jdbc:derby://localhost:1527/flowershopdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "NBUSER.\"ORDER\"";
    private Connection conn;
    private PreparedStatement stmt;

    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Date date = new Date();

    public OrderDA() {
        createConnection();
    }

    public Queue getAllOrder() {
        String queryStr = "SELECT * FROM " + tableName;
        Order order = null;
        Queue<Order> q = new LinkedList<>();
        try {
            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                order = new Order(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5));
                if (rs.getString(3).equals("PAID") && rs.getString(5).equals(dateFormat.format(date))) {
                    q.add(order);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return q;
    }
    
    public Order searchByOrderID(String id) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE OrderID = ?";
        Order order = null;

        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                order = new Order(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
                rs.getString(5));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return order;
    }
    
    public void updateOrderStatus(Order order) {
        String queryStr = "UPDATE " + tableName + " SET OrderDescript = ?, PaymentStatus = ?, "
                + "OrderStatus = ?, DateReceived = ? WHERE OrderID = ?";

        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, order.getOrderDescript());
            stmt.setString(2, order.getPaymentStatus());
            stmt.setString(3, order.getOrderStatus());
            stmt.setString(4, order.getDateReceived());
            stmt.setString(5, order.getOrderID());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
