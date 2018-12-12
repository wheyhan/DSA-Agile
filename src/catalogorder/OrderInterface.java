/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogorder;

import domain.CatalogOrderDomain;

/**
 *
 * @author USER
 */
public interface OrderInterface<T> {

    boolean insertOrder(LinkedList list);
    String retrieveFlower(T prodID);
    String retrieveBouquet(T prodID);
    String retrieveFlowerName(T prodName);
    String retrieveBouquetName(T prodName);
    String retrieveOrderIdDelivery(LinkedList list);
    boolean insertBouquetOrders(LinkedList list);
    boolean insertFlowerOrders(LinkedList list);

}
