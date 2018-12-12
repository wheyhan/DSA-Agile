/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Objects;

/**
 *
 * @author USER
 */
public class FlowerOrder {
    private String orderID;
    private String flowerID;
    private int quantity;
    
    public FlowerOrder next;

    public FlowerOrder(String orderID, String flowerID, int quantity) {
        this.orderID = orderID;
        this.flowerID = flowerID;
        this.quantity = quantity;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getFlowerID() {
        return flowerID;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setFlowerID(String flowerID) {
        this.flowerID = flowerID;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.orderID);
        hash = 67 * hash + Objects.hashCode(this.flowerID);
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
        final FlowerOrder other = (FlowerOrder) obj;
        if (!Objects.equals(this.orderID, other.orderID)) {
            return false;
        }
        if (!Objects.equals(this.flowerID, other.flowerID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FlowerOrder{" + "orderID=" + orderID + ", flowerID=" + flowerID + '}';
    }
    
    
}
