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
public class CreditCustomerTest {
    
    private CreditCustomer instance;
    
    public CreditCustomerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        this.instance = new CreditCustomer("Mike", "101 Main Street", 10, "1234");
    }
    
    @After
    public void tearDown() {
        this.instance = null;
        CreditCustomer.count = 0;
    }

    /**
     * Test of CreditCustomer conversion from Customer
     */
    @Test
    public void testCreditCustomerFromCustomer(){
        System.out.println("CreditCustomer(cust:Customer, ccNumber: String)");
        Customer cu = new Customer("Mike", "101 Main Street", 10);
        CreditCustomer converted = new CreditCustomer(cu, "1234");
        assertEquals(instance.getName(), converted.getName());
        assertEquals(instance.getAddress(), converted.getAddress());
        assertEquals(instance.getMaxAllowed(), converted.getMaxAllowed());
        assertEquals(instance.getCcNumber(), converted.getCcNumber());
    }
    /**
     * Test of getBalance method, of class CreditCustomer.
     */
    @Test
    public void testGetBalance() {
        System.out.println("getBalance");
        Double expResult = 0.0;
        Double result = instance.getBalance();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBalance method, of class CreditCustomer.
     */
    @Test
    public void testSetBalance() {
        System.out.println("setBalance");
        Double balance = 10.2;
        instance.setBalance(balance);
        assertEquals(instance.getBalance(), balance);
    }

    /**
     * Test of getCcNumber method, of class CreditCustomer.
     */
    @Test
    public void testGetCcNumber() {
        System.out.println("getCcNumber");
        String expResult = "1234";
        String result = instance.getCcNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCcNumber method, of class CreditCustomer.
     */
    @Test
    public void testSetCcNumber() {
        System.out.println("setCcNumber");
        String ccNumber = "5678";
        instance.setCcNumber(ccNumber);
        assertEquals(ccNumber, instance.getCcNumber());
    }

    /**
     * Test of addBalance method, of class CreditCustomer.
     */
    @Test
    public void testAddBalance() {
        System.out.println("addBalance");
        Double add = 2.5;
        instance.addBalance(add);
        assertEquals(instance.getBalance(), add);
    }

    /**
     * Test of clearBalance method, of class CreditCustomer.
     */
    @Test
    public void testClearBalance() {
        System.out.println("clearBalance");
        instance.addBalance(2.2);
        instance.clearBalance();
        assertTrue(instance.getBalance() == 0.0);
    }

    /**
     * Test of toString method, of class CreditCustomer.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = Customer.count + "\tMike\t101 Main Street\t10\t1234\t0.0\t";
        String result = instance.toString();
        //System.out.println(expResult + "\n" + result);
        assertEquals(expResult, result);
    }
}
