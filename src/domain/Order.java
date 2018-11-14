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
public class Order {
    private String orderID;
    private String orderDescript;
    private String paymentStatus;
    private String orderStatus;
    private String dateReceived;

    public Order(){
        
    }

    public Order(String orderID, String orderDescript, String paymentStatus, String orderStatus, String dateReceived) {
        this.orderID = orderID;
        this.orderDescript = orderDescript;
        this.paymentStatus = paymentStatus;
        this.orderStatus = orderStatus;
        this.dateReceived = dateReceived;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getOrderDescript() {
        return orderDescript;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public String getDateReceived() {
        return dateReceived;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setOrderDescript(String orderDescript) {
        this.orderDescript = orderDescript;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setDateReceived(String dateReceived) {
        this.dateReceived = dateReceived;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.orderID);
        hash = 31 * hash + Objects.hashCode(this.orderDescript);
        hash = 31 * hash + Objects.hashCode(this.paymentStatus);
        hash = 31 * hash + Objects.hashCode(this.orderStatus);
        hash = 31 * hash + Objects.hashCode(this.dateReceived);
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
        final Order other = (Order) obj;
        if (this.orderID != other.orderID) {
            return false;
        }
        if (!Objects.equals(this.orderDescript, other.orderDescript)) {
            return false;
        }
        if (!Objects.equals(this.paymentStatus, other.paymentStatus)) {
            return false;
        }
        if (!Objects.equals(this.orderStatus, other.orderStatus)) {
            return false;
        }
        if (!Objects.equals(this.dateReceived, other.dateReceived)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", orderDescript=" + orderDescript + ", paymentStatus=" + paymentStatus + ", orderStatus=" + orderStatus + ", dateReceived=" + dateReceived + '}';
    }
   
}
