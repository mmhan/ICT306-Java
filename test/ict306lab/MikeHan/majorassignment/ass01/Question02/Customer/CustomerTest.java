/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ict306lab.MikeHan.majorassignment.ass01.Question02.Customer;

import ict306lab.MikeHan.majorassignment.ass01.Question02.Video.VideoCopy;
import ict306lab.MikeHan.majorassignment.ass01.Question02.Video.VideoTitle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mmhan
 */
public class CustomerTest {
    
    public CustomerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        Customer.count = 0;
    }

    /**
     * Test of getAddress method, of class Customer.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        Customer instance = new Customer("Mike", "101 Main Street", 10);
        String expResult = "101 Main Street";
        String result = instance.getAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAddress method, of class Customer.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "101 Main St.";
        Customer instance = new Customer();
        instance.setAddress(address);
        assertEquals(instance.getAddress(), address);
    }

    /**
     * Test of getId method, of class Customer.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Customer instance = new Customer();
        int expResult = 1;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMaxAllowed method, of class Customer.
     */
    @Test
    public void testGetMaxAllowed() {
        System.out.println("getMaxAllowed");
        Customer instance = new Customer();
        int expResult = 0;
        int result = instance.getMaxAllowed();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMaxAllowed method, of class Customer.
     */
    @Test
    public void testSetMaxAllowed() {
        System.out.println("setMaxAllowed");
        int maxAllowed = 20;
        Customer instance = new Customer();
        instance.setMaxAllowed(maxAllowed);
        assertEquals(instance.getMaxAllowed(), maxAllowed);
        
        instance.rented = 20;
        instance.setMaxAllowed(10);
        assertTrue(instance.isOverMax);
        
        instance = new Customer("Mike", "101 Main Street", 10);
        int expMax = 20;
        instance.setMaxAllowed(expMax);
        assertEquals(expMax, instance.getMaxAllowed());
        assertTrue(!instance.isOverMax);
    }

    /**
     * Test of getName method, of class Customer.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Customer.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Customer instance = new Customer();
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

    /**
     * Test of toString method, of class Customer.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Customer instance = new Customer("Mike","101 Main St.", 10);
        System.out.println(instance.toString());
    }

    /**
     * Test of generateId method, of class Customer.
     */
    @Test
    public void testGenerateId() {
        System.out.println("generateId");
        int expResult = Customer.count + 1;
        int result = Customer.generateId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRented method, of class Customer.
     */
    @Test
    public void testGetRented() {
        System.out.println("getRented");
        System.out.println(" - test before renting one");
        Customer instance = new Customer("Test Customer", "101 Bla", 3);
        int expResult = 0;
        int result = instance.getRented();
        assertEquals(expResult, result);
        System.out.println(" - test after renting one");
        instance.rent(new VideoCopy(new VideoTitle("Test", 2.0, 3)));
        expResult = 1;
        result = instance.getRented();
        assertEquals(expResult, result);
    }

    /**
     * Test of rent method, of class Customer.
     */
    @Test
    public void testRent() {
        System.out.println("rent");
        VideoTitle title = new VideoTitle("Test", 2.0, 1);
        VideoCopy copy = new VideoCopy(title);
        Customer instance = new Customer("Test Customer", "101 Bla", 1);
        boolean expResult = true;
        boolean result = instance.rent(copy);
        assertEquals(expResult, result);
        System.out.println(" - testing to rent more than allowed");
        expResult = false;
        result = instance.rent(new VideoCopy(title));
        assertEquals(expResult, result);
        
        System.out.println(" - testing to rent, right after increasing max.");
        instance.setMaxAllowed(2);
        expResult = true;
        result = instance.rent(new VideoCopy(title));
        assertEquals(expResult, result);
        
        System.out.println(" - testing to rent, right after decreasing max.");
        instance.setMaxAllowed(1);
        expResult = false;
        result = instance.rent(new VideoCopy(title));
        assertEquals(expResult, result);
    }

    /**
     * Test of returnCopy method, of class Customer.
     */
    @Test
    public void testReturnCopy() {
        System.out.println("returnCopy");

        VideoTitle title = new VideoTitle("Test", 2.0, 1);
        VideoCopy copy = new VideoCopy(title);
        Customer instance = new Customer("Test Customer", "101 Bla", 1);
        instance.rent(copy);
        boolean expResult = true;
        boolean result = instance.returnCopy(copy.getId());
        assertEquals(expResult, result);
        assertEquals(0, instance.getRented());
        
        System.out.println(" - testing to return a copy that the user didn't rent");
        expResult = false;
        result = instance.returnCopy(500);
        assertEquals(expResult, result);
    }
}
