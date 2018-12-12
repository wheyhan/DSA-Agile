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
public class BouquetOrder {
    private String orderID;
    private String bouquetID;
    private int quantity;
    
    public BouquetOrder next;

    public BouquetOrder(String orderID, String bouquetID, int quantity) {
        this.orderID = orderID;
        this.bouquetID = bouquetID;
        this.quantity = quantity;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getBouquetID() {
        return bouquetID;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setBouquetID(String bouquetID) {
        this.bouquetID = bouquetID;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.orderID);
        hash = 31 * hash + Objects.hashCode(this.bouquetID);
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
        final BouquetOrder other = (BouquetOrder) obj;
        if (!Objects.equals(this.orderID, other.orderID)) {
            return false;
        }
        if (!Objects.equals(this.bouquetID, other.bouquetID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BouquetOrder{" + "orderID=" + orderID + ", bouquetID=" + bouquetID + '}';
    }
    
    
}
