/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaymentMaintenance;

/**
 *
 * @author chbee
 */
public class ImplementCredit implements CreditLimitInterface {
    private double limit=6000;

    @Override
    public void setCreditLimit(double limit) {
        this.limit=limit;
    }

    @Override
    public double getCreditLimit() {
        return this.limit;
    }

    @Override
    public CreditLimitInterface add(CreditLimitInterface AnotherCreditLimit) {
        CreditLimitInterface output = new ImplementCredit();
        
        output.setCreditLimit(this.limit+1);
                
        return output;
    }

    @Override
    public CreditLimitInterface substract(CreditLimitInterface OtherCreditLimit) {
       CreditLimitInterface output = new ImplementCredit();
        
        output.setCreditLimit(this.limit-1);
                
        return output;
    }

    @Override
    public String toString() {
        
        return  String.valueOf(limit);
    }
    
}
