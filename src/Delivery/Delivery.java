/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Delivery;

import da.DeliveriesDA;
import da.DeliveryManDA;
import da.OrderDA;
import domain.Order;

/**
 *
 * @author user
 */
public class Delivery implements DeliveryInterface {

    private final OrderDA order = new OrderDA();
    private final DeliveryManDA dMan = new DeliveryManDA();
    private final DeliveriesDA delivery = new DeliveriesDA();
    private String method;

    @Override
    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public LinkedList showList() {

        LinkedList list = order.getAllOrder(method);

        return list;
    }

    @Override
    public boolean updateOrderStatus(Order or) {
        return order.updateOrderStatus(or);
    }

    @Override
    public LinkedList showDeliveryMan() {

        LinkedList list = dMan.getAllDeliveryMan();
        return list;

    }

    @Override
    public boolean insertDeliveries(LinkedList list) {
        boolean check = false;
        
        check = delivery.AddDeliveries(list);
        
        return check;
    }
    
}
