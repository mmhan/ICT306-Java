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
public class VideoModelTest {
    
    private VideoModel model;
    
    public VideoModelTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        model = new VideoModel();
        model.save("Cars 2", 3.5, 1, 5);
        model.save("Cars", 2, 3, 5);
        model.save("Wall-E", 1.5, 4, 5);
    }
    
    @After
    public void tearDown() {
        model = null;
    }

    /**
     * Test of getTitleCount method, of class VideoModel.
     */
    @Test
    public void testGetTitleCount() {
        System.out.println("getTitleCount");
        int expResult = 3;
        int result = model.getTitleCount();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getCopiesCount method, of class VideoModel.
     */
    @Test
    public void testGetCopiesCount_0args() {
        System.out.println("getCopiesCount - no argument");
        int expResult = 15;
        int result = model.getCopiesCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCopiesCount method, of class VideoModel.
     */
    @Test
    public void testGetCopiesCount_VideoTitle() {
        System.out.println("getCopiesCount - Title given");        
        int expResult = 0;
        int result = model.getCopiesCount(new VideoTitle("Bla", 2, 2));
        assertEquals(expResult, result);
        
        expResult = 5;
        result = model.getCopiesCount(model.titles[0]);
        assertEquals(expResult, result);
        
        expResult = 5;
        result = model.getCopiesCount(new VideoTitle("Cars", 2, 3));
        assertEquals(expResult, result);
    }

    /**
     * Test of getCopiesCount method, of class VideoModel.
     */
    @Test
    public void testGetCopiesCount_String() {
        System.out.println("getCopiesCount");
        String title = "";
        int expResult = 0;
        int result = model.getCopiesCount(title);
        assertEquals(expResult, result);
        
        expResult = 5;
        result = model.getCopiesCount("Cars");
        assertEquals(expResult, result);
    }

    /**
     * Test of save method, of class VideoModel.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        String title = "Shrek";
        double cost = 2.0;
        int rentalDays = 5;
        int copies = 3;
        int expTitleCount = model.getTitleCount() + 1;
        int expCopiesCount = model.getCopiesCount() + 3;
        
        VideoTitle expTitle = new VideoTitle(title, cost, rentalDays);
        
        model.save(title, cost, rentalDays, copies);
        
        assertEquals(expTitleCount, model.getTitleCount());
        assertEquals(expCopiesCount, model.getCopiesCount());
        assertEquals(expTitle, model.titles[model.getCopiesCount() - 1]);
    }

    /**
     * Test of findTitleKey method, of class VideoModel.
     */
    @Test
    public void testFindTitleKey() {
        System.out.println("findTitleKey");
        int expResult = 0;
        int result = model.findTitleKey("Cars 2");
        
        assertEquals(expResult, result);
    }
}
