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
    private String estimateReceived;
    private String estimateTime;
    private String method;
    private String dateReceived;
    private String timeReceived;
    private String address;
    private String custName;
    private String custID;

    public Order next;

    public Order(){
        
    }
    public Order(String orderID, String orderDescript, String paymentStatus, 
            String orderStatus, String estimateReceived, String estimateTime, String method, String address,
            String custName, String custID) {
        this.orderID = orderID;
        this.orderDescript = orderDescript;
        this.paymentStatus = paymentStatus;
        this.orderStatus = orderStatus;
        this.estimateReceived = estimateReceived;
        this.estimateTime = estimateTime;
        this.method = method;
        this.address = address;
        this.custName = custName;
        this.custID = custID;
    }

    public Order(String orderID, String orderDescript, String paymentStatus, 
            String orderStatus, String estimateReceived, String method) {
        this.orderID = orderID;
        this.orderDescript = orderDescript;
        this.paymentStatus = paymentStatus;
        this.orderStatus = orderStatus;
        this.estimateReceived = estimateReceived;
        this.method = method;
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

    public String getEstimateReceived() {
        return estimateReceived;
    }

    public String getEstimateTime() {
        return estimateTime;
    }

    public String getMethod() {
        return method;
    }

    public String getDateReceived() {
        return dateReceived;
    }

    public String getTimeReceived() {
        return timeReceived;
    }

    public String getAddress() {
        return address;
    }

    public String getCustName() {
        return custName;
    }

    public String getCustID() {
        return custID;
    }

    public Order getNext() {
        return next;
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

    public void setEstimateReceived(String estimateReceived) {
        this.estimateReceived = estimateReceived;
    }

    public void setEstimateTime(String estimateTime) {
        this.estimateTime = estimateTime;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setDateReceived(String dateReceived) {
        this.dateReceived = dateReceived;
    }

    public void setTimeReceived(String timeReceived) {
        this.timeReceived = timeReceived;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public void setNext(Order next) {
        this.next = next;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.orderID);
        hash = 31 * hash + Objects.hashCode(this.orderDescript);
        hash = 31 * hash + Objects.hashCode(this.paymentStatus);
        hash = 31 * hash + Objects.hashCode(this.orderStatus);
        hash = 31 * hash + Objects.hashCode(this.estimateReceived);
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
        if (!Objects.equals(this.estimateReceived, other.estimateReceived)) {
            return false;
        }
        return true;
    }

    public void DeliveryDisplay(){
        
        System.out.format("%-10s%-25s%-16s%-16s%-14s%-15s%-15s%-52s%-14s", 
                orderID, orderDescript, paymentStatus, method, orderStatus, estimateReceived, estimateTime, address, custName);
    }
    
    public void Display(){
        
        System.out.format("%-10s%-25s%-16s%-16s%-14s%-14s", 
                orderID, orderDescript, paymentStatus, method, orderStatus, estimateReceived);
    }
    
    @Override
    public String toString() {
        
        return "OrderID : " + orderID + 
                "\nOrder Description : " + orderDescript + 
                "\nPayment Status : " + paymentStatus + 
                "\nPayment Method : " + method +
                "\nOrder Status : " + orderStatus + 
                "\nDelivery Date : " + estimateReceived + "\n\n";
    }
}
