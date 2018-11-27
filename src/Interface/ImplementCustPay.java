/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import domain.CatalogFlow;
import domain.CatalogOrderDomain;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LIM CHUN HAUR
 */
public class ImplementCustPay implements CustomerPayInterface{
    
     private double amt;
    
   //Customer entered pay amount
    @Override
    public void setPayAmount(double amt) {
        this.amt=amt;
    }

    @Override
    public double getPayAmount() {
        return amt;
    }

    
    
   //Give change to customer (Customer's pay amount - Total bill amount)
    public CustomerPayInterface substact(CustomerPayInterface Bill) {
        
       CustomerPayInterface Givechange = new ImplementCustPay();
        
        Givechange.setPayAmount(this.amt-Bill.getPayAmount());
        
       return Givechange;
    }
    
   
    

    @Override
    public String toString() {
        return String.format("%.2f", amt);
    }

    

    

    

   

    
    
}
