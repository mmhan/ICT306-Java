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
public class GenericCustomerTest {
    
    public GenericCustomerTest() {
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
    }

    /**
     * Test of getAddress method, of class GenericCustomer.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        GenericCustomer instance = new GenericCustomerImpl();
        String expResult = "";
        String result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddress method, of class GenericCustomer.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "";
        GenericCustomer instance = new GenericCustomerImpl();
        instance.setAddress(address);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class GenericCustomer.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        GenericCustomer instance = new GenericCustomerImpl();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxAllowed method, of class GenericCustomer.
     */
    @Test
    public void testGetMaxAllowed() {
        System.out.println("getMaxAllowed");
        GenericCustomer instance = new GenericCustomerImpl();
        int expResult = 0;
        int result = instance.getMaxAllowed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxAllowed method, of class GenericCustomer.
     */
    @Test
    public void testSetMaxAllowed() {
        System.out.println("setMaxAllowed");
        int maxAllowed = 0;
        GenericCustomer instance = new GenericCustomerImpl();
        instance.setMaxAllowed(maxAllowed);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class GenericCustomer.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        GenericCustomer instance = new GenericCustomerImpl();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class GenericCustomer.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        GenericCustomer instance = new GenericCustomerImpl();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class GenericCustomer.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        GenericCustomer instance = new GenericCustomerImpl();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class GenericCustomerImpl extends GenericCustomer {

        public String getAddress() {
            return "";
        }

        public void setAddress(String address) {
        }

        public int getId() {
            return 0;
        }

        public int getMaxAllowed() {
            return 0;
        }

        public void setMaxAllowed(int maxAllowed) {
        }

        public String getName() {
            return "";
        }

        public void setName(String name) {
        }

        public String toString() {
            return "";
        }
    }
}
