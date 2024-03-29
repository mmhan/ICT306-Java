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
public class BookModelTest {
    
    private BookModel model = new BookModel();
    
    public BookModelTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        Category c = new Category("Comics");
        Book b1 = new Book("Tin Tin in Moscow", "1234", "Herge");
        b1.setCategory(c);
        model.save(b1);
        
        Book b2 = new Book("Tin Tin in Congo", "1234", "Herge");
        b2.setCategory(c);
        model.save(b2);
        
        Book b3 = new Book("Tin Tin in America", "1234", "Herge");
        b3.setCategory(c);
        model.save(b3);
    }
    
    @After
    public void tearDown() {
        model = new BookModel();
    }

    /**
     * Test of getCount method, of class BookModel.
     */
    @Test
    public void testGetCount() {
        System.out.println("getCount");
        
        int expResult = 3;
        int result = model.getCount();
        assertEquals(expResult, result);
        
        model.save(new Book("Tin Tin - Cigars of the Pharaoh", "5364", "Herge"));
        expResult = 4;
        result = model.getCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of save method, of class BookModel.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Book book = new Book("Tin Tin - Cigars of the Pharaoh", "5364", "Herge");
        boolean expResult = true;
        boolean result = model.save(book);
        assertEquals(expResult, result);
        Book bookResult = model.find(book.getId());
        assertEquals(book, bookResult);
    }

    /**
     * Test of edit method, of class BookModel.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Book book = model.getAll()[0];
        book.isbn = "78910";
        
        boolean result = model.edit(book.getId(), book);
        assertEquals(book, model.find(book.getId()));
    }

    /**
     * Test of getAll method, of class BookModel.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        Book[] result = model.getAll();
        assertEquals(model.getCount(), result.length);
    }

    /**
     * Test of find method, of class BookModel.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        Book newBook = new Book("Tin Tin - Cigars of the Pharaoh", "5364", "Herge");
        model.save(newBook);
        Book result = model.find(newBook.getId());
        assertEquals(newBook, result);
        assertEquals(null, model.find(123541));
    }

    /**
     * Test of delete method, of class BookModel.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = model.getAll()[0].getId();
        boolean result = model.delete(id);
        Book[] books = model.getAll();
        for(int i = 0; i < books.length; i++){
            if(books[i].getId() == id) 
                fail("I shouldn't have found this in storage, after deleting.");
        }
        assertEquals(true, result);
    }

    /**
     * Test of getAllCat method, of class BookModel.
     */
    @Test
    public void testGetAllCat() {
        System.out.println("getAllCat");
        int expResult = 1;
        int result = model.getAllCat().length;
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteCat method, of class BookModel.
     */
    @Test
    public void testDeleteCat() {
        System.out.println("deleteCat");
        Category[] cats = model.getAllCat();
        Category result = model.deleteCat(cats[0]);
        assertEquals(cats[0], result);
        assertTrue(result.books.isEmpty());
    }

    /**
     * Test of findCat method, of class BookModel.
     */
    @Test
    public void testFindCat() {
        System.out.println("findCat");
        String catName = "Comics";
        Category result = model.findCat(catName);
        assertEquals(catName, result.name);
        assertEquals(3, result.getBooks().length);
    }

    /**
     * Test of newCat method, of class BookModel.
     */
    @Test
    public void testNewCat() {
        System.out.println("newCat");
        String c = "Uncategorized";
        boolean expResult = true;
        boolean result = model.newCat(c);
        assertEquals(expResult, result);
        assertEquals(c, model.findCat(c).name);
    }
}
