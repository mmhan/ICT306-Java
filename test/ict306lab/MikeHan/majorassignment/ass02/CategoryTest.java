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
 *
 * @author mmhan
 */
public class CategoryTest {
    
    public CategoryTest() {
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
     * Test of toString method, of class Category.
     */
    @Test
    public void testToString() {
        String catName = "Bla";
        Category cat = new Category(catName);
        String result = cat.toString();
        assertEquals(catName, result);
    }

    /**
     * Test of add method, of class Category.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Book book = new Book("bla", "bla", "Bla");
        Category cat = new Category("Bla");
        boolean expResult = true;
        int expLength = cat.getBooks().length + 1;
        boolean result = cat.add(book);
        assertEquals(expResult, result);
        assertEquals(expLength, cat.count());
    }

    /**
     * Test of remove method, of class Category.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Book book = new Book("Bla", "Bla", "Bla");
        Category cat = new Category("Bla");
        assertEquals(0, cat.count());
        cat.add(book);
                
        boolean result = cat.remove(book);
        assertEquals(true, result);
        assertEquals(0, cat.count());
    }

    /**
     * Test of getBooks method, of class Category.
     */
    @Test
    public void testGetBooks() {
        System.out.println("getBooks");
        
        Category cat = new Category("Comics");
        Book b1 = new Book("Spiderman", "123", "abc");
        cat.add(b1);
        Book b2 = new Book("Superman", "123", "abc");
        cat.add(b2);
        Book b3 = new Book("Batman", "123", "abc");
        cat.add(b3);
        
        Book[] books = cat.getBooks();
        assertEquals(b1, books[0]);
        assertEquals(b2, books[1]);
        assertEquals(b3, books[2]);
    }

    /**
     * Test of count method, of class Category.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        Category instance = new Category("Comics");
        int expResult = 0;
        int result = instance.count();
        assertEquals(expResult, result);
        
        Book b1 = new Book("Spiderman", "123", "abc");
        instance.add(b1);
        assertEquals(1, instance.count());
    }
}
