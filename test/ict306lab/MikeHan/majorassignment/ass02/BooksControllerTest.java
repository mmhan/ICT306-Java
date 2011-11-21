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
import java.io.IOException;
/**
 *
 * @author mmhan
 */
public class BooksControllerTest {
    
    private BooksController con = new BooksController();
    
    public BooksControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        try{
            con.newLib("p://test/testcaseLib.lib");
            con.newBook("Tin Tin in Moscow", "1234", "Herge", "Comics");
            con.newBook("Tin Tin in Congo", "2345", "Herge", "Comics");
            con.newBook("Tin Tin in America", "3456", "Herge", "Comics");
            con.newBook("Assignment 02", "", "Murdoch");
        }catch (IOException e){
            fail("newLib should work.");
        }
    }
    
    @After
    public void tearDown() {
        con = new BooksController();
    }

    /**
     * Test of newLib method, of class BooksController.
     */
    @Test
    public void testNewLib(){
        System.out.println("newLib");
        String filename = "x://bla.lib";
        BooksController instance = new BooksController();
        boolean expResult = false;
        boolean result = false;
        try{
            result = instance.newLib(filename);
        }catch(IOException e){
            assertEquals(expResult, result);
        }
        
        try{
            result = instance.newLib("p://test/test.lib");
            assertTrue(result);
        }catch(IOException e){
            fail("It shouldn't throw exception.");
        }
    }

    /**
     * Test of loadLib method, of class BooksController.
     */
    @Test
    public void testLoadLib(){
        System.out.println("loadLib");
        String filename = "x://bla.lib";
        BooksController instance = new BooksController();
        boolean expResult = false;
        boolean result = false;
        try{
            result = instance.loadLib(filename);
        }catch(IOException e){
            assertEquals(expResult, result);
        }
        
        filename = "p://test/testLoadLib.lib";
        try{
            con.newLib(filename);
            con.saveLib();
        }catch(IOException e){
            fail("saveLib failed me, fix it first.");
        }
        try{
            instance = new BooksController();
            result = instance.loadLib(filename);   
        }catch(IOException e){
            fail("This shouldn't throw an exception");
        }
        assertEquals(con.getAllBooks().length, instance.getAllBooks().length);
        assertTrue(result);
    }

    /**
     * Test of saveLib method, of class BooksController.
     */
    @Test
    public void testSaveLib() {
        System.out.println("saveLib");
        BooksController instance = new BooksController();
        boolean expResult = false;
        boolean result = instance.saveLib();
        assertEquals(expResult, result);
        
        result = false;
        try{
            instance.newLib("x://bla.lib");
            result = instance.saveLib();
        }catch(IOException e){
            assertEquals(expResult, result);
        }        
        
        try{
            instance.newLib("p://test/test.lib");
            instance.saveLib();
        }catch(IOException e){
            fail("This shouldn't throw an exception.");
        }
    }

    /**
     * Test of getAllBooks method, of class BooksController.
     */
    @Test
    public void testGetAllBooks() {
        System.out.println("getAllBooks");
        con.newBook("A2 Guide", "", "Murdoch");
        int expResult = 5;
        Book[] result = con.getAllBooks();
        assertEquals(expResult, result.length);
        assertEquals("A2 Guide", result[result.length - 1].title);
    }

    /**
     * Test of getAllCategory method, of class BooksController.
     */
    @Test
    public void testGetAllCategory() {
        System.out.println("getAllCategory");
        
        int expResult = 2;
        Category[] result = con.getAllCategory();
        assertEquals(expResult, result.length);
        assertEquals(BooksController.UNCAT, result[result.length - 1].name);
    }

    /**
     * Test of getBooksOfCategory method, of class BooksController.
     */
    @Test
    public void testGetBooksOfCategory() {
        System.out.println("getBooksOfCategory");
        Category[] cats = con.getAllCategory();
        Book[] expResult = cats[cats.length - 1].getBooks();
        Book[] result = con.getBooksOfCategory(cats[cats.length - 1]);
        assertEquals(expResult, result);
    }

    /**
     * Test of newBook method, of class BooksController.
     */
    @Test
    public void testNewBook_3args() {
        System.out.println("newBook");
        String name = "Harry Potter I";
        String isbn = "789";
        String author = "J. K. Rowling";
        
        Book result = con.newBook(name, isbn, author);
        assertEquals(name, result.title);
        assertEquals(isbn, result.isbn);
        assertEquals(author, result.author);
        assertEquals(BooksController.UNCAT, result.getCategory().name);
    }

    /**
     * Test of newBook method, of class BooksController.
     */
    @Test
    public void testNewBook_4args() {
        System.out.println("newBook");
        String name = "Harry Potter II";
        String isbn = "789";
        String author = "J. K. Rowling";
        String catStr = "Fiction";
        
        Book result = con.newBook(name, isbn, author, catStr);
        assertEquals(name, result.title);
        assertEquals(isbn, result.isbn);
        assertEquals(author, result.author);
        assertEquals(catStr, result.getCategory().name);
        
    }

    /**
     * Test of editBook method, of class BooksController.
     */
    @Test
    public void testEditBook() {
        System.out.println("editBook");
        Book[] books = con.getAllBooks();
        Book b = books[0]; //in moscow
        b.author = "Hergeeee";
        b.setCategory(books[books.length - 1].getCategory());
        
        boolean expResult = true;
        boolean result = con.editBook(b.getId(), b);
        assertEquals(expResult, result);
        
        Book bEdited = con.getAllBooks()[0];
        assertEquals(b, bEdited);
    }

    /**
     * Test of newCategory method, of class BooksController.
     */
    @Test
    public void testNewCategory() {
        System.out.println("newCategory");
        
        boolean expResult = true;
        boolean result = con.newCategory("Horror");
        assertEquals(expResult, result);
        assertEquals(3, con.getAllCategory().length);
    }
}
