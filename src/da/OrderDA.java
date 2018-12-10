/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import Delivery.LinkedList;
import domain.Order;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class OrderDA {

    private String host = "jdbc:derby://localhost:1527/flowershopdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "NBUSER.\"ORDERS\"";
    private Connection conn;
    private PreparedStatement stmt;
    private static DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
    private static Date time = new Date();
    LocalDate date = LocalDate.now();
    LocalDate tomorrow = date.plusDays(1);
    //DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String formattedString = date.format(formatter);
    String tmrFormattedString = tomorrow.format(formatter);

    public OrderDA() {
        createConnection();
    }

    public LinkedList getAllOrder(String method) {
        String queryStr = "";
        LinkedList link = new LinkedList();
        if (method.equals("DELIVERY")) {
            queryStr = "SELECT C.custID, C.address, C.custName, O.orderID, O.orderDescript, O.PaymentStatus, O.PaymentMethod, "
                    + "O.OrderStatus, O.EstimateDate, O.MethodRetrieve, O.EstimateTime FROM Customer C, Orders O WHERE O.custID = C.custID";

            try {
                stmt = conn.prepareStatement(queryStr);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    if ((rs.getString(6).equals("PAID") || rs.getString(7).equals("CASH"))
                            && rs.getString(9).equals(tmrFormattedString)
                            && rs.getString(8).equals("ONHOLD") && rs.getString(10).equals(method)) {
                        link.insertDeliveryFirstLink(rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(8),
                                rs.getString(9), rs.getString(11), rs.getString(7), rs.getString(2), rs.getString(3), rs.getString(1));
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } else if (method.equals("PICKUP")) {
            queryStr = "SELECT * FROM " + tableName;
            try {
                stmt = conn.prepareStatement(queryStr);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    if ((rs.getString(4).equals("PAID") || rs.getString(3).equals("CASH"))
                            && rs.getString(6).equals(formattedString)
                            && rs.getString(5).equals("ONHOLD") && rs.getString(10).equals(method)) {
                        link.insertPickUpFirstLink(rs.getString(1), rs.getString(2), rs.getString(4), rs.getString(5),
                                rs.getString(6), rs.getString(10));
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        return link;
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
                        rs.getString(5), rs.getString(10));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return order;
    }

    public boolean updateOrderStatus(Order order) {

        boolean update = false;
        String queryStr = "UPDATE " + tableName + " SET PaymentStatus = ?, "
                + "OrderStatus = ?, DateReceived = ?, TimeReceived = ? "
                + "WHERE OrderID = ?";

        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, order.getPaymentStatus());
            stmt.setString(2, order.getOrderStatus());
            stmt.setString(3, order.getDateReceived());
            stmt.setString(4, order.getTimeReceived());
            stmt.setString(5, order.getOrderID());
            stmt.executeUpdate();
            update = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return update;
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
