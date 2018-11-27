/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;

/**
 *
 * @author Chun Haur Lim
 */
public class CustPayDomain {
    private String Payment_id;
    private String Order_id;
    private Double Total_Payment; 
    private Date Payment_dt;
    

    public CustPayDomain(String Payment_id, String Order_id, Double Total_Payment, Date Payment_dt) {
        this.Payment_id = Payment_id;
        this.Order_id = Order_id;
        this.Total_Payment = Total_Payment;
        this.Payment_dt = Payment_dt;
        
    }

    public CustPayDomain() {
    
    }

    public CustPayDomain(String Payment_id, String Order_id, Double Total_Payment) {
        this.Payment_id = Payment_id;
        this.Order_id = Order_id;
        this.Total_Payment = Total_Payment;
    }

    public CustPayDomain(String Payment_id) {
        this.Payment_id = Payment_id;
    }

    public String getPayment_id() {
        return Payment_id;
    }

    public void setPayment_id(String Payment_id) {
        this.Payment_id = Payment_id;
    }

    public String getOrder_id() {
        return Order_id;
    }

    public void setOrder_id(String Order_id) {
        this.Order_id = Order_id;
    }
    
    public Double getTotal_Payment() {
        return Total_Payment;
    }

    public void setTotal_Payment(Double Total_Payment) {
        this.Total_Payment = Total_Payment;
    }

    public Date getPayment_dt() {
        return Payment_dt;
    }

    public void setPayment_dt(Date Payment_dt) {
        this.Payment_dt = Payment_dt;
    }

    @Override
    public String toString() {
        return "CustPayDomain{" + "Payment_id=" + Payment_id + ", Order_id=" + Order_id + ", Total_Payment=" + Total_Payment + '}';
    }

   

    
   
    
    
}
