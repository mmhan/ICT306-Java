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
public class CustomerModelTest {
    
    private CustomerModel instance = new CustomerModel();
    
    public CustomerModelTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        instance.save(new Customer("Mike", "101 Main Street", 10));
        instance.save(new Customer("John", "102 Main Street", 5));
        instance.save(new CreditCustomer("Cindy", "103 Main Street", 5, "1234"));
    }
    
    @After
    public void tearDown() {
        instance = new CustomerModel();
    }

    /**
     * Test of getCount method, of class CustomerModel.
     */
    @Test
    public void testGetCount() {
        System.out.println("getCount");
        int expResult = 3;
        int result = instance.getCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of save method, of class CustomerModel.
     */
    @Test
    public void testSave_Customer() {
        System.out.println("save: Customer");
        Customer customerA = new Customer("A", "200 Main Street", 10);
        instance.save(customerA);
        assertEquals(customerA, instance.customers[instance.getCount() - 1]);
    }

    /**
     * Test of save method, of class CustomerModel.
     */
    @Test
    public void testSave_CreditCustomer() {
        System.out.println("save: CreditCustomer");
        Customer customerB = new CreditCustomer("B", "300 Main Street", 10, "1234");
        instance.save(customerB);
        assertEquals(customerB, instance.customers[instance.getCount() - 1]);
    }

    /**
     * Test of findKey method, of class CustomerModel.
     */
    @Test
    public void testFindKey() {
        System.out.println("findKey");
        
        Customer customerA = new Customer("A", "200 Main Street", 10);
        instance.save(customerA);
        assertEquals(3, instance.findKey(customerA.id));
    }
}