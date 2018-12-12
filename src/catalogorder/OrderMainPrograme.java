/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogorder;

import java.util.Scanner;
import domain.CatalogOrderDomain;

/**juin han
 *o
 * @author USER
 */
public class OrderMainPrograme {

    private static String DeliverAddress = "";
    private static String ProductID = "";
    private static int Quantity = 0;
    private static String PickUpDate = "";
    private static String PickUpTime = "";
    private static String PaymentMethod = "";
    private static String PaymentStatus = "";
    private static String ReceiveMethod = "";
    private static String OrderStatus = "";
    private static String ProdName = "";
    private static OrderInterface OI = new CatalogOrder();
    private static LinkedList orderList = new LinkedList();

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        String opt;
        String ans;

        System.out.println("Catalog Order");

        do {

            System.out.print("\nDo you want to use delivery or pickup?: ");
            System.out.print("\n1. Delivery");
            System.out.print("\n2. Pickup");
            System.out.print("\nAny Characters to exit the system\n");
            System.out.print("\nDecision: ");
            int yesno = Integer.parseInt(scan.nextLine());

            switch (yesno) {
                case 1:

                    System.out.print("\nPlease enter your delivery address: ");
                    DeliverAddress = scan.nextLine();

                    OrderDetails();
                    if (PaymentMethod.equals("CREDIT")) {
                        PaymentStatus = "PENDING";

                    } else {
                        System.out.print("\nWould you like to cash on delivery?: ");
                        ans = scan.nextLine();
                        if (ans.equals("Y") || ans.equals("y")) {
                            PaymentStatus = "PENDING";
                        } else {
                            PaymentStatus = "PAID";
                        }
                    }

                    ReceiveMethod = "DELIVERY";
                    OrderStatus = "ONHOLD";

                    break;
                case 2:

                    OrderDetails();

                    if (PaymentMethod.equals("CREDIT")) {
                        PaymentStatus = "PENDING";
                        OrderStatus = "PICKEDUP";
                    } else {
                        System.out.println("\nWould you like to cash on pickup?: ");
                        ans = scan.nextLine();
                        if (ans.equals("Y") || ans.equals("y")) {
                            PaymentStatus = "PENDING";
                            OrderStatus = "ONHOLD";
                        } else {
                            PaymentStatus = "PAID";
                            OrderStatus = "PICKEDUP";
                        }
                    }

                    ReceiveMethod = "PICKUP";
                    DeliverAddress = "null";
                    break;
                default:
                    System.out.print("\nSystem will now exit!");
                    break;
            }

            addOrder();

            System.out.println("\nDo you wish to continue(Y or y)?");
            opt = scan.nextLine();

        } while (opt.equals("Y") || opt.equals("y"));

        insertOrderList();
    }

    public static void OrderDetails() {
        String opt;

        System.out.println("\nEnter Product ID: ");
        ProductID = scan.nextLine();
        if (!OI.retrieveFlower(ProductID).isEmpty()) {
            ProdName = OI.retrieveFlower(ProductID);
        } else if (!OI.retrieveBouquet(ProductID).isEmpty()) {
            ProdName = OI.retrieveBouquet(ProductID);
        } else {
            System.out.println("\nProduct Not Found\n");
            main(null);
        }

        System.out.println("\nEnter Quantity: ");
        Quantity = Integer.parseInt(scan.nextLine());

        System.out.println("\nEnter Expected Date: ");
        PickUpDate = scan.nextLine();

        System.out.println("\nEnter Expected Time: ");
        PickUpTime = scan.nextLine();

        System.out.print("\nEnter Payment Method: ");
        System.out.print("\n1. Cash\n2. Credit Limit\n");
        int getMethod = Integer.parseInt(scan.nextLine());

        if (getMethod == 1) {
            PaymentMethod = "CASH";
        } else if (getMethod == 2) {
            PaymentMethod = "CREDIT";
        }
    }

    public static void addOrder() {
        orderList.insertFirstNode(DeliverAddress, PaymentMethod, PaymentStatus, OrderStatus, PickUpDate, PickUpTime, ReceiveMethod, Quantity, ProdName);
        orderList.display();
    }

    public static void insertOrderList() {
        String productID = "";
        String orderID = "";
        
        if (OI.insertOrder(orderList)) {
            System.out.print("\nDetails saved!!");
        } else {
            System.out.print("\nDetails not saved!!");

        }
    }
}
