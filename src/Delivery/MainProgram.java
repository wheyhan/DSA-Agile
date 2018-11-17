/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Delivery;

import domain.Order;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    private static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    private static Date date = new Date();
    private static DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
    private static Date time = new Date();
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nEnter Customer Retriving Method : ");
            System.out.println("\n1. Delivery");
            System.out.println("2. Pick Up");
            System.out.print("Option: ");
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    newOrder.setMethod("DELIVERY");
                    queue = newOrder.showList();
                    if (queue.isEmpty() == true) {
                        System.out.println("\nNo customer order that needs to be delivered today!");
                    } else {
                        System.out.println(queue);
                    }
                    break;
                case 2:
                    newOrder.setMethod("PICKUP");
                    queue = newOrder.showList();
                    if (queue.isEmpty() == true) {
                        System.out.println("\nNo customer order that needs to be picked up today!");
                    } else {
                        System.out.println(queue);
                        System.out.print("Enter Order ID: ");

                        String orderID = scanner.nextLine();
                        newOrder.setOrderID(orderID);
                        Order order = newOrder.searchByOrderID();

                        int choose;

                        do {
                            System.out.println("Customer has picked up their orders?? ");
                            System.out.println("1. Yes");
                            System.out.println("2. No");
                            choose = Integer.parseInt(scanner.nextLine());
                            switch (choose) {
                                case 1:
                                    order.setOrderStatus("PICKEDUP");
                                    order.setPaymentStatus("PAID");
                                    order.setDateReceived(dateFormat.format(date));
                                    order.setTimeReceived(timeFormat.format(time));
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
                    break;
                default:
                    System.out.println("Invalid Input!");
                    break;
            }

        } while (option > 2);

       System.out.println("Good Day!");
    }
}
