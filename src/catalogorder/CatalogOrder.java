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
public class CatalogOrder implements OrderInterface {

    private final CatalogOrderDA catalog = new CatalogOrderDA();
    private CatalogOrderDomain order = new CatalogOrderDomain();
    @Override
    public boolean insertOrder() {
        
        boolean answer = catalog.AddOrder(order);
        
        return answer;
    }

    @Override
    public void setOrder(CatalogOrderDomain order) {
        this.order = order;
    }


    
}
