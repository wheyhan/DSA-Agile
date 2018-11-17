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

    @Override
    public String toString() {
        return "CatalogOrder{" + "OrderID=" + OrderID + ", CustName=" + CustName + ", CustEmail=" + CustEmail + ", CustContact=" + CustContact + ", DeliverAdd=" + DeliverAdd + ", Quantity=" + Quantity + ", PickUpDate=" + PickUpDate + ", PickUpTime=" + PickUpTime + ", PaymentMEthod=" + PaymentMethod + ", PickUpMethod=" + PickUpMethod + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.OrderID);
        hash = 89 * hash + Objects.hashCode(this.CustName);
        hash = 89 * hash + Objects.hashCode(this.CustEmail);
        hash = 89 * hash + Objects.hashCode(this.CustContact);
        hash = 89 * hash + Objects.hashCode(this.DeliverAdd);
        hash = 89 * hash + this.Quantity;
        hash = 89 * hash + Objects.hashCode(this.PickUpDate);
        hash = 89 * hash + Objects.hashCode(this.PickUpTime);
        hash = 89 * hash + Objects.hashCode(this.PaymentMethod);
        hash = 89 * hash + Objects.hashCode(this.PickUpMethod);
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
        if (!Objects.equals(this.CustName, other.CustName)) {
            return false;
        }
        if (!Objects.equals(this.CustEmail, other.CustEmail)) {
            return false;
        }
        if (!Objects.equals(this.CustContact, other.CustContact)) {
            return false;
        }
        if (!Objects.equals(this.DeliverAdd, other.DeliverAdd)) {
            return false;
        }
        if (!Objects.equals(this.PickUpDate, other.PickUpDate)) {
            return false;
        }
        if (!Objects.equals(this.PickUpTime, other.PickUpTime)) {
            return false;
        }
        if (!Objects.equals(this.PaymentMethod, other.PaymentMethod)) {
            return false;
        }
        if (!Objects.equals(this.PickUpMethod, other.PickUpMethod)) {
            return false;
        }
        return true;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }

    public String getCustName() {
        return CustName;
    }

    public void setCustName(String CustName) {
        this.CustName = CustName;
    }

    public String getCustEmail() {
        return CustEmail;
    }

    public void setCustEmail(String CustEmail) {
        this.CustEmail = CustEmail;
    }

    public String getCustContact() {
        return CustContact;
    }

    public void setCustContact(String CustContact) {
        this.CustContact = CustContact;
    }

    public String getDeliverAdd() {
        return DeliverAdd;
    }

    public void setDeliverAdd(String DeliverAdd) {
        this.DeliverAdd = DeliverAdd;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getPickUpDate() {
        return PickUpDate;
    }

    public void setPickUpDate(String PickUpDate) {
        this.PickUpDate = PickUpDate;
    }

    public String getPickUpTime() {
        return PickUpTime;
    }

    public void setPickUpTime(String PickUpTime) {
        this.PickUpTime = PickUpTime;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String PaymentMethod) {
        this.PaymentMethod = PaymentMethod;
    }

    public String getPickUpMethod() {
        return PickUpMethod;
    }

    public void setPickUpMethod(String PickUpMethod) {
        this.PickUpMethod = PickUpMethod;
    }

    public CatalogOrderDomain(String OrderID, String CustName, String CustEmail, String CustContact, String DeliverAdd, int Quantity, String PickUpDate, String PickUpTime, String PaymentMethod, String PickUpMethod) {
        this.OrderID = OrderID;
        this.CustName = CustName;
        this.CustEmail = CustEmail;
        this.CustContact = CustContact;
        this.DeliverAdd = DeliverAdd;
        this.Quantity = Quantity;
        this.PickUpDate = PickUpDate;
        this.PickUpTime = PickUpTime;
        this.PaymentMethod = PaymentMethod;
        this.PickUpMethod = PickUpMethod;
    }
 private String OrderID;
 private String CustName;
 private String CustEmail;
 private String CustContact;
 private String DeliverAdd;
 private int Quantity;
 private String PickUpDate;
 private String PickUpTime;
 private String PaymentMethod;
 private String PickUpMethod;
 
    public CatalogOrderDomain() {
    }


}
