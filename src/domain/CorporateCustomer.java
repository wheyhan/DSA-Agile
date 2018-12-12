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
   
    public CorporateCustomer() {
       
    }
    public CorporateCustomer(String id, String name, String ic) {
        super(id, name, ic);
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
    
    
    
    
    
}
