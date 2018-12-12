/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import domain.CatalogOrderDomain;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author USER
 */
public class CatalogOrderDATest {
    
    public CatalogOrderDATest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of AddOrder method, of class CatalogOrderDA.
     */
    @Test
    public void testAddOrder() {
        System.out.println("AddOrder");
        CatalogOrderDomain order = null;
        CatalogOrderDA instance = new CatalogOrderDA();
        boolean expResult = false;
        boolean result = instance.AddOrder(order);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
