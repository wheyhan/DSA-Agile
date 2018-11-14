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
public interface OrderInterface {

    boolean insertOrder();

    void setOrder(CatalogOrderDomain order);
}
