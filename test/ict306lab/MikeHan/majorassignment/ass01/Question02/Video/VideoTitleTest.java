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
public class VideoTitleTest {
    
    public VideoTitleTest() {
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
   
    @Test
    public void testConstructor_WithArgs(){
        System.out.println("Testing constructor with arguments");
        VideoTitle instance = new VideoTitle("Cars", 2.0, 3);
        assertEquals("Cars", instance.name);
        assertTrue(instance.cost == 2.0);
        assertEquals(3, instance.rentalDays);
    }
}
