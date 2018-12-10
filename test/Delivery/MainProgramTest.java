/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Delivery;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author user
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainProgramTest {

    public MainProgramTest() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of showDelivery method, of class MainProgram.
     */
    @Test
    public void testAShowDelivery() {
        System.out.println("first");
        boolean check = MainProgram.showDelivery();
        if (check == true) {
            assertTrue("Passed", check);
        } else {
            assertFalse("Failed", check);
        }

    }

    /**
     * Test of deliveryMethod method, of class MainProgram.
     */
    @Test
    public void testCDeliveryMethod() {
        System.out.println("second");
        boolean list = MainProgram.deliveryMethod();
        if (list == true) {
            assertTrue("Passed", list);
        } else {
            assertFalse("Failed", list);
        }

    }
}
