/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Delivery;

import da.OrderDA;
import domain.Order;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author user
 */
public class Delivery implements DeliveryInterface {

    private final OrderDA order = new OrderDA();
    
    private String orderID;
    private String state;

    @Override
    public String getOrderStatus() {
        return state;
    }

    @Override
    public void setOrderStatus(String state) {
        this.state = state;
    }

    @Override
    public String getOrderID() {
        return orderID;
    }

    @Override
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
    
    @Override
    public Queue showList() {
        //for (int i = 0; i < 10; i++) {
            Queue q = order.getAllOrder();
        //}
        return q;
    }

    @Override
    public Order searchByOrderID() {
        Order or = order.searchByOrderID(orderID);
        
        return or;
    }
    
    @Override
    public void updateOrderStatus(Order or) {
        order.updateOrderStatus(or);
    }

    

}
