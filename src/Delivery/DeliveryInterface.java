/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Delivery;

import domain.Order;
import java.util.Queue;



/**
 *
 * @author user
 */
public interface DeliveryInterface {
    
    //getter setter
    String getOrderStatus();
    void setOrderStatus(String state);
    String getOrderID();
    void setOrderID(String orderID);
    
    //Operations
    Queue showList();
    Order searchByOrderID();
    void updateOrderStatus(Order or);
    
}
