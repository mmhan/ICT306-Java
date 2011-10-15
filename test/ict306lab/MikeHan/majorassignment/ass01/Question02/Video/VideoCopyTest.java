/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ict306lab.MikeHan.majorassignment.ass01.Question02.Video;

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
public class VideoCopyTest {
    
    public VideoCopyTest() {
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
     * Test of generateId method, of class VideoCopy.
     */
    @Test
    public void testConstructor() {
        System.out.println("Constructor");
        int expResult = VideoCopy.count + 1;
        int result = VideoCopy.generateId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitle method, of class VideoCopy.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        VideoTitle expResult = new VideoTitle("LOTR", 2.5, 2);
        VideoCopy instance = new VideoCopy(expResult);
        
        VideoTitle result = instance.getTitle();
        assertEquals(expResult.name, result.name);
    }

    /**
     * Test of generateId method, of class VideoCopy.
     */
    @Test
    public void testGenerateId() {
        System.out.println("generateId");
        int expResult = VideoCopy.count + 1;
        int result = VideoCopy.generateId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class VideoCopy.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        VideoCopy instance = new VideoCopy(new VideoTitle("Title", 2.0, 1));
        int expResult = VideoCopy.count;
        int result = instance.getId();
        assertEquals(expResult, result);
    }
}
