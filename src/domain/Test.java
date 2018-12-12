/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author chbee
 */
public class Test {
    public static void main(String args[]){
        Buyer cust = new Customer();
        Buyer c_cust = new CorporateCustomer("d","s","a");
        cust.setId("haha");
        
        System.out.println(cust.getId());
        System.out.println(c_cust.toString());
         
        
}
}
