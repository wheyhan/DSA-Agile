/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Interface.CreditLimitInterface;

/**
 *
 * @author Chun Haur Lim
 */
public class ImplementCredit implements CreditLimitInterface {
    private double limit=6000;

    @Override
    public void setCreditLimit(double limit) {
        this.limit=limit;
    }

    @Override
    public double getCreditLimit() {
        return limit;
    }

    @Override
    public CreditLimitInterface add() {
        CreditLimitInterface output = new ImplementCredit();
        
        output.setCreditLimit(limit+1);
                
        return output;
    }

    @Override
    public CreditLimitInterface substract() {
       CreditLimitInterface output = new ImplementCredit();
        
        output.setCreditLimit(limit-1);
                
        return output;
    }

    @Override
    public String toString() {
        
        return  String.valueOf(limit);
    }
    
}
