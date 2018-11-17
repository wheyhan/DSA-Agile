/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogorder;

import java.util.Scanner;
import domain.CatalogOrderDomain;

/**
 *
 * @author USER
 */
public class OrderMainPrograme {
    public static void main(String[] args) {

        OrderInterface catalog = new CatalogOrder();
        Scanner scan = new Scanner(System.in);

        System.out.println("Catalog Order");
        System.out.println("Enter Customer OrderID :");
        String OrderID = scan.nextLine();
        System.out.println("Enter Customer Name :");
        String CustName = scan.nextLine();
        System.out.println("Enter Customer E-mail :");
        String CustEmail = scan.nextLine();
        System.out.println("Enter Customer Contact Number :");
        String CustContact = scan.nextLine();
        System.out.println("Enter Delivery Address:");
        String DeliverAddress = scan.nextLine();
        System.out.println("Enter Quantity :");
        int Quantity = Integer.parseInt(scan.nextLine());
        System.out.println("Enter Pick Up Date :");
        String PickUpDate = scan.nextLine();
        System.out.println("Enter Pick Up Time:");
        String PickUpTime = scan.nextLine();
        System.out.println("Enter Payment Method :");
        String PaymentMethod = scan.nextLine();
        System.out.println("Enter Pick-Up Method :");
        String PickUpMethod = scan.nextLine();
        
        catalog.setOrder(new CatalogOrderDomain(OrderID, CustName, CustEmail, CustContact, DeliverAddress, Quantity, PickUpDate, PickUpTime, PaymentMethod, PickUpMethod));

        boolean answer = catalog.insertOrder();
        
        if(answer == true){
            System.out.println("Success");
        }else{
            System.out.println("Failure");
        }
    }
}
