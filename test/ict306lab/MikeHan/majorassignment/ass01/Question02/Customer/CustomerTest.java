/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ict306lab.MikeHan.majorassignment.ass01.Question02.Customer;

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
        int expResult = 0;
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
        String expResult = "1\tMike\t101 Main St.\t10\t";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
