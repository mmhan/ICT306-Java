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
        System.out.println(instance.toString());
    }

    /**
     * Test of returnCopy method, of class CreditCustomer.
     */
    @Test
    public void testReturnCopy() {
        System.out.println("returnCopy");
        
        VideoTitle title = new VideoTitle("Test", 2.0, 1);
        VideoCopy copy = new VideoCopy(title);
        CreditCustomer cCust = new CreditCustomer("Test Customer", "101 Bla", 1, "1234");
        cCust.rent(copy);
        boolean expResult = true;
        boolean result = cCust.returnCopy(copy.getId());
        assertEquals(expResult, result);
        assertEquals(0, instance.getRented());
        
        System.out.println(" - testing to return a copy that the user didn't rent");
        expResult = false;
        result = cCust.returnCopy(500);
        assertEquals(expResult, result);
    }
}
