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
public class FileHelperTest {
    
    public FileHelperTest() {
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
     * Test of isReadable method, of class FileHelper.
     */
    @Test
    public void testIsReadable() {
        System.out.println("isReadable");
        boolean result = false;
        try{
            result = FileHelper.isReadable("p://test/nofile.txt");
        }catch(IOException e){
            assertEquals(false, result);
        }
        try{
            result = FileHelper.isReadable("p://test/test.txt");
            assertEquals(true, result);
        }catch (IOException e){
        }        
    }

    /**
     * Test of isReadableImage method, of class FileHelper.
     */
    @Test
    public void testIsReadableImage() {
        System.out.println("isReadableImage");
        boolean result = false;
        try{
            result = FileHelper.isReadableImage("p://test/nofile.jpg");
        }catch(IOException e){
            assertEquals(false, result);
        }
        try{
            result = FileHelper.isReadableImage("p://test/test.jpg");
            assertEquals(true, result);
        }catch (IOException e){
        }
    }

    /**
     * Test of isWritable method, of class FileHelper.
     */
    @Test
    public void testIsWritable() {
        System.out.println("isWritable");
        boolean result = false;
        
        try{
            result = FileHelper.isWritable("x://test/write.txt"); //non-existent drive
            fail("Should have thrown exception");
        }catch (IOException e){
            
        }
        try{
            result = FileHelper.isReadableImage("p://test/write.txt");
            assertEquals(true, result);
        }catch(IOException e){
            fail("Shouldn't throw exception");
        }
    }
}
