/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogorder;

import domain.CatalogOrderDomain;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author USER
 */
public class CatalogOrderTest {
    
    public CatalogOrderTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of insertOrder method, of class CatalogOrder.
     */
    @Test
    public void testInsertOrder() {
        System.out.println("insertOrder");
        CatalogOrder instance = new CatalogOrder();
        boolean expResult = false;
        boolean result = instance.insertOrder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrder method, of class CatalogOrder.
     */
    @Test
    public void testSetOrder() {
        System.out.println("setOrder");
        CatalogOrderDomain order = null;
        CatalogOrder instance = new CatalogOrder();
        instance.setOrder(order);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
