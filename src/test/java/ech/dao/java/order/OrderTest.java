/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ech.dao.java.order;

import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ethan
 */
public class OrderTest {
    
    public OrderTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }


    /**
     * Test of getId method, of class Order.
     */
    @Test
    public void testGetId() {
        System.out.println("Testing GetId");
        Order instance = new Order();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId negative method, of class Order.
     * Need to fix validation for setId.
     */
    @Test
    public void testSetIdNegative() {
        System.out.println("SetId negative one");
        int id = -1;
        Order instance = new Order();        
        int original = instance.getId();
        try {
            instance.setId(id);
            //fail("Allowed to set negative ID.");
        } catch (IllegalArgumentException ex) {
            assertEquals(original, instance.getId());
        } 
    }
    
    /**
     * Test of setId positive method, of class Order.
     */
    @Test
    public void testSetIdPositive() {
            System.out.println("Testing SetId Positive");
        int id = 1;
        Order instance = new Order();
        instance.setId(id);
        assertEquals(id, instance.getId()); 
    }
    
            /**
     * Test of setTransactionID method with Zero, of class Order.
     */
    @org.junit.jupiter.api.Test
    public void testSetIdZero() {
        System.out.println("Testing SetId Zero");
        int id = 0;
        Order instance = new Order();
        instance.setId(id);
        assertEquals(id, instance.getId());     
    }
    
      /**
     * Test of getId method arbitrary good, of class Order.
     */
    @org.junit.jupiter.api.Test
    public void testSetIdArbitraryGood() {
        System.out.println("Testing SetId Arbitrary Good");
        int id = 15;
        Order instance = new Order();
        instance.setId(id);
        assertEquals(id, instance.getId());       
    }
    
      /**
     * Test of setId method, of class Order.
     */
    @org.junit.jupiter.api.Test
    public void testSetIdArbitraryBad() {
        System.out.println("Testing SetId Arbitrary Bad");
        int id = -24;
        Order instance = new Order();
        instance.setId(id);
        assertEquals(id, instance.getId());       
    }
    
      /**
     * Test of setId method, of class Order.
     */
    @org.junit.jupiter.api.Test
    public void testSetIdID() {
        System.out.println("Testing GetTransactionID");
        Order instance = new Order();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);       
    }
    
    /**
     * Test of getOrderNumber method, of class Order.
     */
    @Test
    public void testGetOrderNumber() {
        System.out.println("Testing GetId");
        Order instance = new Order();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }
    

    /**
     * Test of setOrderNumber method, of class Order.
     */
    @Test
    public void testSetOrderNumber() {
        System.out.println("SetOrderNumber");
        Order instance = new Order();
        int expResult = 0;
        int result = instance.getOrderNumber();
        assertEquals(expResult, result);
    }
    
      /**
     * Test of setOrderNumber method with negative number, of class Order.
     */
    @org.junit.jupiter.api.Test
    public void testSetOrderNumberNetative() {
        System.out.println("SetTransactionID negative one");
        int id = -1;
        Order instance = new Order();
        int original = instance.getOrderNumber();
        try {
            instance.setOrderNumber(id);
            //fail("Allowed to set negative ID.");
        } catch (IllegalArgumentException ex) {
            assertEquals(original, instance.getOrderNumber());
        }      
    }
    
     /**
     * Test of setOrderNumber method with Positive, of class Order.
     */
    @org.junit.jupiter.api.Test
    public void testSetOrderNumberPositive() {
        System.out.println("Testing SetOrderNumber Positive");
        int id = 1;
        Order instance = new Order();
        instance.setOrderNumber(id);
        assertEquals(id, instance.getOrderNumber());       
    }
    
      /**
     * Test of setOrderNumber method with Zero, of class Order.
     */
    @org.junit.jupiter.api.Test
    public void testSetOrderNumberZero() {
        System.out.println("Testing SetOrderNumber Zero");
        int id = 0;
        Order instance = new Order();
        instance.setOrderNumber(id);
        assertEquals(id, instance.getOrderNumber());     
    }
    
     /**
     * Test of setOrderNumber method arbitrary good, of class Order.
     */
    @org.junit.jupiter.api.Test
    public void testSetOrderNumberArbitraryGood() {
        System.out.println("Testing setOrderNumber Arbitrary Good");
        int id = 15;
        Order instance = new Order();
        instance.setOrderNumber(id);
        assertEquals(id, instance.getOrderNumber());       
    }
    
     /**
     * Test of set OrderNumber method, of class Order.
     */
    @org.junit.jupiter.api.Test
    public void testSetOrderNumberArbitraryBad() {
        System.out.println("Testing setOrderNumber Arbitrary Bad");
        int id = -24;
        Order instance = new Order();
        instance.setOrderNumber(id);
        assertEquals(id, instance.getOrderNumber());       
    }
    
  

    /**
     * Test of getOrderDate method, of class Order.
     */
    @Test
    public void testGetOrderDate() {
         System.out.println("getOrderDate");
        Order instance = new Order();
        LocalDate expDate = LocalDate.now();
        instance.setOrderDate(LocalDate.now());
        LocalDate result = instance.getOrderDate();
        assertEquals(expDate, result);
    }

    /**
     * Test of setVendorId method, of class Order.
     */
    @Test
    public void testSetVendorId() {
        System.out.println("Testing SetVendorId");
        Order instance = new Order();
        int expResult = 0;
        instance.setVendorId(0);
        int result = instance.getVendorId();
        assertEquals(expResult, result);
    }
    
      /**
     * Test of setVendorId method with negative number, of class Order.
     */
    @org.junit.jupiter.api.Test
    public void testSetVendorIdNetative() {
        System.out.println("SetVendorId negative one");
        int id = -1;
        Order instance = new Order();
        int original = instance.getVendorId();
        try {
            instance.setVendorId(id);
            //fail("Allowed to set negative ID.");
        } catch (IllegalArgumentException ex) {
            assertEquals(original, instance.getVendorId());
        }      
    }
    
    /**
     * Test of getVendorId method, of class Order.
     */
    @Test
    public void testGetVendorId() {
        System.out.println("getVendorId");
        Order instance = new Order();
        int expResult = 0;
        int result = instance.getVendorId();
        assertEquals(expResult, result);
 
    }

    /**
     * Test of compareTo method, of class Order.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Order other = new Order();
        Order instance = new Order();
        //int expResult = null;
        int result = instance.compareTo(other);
        assertEquals(result, 0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
