/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author LIM CHUN HAUR
 */
public interface CustomerPayInterface {
    
    //Customer Pay amount & Total bill amount using same set & get 
    void setPayAmount(double amt);
    double getPayAmount();
    
    CustomerPayInterface substact(CustomerPayInterface PayAMT);
    
    
}
