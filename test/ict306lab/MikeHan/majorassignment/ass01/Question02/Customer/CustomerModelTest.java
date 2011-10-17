/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ict306lab.MikeHan.majorassignment.ass01.Question02.Customer;

import ict306lab.MikeHan.majorassignment.ass01.Question02.Video.VideoCopy;
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

    /**
     * Test of getList method, of class CustomerModel.
     */
    @Test
    public void testGetList() {
        System.out.println("getList");
        String[][] expResult = new String[][]{
            new String[]{"Mike", "1"},
            new String[]{"John", "2"},
            new String[]{"Cindy", "3"}
        };
        String[][] result = instance.getList();
        for(int i = 0; i < result.length; i++){
            assertEquals(expResult[i][0], result[i][0]);
        }
    }

    /**
     * Test of find method, of class CustomerModel.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        Customer cust = new Customer("Milo", "101 bla ", 2);
        instance.save(cust);
        GenericCustomer result = instance.find(GenericCustomer.count);
        assertEquals(cust, result);
    }

    /**
     * Test of getRentedList method, of class CustomerModel.
     */
    @Test
    public void testGetRentedList() {
        System.out.println("getRentedList");
        Customer cust = new Customer("Milo", "101 bla", 1);
        cust.rented = 1;
        instance.save(cust);
        String[][] allRentedCustomers = instance.getRentedList();
        String[] expResult = new String[]{
            cust.getName(), 
            Integer.toString(cust.getId())
        };
        assertEquals(expResult, allRentedCustomers[0]);
    }

    /**
     * Test of findRentedCopies method, of class CustomerModel.
     */
    @Test
    public void testFindRentedCopies() {
        System.out.println("findRentedCopies");
        int id = 0;
        VideoCopy[] expResult = instance.customers[0].copies;
        VideoCopy[] result = instance.findRentedCopies(instance.customers[0].id);
        assertEquals(expResult, result);
    }
}