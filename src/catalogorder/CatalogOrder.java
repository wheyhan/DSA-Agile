/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogorder;

import da.CatalogOrderDA;
import domain.CatalogOrderDomain;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class CatalogOrder<T> implements OrderInterface<T> {

    private final CatalogOrderDA catalog = new CatalogOrderDA();
    private CatalogOrderDomain order = new CatalogOrderDomain();
    @Override
    public boolean insertOrder(LinkedList list) {
        boolean answer = false;
        
         answer = catalog.AddOrder(list);
        
        return answer;
    }

    @Override
    public void setOrder(CatalogOrderDomain order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String retrieveFlower(T prodID) {
        String check = "";
        
        check = catalog.RetrieveFlower(prodID);
        
        return check;
    }

    @Override
    public String retrieveBouquet(T prodID) {
        String check = "";
        
        check = catalog.RetrieveBouquet(prodID);
        
        return check;
    }

    @Override
    public String retrieveFlowerName(T prodName) {
        String check = "";
        
        check = catalog.RetrieveFlowerIdByName(prodName);
        
        return check;
    }

    @Override
    public String retrieveBouquetName(T prodName) {
         String check = "";
        
        check = catalog.RetrieveBouquetIdByName(prodName);
        
        return check;
    }

    @Override
    public boolean insertBouquetOrders(LinkedList list) {
        boolean answer = false;
        
         answer = catalog.AddOrder(list);
        
        return answer;
    }

    @Override
    public boolean insertFlowerOrders(LinkedList list) {
        boolean answer = false;
        
         answer = catalog.AddOrder(list);
        
        return answer;
    }

    @Override
    public String retrieveOrderIdDelivery(LinkedList list) {
        String check = "";
        
        check = catalog.RetrieveOrderIdDelivery(list);
        
        return check;
    }

}
