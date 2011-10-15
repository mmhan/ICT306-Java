/*
 * This class is here to basically test out if the implemnentation works or not
 * Nothing much to be tested out to be honest.
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
    }

    /**
     * Test of setAddress method, of class GenericCustomer.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String expected = "";
        GenericCustomer instance = new GenericCustomerImpl();
        assertEquals(expected, instance.getAddress());
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
        assertEquals(maxAllowed, instance.maxAllowed);
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
    }
    
    /**
     * Test of getRented method, of class GenericCustomer.
     */
    @Test
    public void testGetRented() {
        System.out.println("getRented");
        GenericCustomer instance = new GenericCustomerImpl();
        int expResult = 0;
        int result = instance.getRented();
        assertEquals(expResult, result);
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
    }

    public class GenericCustomerImpl extends GenericCustomer {

        @Override
        public String getAddress() {
            return "";
        }

        @Override
        public void setAddress(String address) {
        }

        @Override
        public int getId() {
            return 0;
        }

        @Override
        public int getMaxAllowed() {
            return 0;
        }

        @Override
        public void setMaxAllowed(int maxAllowed) {
        }

        @Override
        public String getName() {
            return "";
        }

        @Override
        public void setName(String name) {
        }

        @Override
        public String toString() {
            return "";
        }
        
        @Override
        public int getRented(){
            return 0;
        }
    }

    
}
