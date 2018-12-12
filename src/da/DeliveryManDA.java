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
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class DeliveryManDA {

    private String host = "jdbc:derby://localhost:1527/flowershopdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "NBUSER.\"DELIVERYMAN\"";
    private Connection conn;
    private PreparedStatement stmt;

    public DeliveryManDA() {
        createConnection();
    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public LinkedList getAllDeliveryMan() {
        String queryStr = "SELECT * FROM " + tableName;
        LinkedList link = new LinkedList();
        try {
            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                link.insertDeliveryManFirstLink(rs.getString(1), rs.getString(2), rs.getString(3));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        return link;
    }
}
