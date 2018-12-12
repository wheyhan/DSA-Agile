/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;


public class CorOrderDomain {
    
    private String orderID;
    private String custID;
    private String ProductName;
    private int quantity;
    private String unit_price;
    private double ttl_amount;
    private String order_date;
    private String status;
    private String invoice_date;
    
    public CorOrderDomain(){
        
    }

    public CorOrderDomain(String orderID, String custID, String ProductName, int quantity, String unit_price, double ttl_amount, String order_date, String status, String invoice_date) {
        this.orderID = orderID;
        this.custID = custID;
        this.ProductName = ProductName;
        this.quantity = quantity;
        this.unit_price = unit_price;
        this.ttl_amount = ttl_amount;
        this.order_date = order_date;
        this.status = status;
        this.invoice_date = invoice_date;
    }

    
    

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(String unit_price) {
        this.unit_price = unit_price;
    }

    public double getTtl_amount() {
        return ttl_amount;
    }

    public void setTtl_amount(double ttl_amount) {
        this.ttl_amount = ttl_amount;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInvoice_date() {
        return invoice_date;
    }

    public void setInvoice_date(String invoice_date) {
        this.invoice_date = invoice_date;
    }

    
    @Override
    public String toString() {
        return orderID+"   "+ProductName+"\t\t\t "+quantity+" \t"+ttl_amount+"\n";
    }

    
    
    
}
