/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ict306lab.MikeHan.majorassignment.ass02;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for Book.
 * 
 * @author mmhan
 */
public class BookTest {
    
    public BookTest() {
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
     * Test of getNextId method, of class Book.
     */
    @Test
    public void testGetNextId() {
        System.out.println("getNextId");
        int expResult = 0;
        int result = Book.getNextId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class Book.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Book instance = new Book();
        int expResult = Book.counter;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getImageFile method, of class Book.
     */
    @Test
    public void testGetImageFile() {
        System.out.println("getImageFile");
        Book instance = new Book();
        String expResult = "";
        String result = instance.getImageFile();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNotesFile method, of class Book.
     */
    @Test
    public void testGetNotesFile() {
        System.out.println("getNotesFile");
        Book instance = new Book();
        String expResult = "";
        String result = instance.getNotesFile();
        assertEquals(expResult, result);
    }

    /**
     * Test of setImageFile method, of class Book.
     */
    @Test
    public void testSetImageFile() {
        System.out.println("setImageFile");
        String imageFile = "bla";
        Book instance = new Book();
        instance.setImageFile(imageFile);
        assertEquals(imageFile, instance.getImageFile());
    }

    /**
     * Test of setNotesFile method, of class Book.
     */
    @Test
    public void testSetNotesFile() {
        System.out.println("setNotesFile");
        String notesFile = "";
        Book instance = new Book();
        instance.setNotesFile(notesFile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
