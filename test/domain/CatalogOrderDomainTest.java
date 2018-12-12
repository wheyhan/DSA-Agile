/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author USER
 */
public class CatalogOrderDomainTest {
    
    public CatalogOrderDomainTest() {
    }
    
    @Before
    public void setUp() {
    }


    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        CatalogOrderDomain instance = new CatalogOrderDomain();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getOrderID method, of class CatalogOrderDomain.
     */
    @Test
    public void testGetOrderID() {
        System.out.println("getOrderID");
        CatalogOrderDomain instance = new CatalogOrderDomain();
        String expResult = "O1001";
        String result = instance.getOrderID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setOrderID method, of class CatalogOrderDomain.
     */
    @Test
    public void testSetOrderID() {
        System.out.println("setOrderID");
        String OrderID = "";
        CatalogOrderDomain instance = new CatalogOrderDomain();
        instance.setOrderID(OrderID);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCustName method, of class CatalogOrderDomain.
     */
    @Test
    public void testGetCustName() {
        System.out.println("getCustName");
        CatalogOrderDomain instance = new CatalogOrderDomain();
        String expResult = "Haur";
        String result = instance.getCustName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCustName method, of class CatalogOrderDomain.
     */
    @Test
    public void testSetCustName() {
        System.out.println("setCustName");
        String CustName = "";
        CatalogOrderDomain instance = new CatalogOrderDomain();
        instance.setCustName(CustName);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCustEmail method, of class CatalogOrderDomain.
     */
    @Test
    public void testGetCustEmail() {
        System.out.println("getCustEmail");
        CatalogOrderDomain instance = new CatalogOrderDomain();
        String expResult = "Huar@gmail.com";
        String result = instance.getCustEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCustEmail method, of class CatalogOrderDomain.
     */
    @Test
    public void testSetCustEmail() {
        System.out.println("setCustEmail");
        String CustEmail = "";
        CatalogOrderDomain instance = new CatalogOrderDomain();
        instance.setCustEmail(CustEmail);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCustContact method, of class CatalogOrderDomain.
     */
    @Test
    public void testGetCustContact() {
        System.out.println("getCustContact");
        CatalogOrderDomain instance = new CatalogOrderDomain();
        String expResult = "0123456789";
        String result = instance.getCustContact();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCustContact method, of class CatalogOrderDomain.
     */
    @Test
    public void testSetCustContact() {
        System.out.println("setCustContact");
        String CustContact = "";
        CatalogOrderDomain instance = new CatalogOrderDomain();
        instance.setCustContact(CustContact);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDeliverAdd method, of class CatalogOrderDomain.
     */
    @Test
    public void testGetDeliverAdd() {
        System.out.println("getDeliverAdd");
        CatalogOrderDomain instance = new CatalogOrderDomain();
        String expResult = "asdf";
        String result = instance.getDeliverAdd();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDeliverAdd method, of class CatalogOrderDomain.
     */
    @Test
    public void testSetDeliverAdd() {
        System.out.println("setDeliverAdd");
        String DeliverAdd = "";
        CatalogOrderDomain instance = new CatalogOrderDomain();
        instance.setDeliverAdd(DeliverAdd);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantity method, of class CatalogOrderDomain.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        CatalogOrderDomain instance = new CatalogOrderDomain();
        int expResult = 2;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantity method, of class CatalogOrderDomain.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        int Quantity = 0;
        CatalogOrderDomain instance = new CatalogOrderDomain();
        instance.setQuantity(Quantity);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPickUpDate method, of class CatalogOrderDomain.
     */
    @Test
    public void testGetPickUpDate() {
        System.out.println("getPickUpDate");
        CatalogOrderDomain instance = new CatalogOrderDomain();
        String expResult = "12-12-2018";
        String result = instance.getPickUpDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPickUpDate method, of class CatalogOrderDomain.
     */
    @Test
    public void testSetPickUpDate() {
        System.out.println("setPickUpDate");
        String PickUpDate = "";
        CatalogOrderDomain instance = new CatalogOrderDomain();
        instance.setPickUpDate(PickUpDate);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPickUpTime method, of class CatalogOrderDomain.
     */
    @Test
    public void testGetPickUpTime() {
        System.out.println("getPickUpTime");
        CatalogOrderDomain instance = new CatalogOrderDomain();
        String expResult = "01:30";
        String result = instance.getPickUpTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPickUpTime method, of class CatalogOrderDomain.
     */
    @Test
    public void testSetPickUpTime() {
        System.out.println("setPickUpTime");
        String PickUpTime = "";
        CatalogOrderDomain instance = new CatalogOrderDomain();
        instance.setPickUpTime(PickUpTime);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPaymentMethod method, of class CatalogOrderDomain.
     */
    @Test
    public void testGetPaymentMethod() {
        System.out.println("getPaymentMethod");
        CatalogOrderDomain instance = new CatalogOrderDomain();
        String expResult = "1";
        String result = instance.getPaymentMethod();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setPaymentMethod method, of class CatalogOrderDomain.
     */
    @Test
    public void testSetPaymentMethod() {
        System.out.println("setPaymentMethod");
        String PaymentMethod = "";
        CatalogOrderDomain instance = new CatalogOrderDomain();
        instance.setPaymentMethod(PaymentMethod);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPickUpMethod method, of class CatalogOrderDomain.
     */
    @Test
    public void testGetPickUpMethod() {
        System.out.println("getPickUpMethod");
        CatalogOrderDomain instance = new CatalogOrderDomain();
        String expResult = "1";
        String result = instance.getPickUpMethod();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPickUpMethod method, of class CatalogOrderDomain.
     */
    @Test
    public void testSetPickUpMethod() {
        System.out.println("setPickUpMethod");
        String PickUpMethod = "";
        CatalogOrderDomain instance = new CatalogOrderDomain();
        instance.setPickUpMethod(PickUpMethod);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getProductID method, of class CatalogOrderDomain.
     */
    @Test
    public void testGetProductID() {
        System.out.println("getProductID");
        CatalogOrderDomain instance = new CatalogOrderDomain();
        String expResult = "P001";
        String result = instance.getProductID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setProductID method, of class CatalogOrderDomain.
     */
    @Test
    public void testSetProductID() {
        System.out.println("setProductID");
        String ProductID = "";
        CatalogOrderDomain instance = new CatalogOrderDomain();
        instance.setProductID(ProductID);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getMonthlyLimit method, of class CatalogOrderDomain.
     */

    
}
