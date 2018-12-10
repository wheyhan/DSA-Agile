/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Delivery;

import domain.Order;
import java.io.ByteArrayInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class MainProgram {

    /**
     * @param args the command line arguments
     */
    private static final DeliveryInterface DI = new Delivery();
    private static LinkedList list = new LinkedList();
    private static LinkedList dManList = new LinkedList();
    private static LinkedList assignLink = new LinkedList();
    private static Order order = new Order();

    private static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static Date date = new Date();
    private static DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
    private static Date time = new Date();

    private static Scanner scanner = new Scanner(System.in);
    private static final int count = 0;

    public static void main(String[] args) {

        int option;

        do {
            System.out.println("\nEnter Customer Retriving Method : ");
            System.out.println("\n1. Delivery");
            System.out.println("2. Pick Up");
            System.out.print("\nOption: ");

            //option = Integer.parseInt(scanner.nextLine());
            option = 1;
            ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
            System.setIn(in);
            switch (option) {
                case 1:
                    showDelivery();
                    deliveryMethod();
                    break;

                case 2:
                    showPickUp();

                    break;

                default:
                    System.out.println("\nInvalid Input!");
                    break;
            }

        } while (option > 2);

        System.out.println("\nGood Day!");
    }

    public static void showPickUp() {

        DI.setMethod("PICKUP");
        System.out.print("\n");

        list = DI.showList();

        if (list.isEmpty() == true) {
            System.out.println("\nNo customer order that needs to be picked up today!");

        } else {
            list.display();
            pickUpMethod();
        }
    }

    public static void pickUpMethod() {
        System.out.print("\nEnter Order ID: ");

        String orderID = scanner.nextLine();

        if (list.findOrderID(orderID)) {

            order.setOrderID(orderID);

            int choose;

            do {
                System.out.println("\nCustomer has picked up their orders?? ");
                System.out.println("1. Yes");
                System.out.println("2. No");
                System.out.print("Action: ");

                choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        updatePickup();
                        System.out.println("\nSuccessfully Updated!");
                        break;
                    case 2:
                        System.out.println("\nHave a nice day!");
                        break;
                    default:
                        System.out.println("\nInvalid Input!");
                        break;
                }

            } while (choose > 2);
        } else {
            System.out.print("\nThat record is not picked up today!\n");
        }
    }

    public static boolean updatePickup() {
        order.setOrderStatus("PICKEDUP");
        order.setPaymentStatus("PAID");
        order.setDateReceived(dateFormat.format(date));
        order.setTimeReceived(timeFormat.format(time));
        return DI.updateOrderStatus(order);

    }

    public static boolean showDelivery() {
        boolean num = false;
        DI.setMethod("DELIVERY");
        System.out.print("\nThis is tomorrow's orders\n");

        list = DI.showList();
        dManList = DI.showDeliveryMan();

        if (list.isEmpty() == true) {
            System.out.println("\nNo customer order that needs to be delivered today!");
        } else {
            list.deliveryDisplay();
            System.out.print("\n");
            num = true;
        }

        if (dManList.isEmptyTwo() == true) {
            System.out.println("\nNo Delivery Man available!");
        } else {
            dManList.deliveryManDisplay();
            System.out.print("\n");
            num = true;
        }
        return num;
    }

    public static boolean deliveryMethod() {
        boolean check = false;
        System.out.print("\nStart Assigning Orders to Delivery Man?");
        System.out.print("\n[Y/y = Yes] | [N/n = No]\n");
        System.out.print("\nDecision: ");
        //String assign = scanner.nextLine();
        String assign = "Y";
        if (assign.equals("Y") || assign.equals("y")) {
            //Function 1 automatically assign delivery man
            assignDeliveryMan();

            System.out.print("\nIs this assignment good?");
            System.out.print("\n[Y/y = Yes] | [N/n = No] | [Any Characters to exit]\n");
            System.out.print("\nSatisfy?: ");
            //String satisfy = scanner.nextLine();
            String satisfy = "Y";
            if (satisfy.equals("Y") || satisfy.equals("y")) {
                //check = DI.insertDeliveries(assignLink);
            } else if (satisfy.equals("N") || satisfy.equals("n")) {
                assignLink = null;
                showDelivery();
                deliveryMethod();
            } else {
                System.out.print("\nSystem will now exit.");
            }
        } else if (assign.equals("N") || assign.equals("n")) {
            System.out.print("\nSystem will now exit.");
        } else {
            System.out.print("\nInvalid Input.\n");
        }
//        if (list.findOrderID(deliveryOrderID)) {
//
//            Order order = new Order();
//            order.setOrderID(deliveryOrderID);
//
//        }
        return check;
    }

    public static void assignDeliveryMan() {
        //assign first 3 order to deliveryMan in LinkList
        //new LinkedList

        list.currentLink = list.firstLink;
        list.previousLink = list.firstLink;
        dManList.dManCurrentLink = dManList.dManFirstLink;
        while ((dManList.dManCurrentLink != null && !dManList.isEmptyThree()) || (list.currentLink != null && !list.isEmpty())) {
            //if (dManList.isEmptyTwo() || list.isEmpty()) {
            //System.out.print("No orders or delivery man assignable");
            //} else {
            //conditions
            //gap between orders are 2 hours
            //morning to night priority
            //delivery man have 3 orders in same address (Setapak/Genting Klang)
            //3 orders per deliveryman - done

//            try {
//                for (int i = 0; i < list.size(); i++) {
//                    if (timeFormat.parse(timeFormat.format(list.firstLink.getEstimateReceived())).after(timeFormat.parse(timeFormat.format(list.firstLink.next.getEstimateReceived())))) {
//
//                    } else {
//                        
//                    }
//                }
//            } catch (Exception ex) {
//                System.out.println("Error messsage: " + ex);
//            }
//            if (assignLink.sizeTwo(assignLink.deliveriesFirstLink) == 2) {
//                //do checking between two time
//                if (checkTime(list.currentLink.getEstimateTime()) == 1) {
//                    assignLink.insertAssignLinkAtPosition(dManList.dManCurrentLink.getdManID(), list.currentLink.getOrderID(), list.currentLink.getEstimateTime(), 1);
//                    list.currentLink = list.currentLink.next;
//                } else if (checkTime(list.firstLink.getEstimateTime()) == 2) {
//                    int s = assignLink.sizeTwo(assignLink.deliveriesFirstLink);
//                    s = s / 2;
//                    if(s % 2 != 0){
//                        
//                    }
//                }else{
//                    
//                }
//            } else {
//                //just keep adding until 2 records exist
            String sb = "Setapak";
            if (assignLink.sizeTwo(assignLink.deliveriesFirstLink) >= 1) {
                if ((list.previousLink.getAddress().toLowerCase().contains(sb.toLowerCase())) && (list.currentLink.getAddress().toLowerCase().contains(sb.toLowerCase()))) {
                    insertAssignLink();
                    list.previousLink = list.previousLink.next;
                } else {
                    dManList.dManCurrentLink = dManList.dManCurrentLink.next;
                    insertAssignLink();
                    list.previousLink = list.previousLink.next;
                }
            } else {
                insertAssignLink();
            }

            //}
        }
        assignLink.assignDisplay();
        // }
    }

    public static void insertAssignLink() {

        assignLink.insertAssignLink(dManList.dManCurrentLink.getdManID(), list.currentLink.getOrderID(), list.currentLink.getEstimateTime());
        if (assignLink.checkID(dManList.dManCurrentLink.getdManID()) == true) {
            list.currentLink = list.currentLink.next;
        } else {
            dManList.dManCurrentLink = dManList.dManCurrentLink.next;
            list.currentLink = list.currentLink.next;
        }

    }

//    public static Integer checkTime(String time) {
//        int check = 0;
//        while (list != null && !list.isEmpty()) {
//            //time less than first link
//            if (Integer.parseInt(time.substring(0, 1)) <= Integer.parseInt(list.firstLink.getEstimateTime().substring(0, 1))) {
//                check = 1;
//
//                dManList.dManCurrentLink = dManList.dManFirstLink.next;
//                break;
//                //time more than first link and less than second link    
//            } else if (Integer.parseInt(time.substring(0, 1)) > Integer.parseInt(list.firstLink.getEstimateTime().substring(0, 1))
//                    && Integer.parseInt(time.substring(0, 1)) < Integer.parseInt(assignLink.deliveriesFirstLink.getEstimateTime().substring(0, 1))) {
//                check = 2;
//                //time more than second link
//            } else if (Integer.parseInt(time.substring(0, 1)) >= Integer.parseInt(assignLink.deliveriesFirstLink.getEstimateTime().substring(0, 1))) {
//                check = 3;
//            }
//        }
//
//        return check;
//    }

}
