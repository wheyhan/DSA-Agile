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
public class CatalogOrderDomain {

    private String OrderID;
    private String DeliverAdd;
    private String PaymentMethod;
    private String PaymentStatus;
    private String OrderStatus;
    private String EstimateDate;
    private String EstimateTime;
    private String DateReceived;
    private String TimeReceived;
    private String ReceivedMethod;
    private String ProdName;
    private int Quantity;

    public CatalogOrderDomain next;

    public CatalogOrderDomain(String DeliverAdd, String PaymentMethod, String PaymentStatus, String OrderStatus, String EstimateDate, String EstimateTime, String ReceivedMethod, int Quantity, String ProdName) {
        this.DeliverAdd = DeliverAdd;
        this.PaymentMethod = PaymentMethod;
        this.PaymentStatus = PaymentStatus;
        this.OrderStatus = OrderStatus;
        this.EstimateDate = EstimateDate;
        this.EstimateTime = EstimateTime;
        this.ReceivedMethod = ReceivedMethod;
        this.Quantity = Quantity;
        this.ProdName = ProdName;
    }

    public String getOrderID() {
        return OrderID;
    }

    public String getDeliverAdd() {
        return DeliverAdd;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public String getPaymentStatus() {
        return PaymentStatus;
    }

    public String getOrderStatus() {
        return OrderStatus;
    }

    public String getEstimateDate() {
        return EstimateDate;
    }

    public String getEstimateTime() {
        return EstimateTime;
    }

    public String getDateReceived() {
        return DateReceived;
    }

    public String getTimeReceived() {
        return TimeReceived;
    }

    public String getReceivedMethod() {
        return ReceivedMethod;
    }

    public String getProdName() {
        return ProdName;
    }

    public int getQuantity() {
        return Quantity;
    }

    public CatalogOrderDomain getNext() {
        return next;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }

    public void setDeliverAdd(String DeliverAdd) {
        this.DeliverAdd = DeliverAdd;
    }

    public void setPaymentMethod(String PaymentMethod) {
        this.PaymentMethod = PaymentMethod;
    }

    public void setPaymentStatus(String PaymentStatus) {
        this.PaymentStatus = PaymentStatus;
    }

    public void setOrderStatus(String OrderStatus) {
        this.OrderStatus = OrderStatus;
    }

    public void setEstimateDate(String EstimateDate) {
        this.EstimateDate = EstimateDate;
    }

    public void setEstimateTime(String EstimateTime) {
        this.EstimateTime = EstimateTime;
    }

    public void setDateReceived(String DateReceived) {
        this.DateReceived = DateReceived;
    }

    public void setTimeReceived(String TimeReceived) {
        this.TimeReceived = TimeReceived;
    }

    public void setReceivedMethod(String ReceivedMethod) {
        this.ReceivedMethod = ReceivedMethod;
    }

    public void setProdName(String ProdName) {
        this.ProdName = ProdName;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public void setNext(CatalogOrderDomain next) {
        this.next = next;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.OrderID);
        hash = 59 * hash + Objects.hashCode(this.DeliverAdd);
        hash = 59 * hash + Objects.hashCode(this.PaymentMethod);
        hash = 59 * hash + Objects.hashCode(this.PaymentStatus);
        hash = 59 * hash + Objects.hashCode(this.OrderStatus);
        hash = 59 * hash + Objects.hashCode(this.EstimateDate);
        hash = 59 * hash + Objects.hashCode(this.EstimateTime);
        hash = 59 * hash + Objects.hashCode(this.DateReceived);
        hash = 59 * hash + Objects.hashCode(this.TimeReceived);
        hash = 59 * hash + Objects.hashCode(this.ReceivedMethod);
        hash = 59 * hash + Objects.hashCode(this.ProdName);
        hash = 59 * hash + this.Quantity;
        hash = 59 * hash + Objects.hashCode(this.next);
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
        final CatalogOrderDomain other = (CatalogOrderDomain) obj;
        if (this.Quantity != other.Quantity) {
            return false;
        }
        if (!Objects.equals(this.OrderID, other.OrderID)) {
            return false;
        }
        if (!Objects.equals(this.DeliverAdd, other.DeliverAdd)) {
            return false;
        }
        if (!Objects.equals(this.PaymentMethod, other.PaymentMethod)) {
            return false;
        }
        if (!Objects.equals(this.PaymentStatus, other.PaymentStatus)) {
            return false;
        }
        if (!Objects.equals(this.OrderStatus, other.OrderStatus)) {
            return false;
        }
        if (!Objects.equals(this.EstimateDate, other.EstimateDate)) {
            return false;
        }
        if (!Objects.equals(this.EstimateTime, other.EstimateTime)) {
            return false;
        }
        if (!Objects.equals(this.DateReceived, other.DateReceived)) {
            return false;
        }
        if (!Objects.equals(this.TimeReceived, other.TimeReceived)) {
            return false;
        }
        if (!Objects.equals(this.ReceivedMethod, other.ReceivedMethod)) {
            return false;
        }
        if (!Objects.equals(this.ProdName, other.ProdName)) {
            return false;
        }
        if (!Objects.equals(this.next, other.next)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CatalogOrderDomain{" + "OrderID=" + OrderID + ", DeliverAdd=" + DeliverAdd + ", PaymentMethod=" + PaymentMethod + 
                ", PaymentStatus=" + PaymentStatus + ", OrderStatus=" + OrderStatus + ", EstimateDate=" + EstimateDate + 
                ", EstimateTime=" + EstimateTime + ", DateReceived=" + DateReceived + ", TimeReceived=" + TimeReceived + 
                ", ReceivedMethod=" + ReceivedMethod + ", ProdID=" + ProdName + ", Quantity=" + Quantity + ", next=" + next + '}';
    }

    public void Display() {
        System.out.format("%-27s%-52s%-16s%-16s%-14s%-15s%-15s%-17s%-3d",
                ProdName, DeliverAdd, PaymentMethod, PaymentStatus, OrderStatus, EstimateDate, EstimateTime, ReceivedMethod, Quantity);
    }

    public CatalogOrderDomain() {
        OrderID = "O1001";
        DeliverAdd = "asdf";
        EstimateDate = "12-12-2018";
        EstimateTime = "01:30";
        PaymentMethod = "1";
        ReceivedMethod = "1";
        PaymentStatus = "PAID";
    }

}
