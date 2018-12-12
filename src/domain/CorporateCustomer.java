/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Chun Haur Lim
 */
public class CorporateCustomer extends Buyer{
    
    private String CompanyName;
    private String CompanyAddress;
    private double CreditLimit;
    
    public CorporateCustomer() {
       
    }
    
    public CorporateCustomer(String id, String name, String ic, String CompanyName, String CompanyAddress, double CreditLimit) {
        super(id, name, ic);
        this.CompanyName = CompanyName;
        this.CompanyAddress = CompanyAddress;
        this.CreditLimit = CreditLimit;
        
    }

    
    public CorporateCustomer(String id, String name, String ic,String pwd, String CompanyName, String CompanyAddress, double CreditLimit) {
        super(id, name, ic, pwd);
        this.CompanyName = CompanyName;
        this.CompanyAddress = CompanyAddress;
        this.CreditLimit = CreditLimit;
    }
   

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public String getCompanyAddress() {
        return CompanyAddress;
    }

    public void setCompanyAddress(String CompanyAddress) {
        this.CompanyAddress = CompanyAddress;
    }

    public double getCreditLimit() {
        return CreditLimit;
    }

    public void setCreditLimit(double CreditLimit) {
        this.CreditLimit = CreditLimit;
    }

    @Override
    public String toString() {
        return super.toString()+"\nCompanyName: "+CompanyName+"\nAddress: "+CompanyAddress+"\nCreditLimit: "+CreditLimit;
    }

    
    
    
    
    
    
}
