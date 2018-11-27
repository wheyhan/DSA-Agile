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
public class Customer extends Buyer{

    private String Address;
    public Customer() {
        
    }
    public Customer(String id, String name, String ic) {
        super(id, name, ic);
        
    }
    
   
    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

   
    /*public static void main(String args[]){
        Customer cust = new Customer("aaa","bbb","ccc");
        System.out.println(cust.getName());
    }*/

    
    

    
    
    
    
}
