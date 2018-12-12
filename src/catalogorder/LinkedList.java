/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogorder;

import domain.BouquetOrder;
import domain.CatalogOrderDomain;
import domain.FlowerOrder;

/**
 *
 * @author user
 */
public class LinkedList {
    // Reference to first Link in list
    // The last Link added to the LinkedList

    public CatalogOrderDomain firstNode;
    public CatalogOrderDomain currentNode;
    public BouquetOrder bouquetFirstNode;
    public BouquetOrder bouquetCurrentNode;
    public FlowerOrder flowerFirstNode;
    public FlowerOrder flowerCurrentNode;

    public LinkedList() {

        // Here to show the first Link always starts as null
        firstNode = null;

    }

    // Returns true if LinkList is empty
    public boolean isEmpty() {
        return (firstNode == null);
    }

    public boolean isEmptyCurrent() {
        return (currentNode == null);
    }
    
    public boolean isBouquetEmpty() {
        return (bouquetFirstNode == null);
    }

    public boolean isBouquetEmptyCurrent() {
        return (bouquetCurrentNode == null);
    }
    
    public boolean isFlowerEmpty() {
        return (flowerFirstNode == null);
    }

    public boolean isFlowerEmptyCurrent() {
        return (flowerCurrentNode == null);
    }
    
    public void insertFirstNode(String DeliverAdd, String PaymentMethod, String PaymentStatus, String OrderStatus,
            String EstimateDate, String EstimateTime, String ReceivedMethod, int Quantity, String ProdName) {

        CatalogOrderDomain newNode = new CatalogOrderDomain(DeliverAdd, PaymentMethod, PaymentStatus, OrderStatus,
                EstimateDate, EstimateTime, ReceivedMethod, Quantity, ProdName);

        // Connects the firstLink field to the new Link 
        newNode.next = firstNode;

        firstNode = newNode;

    }
    
    public void insertFlowerFirstNode(String OrderID, String FlowerID, int Quantity) {

        FlowerOrder newNode = new FlowerOrder(OrderID, FlowerID, Quantity);

        // Connects the firstLink field to the new Link 
        newNode.next = flowerFirstNode;

        flowerFirstNode = newNode;

    }
    
    public void insertBouquetFirstNode(String OrderID, String BouquetID, int Quantity) {

        BouquetOrder newNode = new BouquetOrder(OrderID, BouquetID, Quantity);

        // Connects the firstLink field to the new Link 
        newNode.next = bouquetFirstNode;

        bouquetFirstNode = newNode;

    }

    public CatalogOrderDomain removeFirst() {

        CatalogOrderDomain linkReference = firstNode;

        if (!isEmpty()) {

            // Removes the Link from the List
            firstNode = firstNode.next;

        } else {

            System.out.println("Empty LinkedList");

        }

        return linkReference;

    }

    public void display() {

        CatalogOrderDomain theLink = firstNode;

        // Start at the reference stored in firstLink and
        // keep getting the references stored in next for
        // every Link until next returns null
        System.out.format("%-27s%-52s%-16s%-16s%-14s%-15s%-15s%-17s%-8s",
                "Product Name", "Address", "Payment Method", "Payment Status", "Order Status", "Expected Date", "Expected Time", "Received Method", "Quantity\n");
        System.out.format("%-27s%-52s%-16s%-16s%-14s%-15s%-15s%-17s%-8s",
                "-------------------------", "--------------------------------------------------", "--------------", "--------------", "------------", "-------------", "-------------", "---------------", "--------\n");
        while (theLink != null) {

            theLink.Display();

            //System.out.println("Next Link: " + theLink.next);
            theLink = theLink.next;

            System.out.println();

        }

    }

    public CatalogOrderDomain find(String orderID) {

        CatalogOrderDomain theLink = firstNode;

        if (!isEmpty()) {

            while (theLink.getOrderID().equals(orderID)) {

                // Checks if at the end of the LinkedList
                if (theLink.next == null) {

                    // Got to the end of the Links in LinkedList
                    // without finding a match
                    return null;

                } else {

                    // Found a matching Link in the LinkedList
                    theLink = theLink.next;

                }

            }

        } else {

            System.out.println("Empty LinkedList");

        }

        return theLink;

    }

    public CatalogOrderDomain removeLink(String orderID) {

        CatalogOrderDomain currentLink = firstNode;
        CatalogOrderDomain previousLink = firstNode;

        // Keep searching as long as a match isn't made
        while (currentLink.getOrderID().equals(orderID)) {

            // Check if at the last Link in the LinkedList
            if (currentLink.next == null) {

                // bookName not found so leave the method
                return null;

            } else {

                // We checked here so let's look in the
                // next Link on the list
                previousLink = currentLink;

                currentLink = currentLink.next;

            }

        }

        if (currentLink == firstNode) {

            // If you are here that means there was a match
            // in the reference stored in firstLink in the
            // LinkedList so just assign next to firstLink
            firstNode = firstNode.next;

        } else {

            // If you are here there was a match in a Link other 
            // than the firstLink. Assign the value of next for
            // the Link you want to delete to the Link that's 
            // next previously pointed to the reference to remove
            System.out.println("FOUND A MATCH");
            System.out.println("currentLink: " + currentLink);
            System.out.println("firstLink: " + firstNode);

            previousLink.next = currentLink.next;

        }

        return currentLink;

    }
}
