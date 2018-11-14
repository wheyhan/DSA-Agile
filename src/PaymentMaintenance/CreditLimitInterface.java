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
public interface CreditLimitInterface {
    //get & set 
    void setCreditLimit(double limit);
    double getCreditLimit();
    
    //update the credit limit by using this add and substract
    CreditLimitInterface add(CreditLimitInterface CurrentCreditLimit);
    CreditLimitInterface substract(CreditLimitInterface CurrentCreditLimit);
    
}
