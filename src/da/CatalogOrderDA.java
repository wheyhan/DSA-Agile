/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import catalogorder.CatalogOrder;
import catalogorder.LinkedList;
import catalogorder.OrderInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import domain.CatalogOrderDomain;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class CatalogOrderDA {

    private String host = "jdbc:derby://localhost:1527/CatalogOrderdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "NBUSER.\"ORDERS\"";
    private Connection conn;
    private PreparedStatement stmt;
    private static LinkedList bouquetList = new LinkedList();
    private static LinkedList flowerList = new LinkedList();

    public boolean AddOrder(LinkedList order) {
        String insertStr = "INSERT INTO " + tableName + "(Address, PaymentMethod, PaymentStatus, OrderStatus, EstimateDate, EstimateTime, MethodRetrieve) VALUES(?, ?, ?, ?, ?, ?, ?)";

        boolean answer = false;
        ResultSet rs = null;
        order.currentNode = order.firstNode;
        try {
            while (order != null && !order.isEmptyCurrent()) {

                stmt = conn.prepareStatement(insertStr, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, order.currentNode.getDeliverAdd());
                stmt.setString(2, order.currentNode.getPaymentMethod());
                stmt.setString(3, order.currentNode.getPaymentStatus());
                stmt.setString(4, order.currentNode.getOrderStatus());
                stmt.setString(5, order.currentNode.getEstimateDate());
                stmt.setString(6, order.currentNode.getEstimateTime());
                stmt.setString(7, order.currentNode.getReceivedMethod());
                stmt.executeUpdate();

                rs = stmt.getGeneratedKeys();
                if (rs != null && rs.next()) {

                    String flowerProdID = RetrieveFlowerIdByName(order.currentNode.getProdName());
                    String bouquetProdID = RetrieveBouquetIdByName(order.currentNode.getProdName());

                    if (!flowerProdID.isEmpty()) {

                        flowerList.insertFlowerFirstNode(String.valueOf(rs.getInt(1)), flowerProdID, order.currentNode.getQuantity());

                    } else if (!bouquetProdID.isEmpty()) {
                        bouquetList.insertBouquetFirstNode(String.valueOf(rs.getInt(1)), bouquetProdID, order.currentNode.getQuantity());
                    }

                    //System.out.println("Generated Emp Id: " + rs.getInt(1));
                }

                order.currentNode = order.currentNode.next;
            }

            insertFlowerOrders(flowerList);
            insertBouquetsOrders(bouquetList);
            answer = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        return answer;
    }

    public boolean insertFlowerOrders(LinkedList order) {

        String insertStr = "INSERT INTO FLOWERORDERS(OrderID, FlowerID, Quantity) VALUES(?, ?, ?)";
        boolean answer = false;
        order.flowerCurrentNode = order.flowerFirstNode;
        try {
            while (order != null && !order.isFlowerEmptyCurrent()) {
                stmt = conn.prepareStatement(insertStr);
                stmt.setString(1, order.flowerCurrentNode.getOrderID());
                stmt.setString(2, order.flowerCurrentNode.getFlowerID());
                stmt.setInt(3, order.flowerCurrentNode.getQuantity());
                stmt.executeUpdate();

                order.flowerCurrentNode = order.flowerCurrentNode.next;
            }

            answer = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        return answer;
    }

    public boolean insertBouquetsOrders(LinkedList order) {

        String insertStr = "INSERT INTO BOUQUETSORDERS(OrderID, BouquetID, Quantity) VALUES(?, ?, ?)";
        boolean answer = false;
        order.bouquetCurrentNode = order.bouquetFirstNode;
        try {
            while (order != null && !order.isBouquetEmptyCurrent()) {
                stmt = conn.prepareStatement(insertStr);
                stmt.setString(1, order.bouquetCurrentNode.getOrderID());
                stmt.setString(2, order.bouquetCurrentNode.getBouquetID());
                stmt.setInt(3, order.bouquetCurrentNode.getQuantity());
                stmt.executeUpdate();

                order.bouquetCurrentNode = order.bouquetCurrentNode.next;
            }

            answer = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        return answer;
    }

    public String RetrieveFlowerIdByName(Object prodName) {
        String insertStr = "SELECT Flower_ID, Flower_Name FROM FLOWERS";
        String name = "";

        try {
            stmt = conn.prepareStatement(insertStr);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getString(2).equals(prodName)) {
                    name = rs.getString(1);
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        return name;
    }

    public String RetrieveBouquetIdByName(Object prodName) {
        String insertStr = "SELECT Bouquets_ID, Bouquets_Name FROM BOUQUETS";
        String name = "";

        try {
            stmt = conn.prepareStatement(insertStr);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getString(2).equals(prodName)) {
                    name = rs.getString(1);
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        return name;
    }

    public String RetrieveFlower(Object prodID) {
        String insertStr = "SELECT Flower_ID, Flower_Quantity, Flower_Name FROM FLOWERS";
        String name = "";

        try {
            stmt = conn.prepareStatement(insertStr);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getString(1).equals(prodID) && Integer.parseInt(rs.getString(2)) != 0) {
                    name = rs.getString(3);
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        return name;
    }

    public String RetrieveBouquet(Object prodID) {
        String insertStr = "SELECT Bouquets_ID, Bouquets_Quantity, Bouquets_Name FROM BOUQUETS";
        String name = "";

        try {
            stmt = conn.prepareStatement(insertStr);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getString(1).equals(prodID) && Integer.parseInt(rs.getString(2)) != 0) {
                    name = rs.getString(3);
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        return name;
    }

    public String RetrieveOrderIdDelivery(LinkedList order) {
        String insertStr = "SELECT OrderID, Address, PaymentMethod, PaymentStatus, OrderStatus, EstimateDate, EstimateTime, MethodRetrieve  FROM " + tableName;
        String name = "";

        order.currentNode = order.firstNode;
        try {
            stmt = conn.prepareStatement(insertStr);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getString(2).equals(order.currentNode.getDeliverAdd()) && rs.getString(3).equals(order.currentNode.getPaymentMethod())
                        && rs.getString(4).equals(order.currentNode.getPaymentStatus()) && rs.getString(5).equals(order.currentNode.getOrderStatus())
                        && rs.getString(6).equals(order.currentNode.getEstimateDate()) && rs.getString(7).equals(order.currentNode.getEstimateTime())
                        && rs.getString(8).equals(order.currentNode.getPaymentMethod())) {
                    name = rs.getString(1);
                }

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        return name;
    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            //System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public CatalogOrderDA() {
        createConnection();
    }

}
