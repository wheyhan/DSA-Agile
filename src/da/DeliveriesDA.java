/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import Delivery.LinkedList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class DeliveriesDA {

    private String host = "jdbc:derby://localhost:1527/flowershopdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "NBUSER.\"DELIVERIES\"";
    private Connection conn;
    private PreparedStatement stmt;

    public DeliveriesDA() {
        createConnection();
    }

    public boolean AddDeliveries(LinkedList order) {
        String insertStr = "INSERT INTO " + tableName + "(DMANID, ORDERID) VALUES(?, ?)";
        boolean check = false;
        try {
            //order.deliveriesCurrentLink = order.deliveriesFirstLink;
            while (order != null && !order.isEmptyThree()) {
                stmt = conn.prepareStatement(insertStr);
                stmt.setString(1, order.deliveriesFirstLink.getDeliveryID());
                stmt.setString(2, order.deliveriesFirstLink.getOrderID());
                order.deliveriesFirstLink = order.deliveriesFirstLink.next;
                stmt.executeUpdate();
            }

            
            check = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return check;
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
