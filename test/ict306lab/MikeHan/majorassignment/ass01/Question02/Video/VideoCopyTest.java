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
        System.out.println("Const");
        int expResult = 0;
        int result = VideoCopy.generateId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitle method, of class VideoCopy.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        VideoCopy instance = null;
        VideoTitle expResult = null;
        VideoTitle result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
}
