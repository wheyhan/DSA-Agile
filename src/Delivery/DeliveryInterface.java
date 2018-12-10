/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Delivery;

import domain.Order;

/**
 *
 * @author user
 */
public interface DeliveryInterface {
    
    //getter setter
    void setMethod(String method);
    String getMethod();
    
    //Operations
    LinkedList showList();
    
    LinkedList showDeliveryMan();
    boolean updateOrderStatus(Order order);
    boolean insertDeliveries(LinkedList list);

}
