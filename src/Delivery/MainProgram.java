/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Delivery;

import domain.Order;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class MainProgram {

    /**
     * @param args the command line arguments
     */
    private static Queue<Order> queue = new LinkedList<>();
    private static final DeliveryInterface newOrder = new Delivery();

    public static void main(String[] args) {

        queue = newOrder.showList();
        Scanner scanner = new Scanner(System.in);

        System.out.println(queue);

        System.out.println("Enter Order ID: ");

        String orderID = scanner.nextLine();
        newOrder.setOrderID(orderID);
        Order order = newOrder.searchByOrderID();

        int choose;
        
        do {
            System.out.println("Customer has picked up their orders?? ");
            System.out.println("1. Yes");
            System.out.println("2. No");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    order.setOrderStatus("PICKEDUP");
                    newOrder.updateOrderStatus(order);
                    break;
                case 2:
                    System.out.println("Have a nice day!");
                    break;
                default:
                    System.out.println("Invalid Input!");
                    break;
            }

        } while (choose > 2);

    }
}
