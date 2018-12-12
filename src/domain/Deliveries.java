/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Objects;

/**
 *
 * @author user
 */
public class Deliveries {
    
    private String deliveryID;
    private String orderID;
    private String estimateTime;

    public Deliveries next;
    
    public Deliveries(String deliveryID, String orderID, String estimateTime) {
        this.deliveryID = deliveryID;
        this.orderID = orderID;
        this.estimateTime = estimateTime;
    }

    public String getDeliveryID() {
        return deliveryID;
    }

    public String getOrderID() {
        return orderID;
    }
    
    public String getEstimateTime(){
        return estimateTime;
    }

    public void setDeliveryID(String deliveryID) {
        this.deliveryID = deliveryID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
    
    public void setEstimateTime(String estimateTime){
        this.estimateTime = estimateTime;
    }

    @Override
    public String toString() {
        return "Deliveries{" + "deliveryID=" + deliveryID + ", orderID=" + orderID + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.deliveryID);
        hash = 59 * hash + Objects.hashCode(this.orderID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Deliveries other = (Deliveries) obj;
        if (!Objects.equals(this.deliveryID, other.deliveryID)) {
            return false;
        }
        if (!Objects.equals(this.orderID, other.orderID)) {
            return false;
        }
        return true;
    }

    public void Display(){
        
        System.out.format("%-17s%-10s%-6s", 
                deliveryID, orderID, estimateTime);
    }
    
}
