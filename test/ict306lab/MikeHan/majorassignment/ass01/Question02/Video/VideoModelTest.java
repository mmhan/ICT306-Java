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
    public void testFindCopiesCount_String() {
        System.out.println("getCopiesCount");
        String title = "";
        int expResult = 0;
        int result = model.findCopiesCount(title);
        assertEquals(expResult, result);
        
        expResult = 5;
        result = model.findCopiesCount("Cars");
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

    /**
     * Test of getCopiesCount method, of class VideoModel.
     */
    @Test
    public void testGetCopiesCount() {
        System.out.println("getCopiesCount");
        int expResult = 15;
        int result = model.getCopiesCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of findCopiesCount method, of class VideoModel.
     */
    @Test
    public void testFindCopiesCount() {
        System.out.println("findCopiesCount");
        int expResult = 5;
        int result = model.findCopiesCount("Cars");
        assertEquals(expResult, result);
    }

    /**
     * Test of findAvailableCopyCount method, of class VideoModel.
     */
    @Test
    public void testFindAvailableCopyCount() {
        System.out.println("findAvailableCopyCount");
        int expResult = 4;
        String nameToFind = model.copies[0].getTitle().name;
        model.copies[0].setAsRented();
        int result = model.findAvailableCopyCount(nameToFind);
        assertEquals(expResult, result);
    }

    /**
     * Test of findAllTitles method, of class VideoModel.
     */
    @Test
    public void testFindAllTitles() {
        System.out.println("findAllTitles");
        String[][] expResult = new String[][]{
            new String[]{"Cars 2", "5"},
            new String[]{"Cars", "5"},
            new String[]{"Wall-E", "5"}
        };
        String[][] result = model.findAllTitles();
        for(int i = 0; i < 3; i++){
            assertEquals(expResult[i], result[i]);
        }
    }

    /**
     * Test of getCopyFor method, of class VideoModel.
     */
    @Test
    public void testGetCopyFor() {
        System.out.println("getCopyFor");
        
        boolean setRented = true;
        VideoCopy result = model.getCopyFor("Cars 2", setRented);
        assertEquals(setRented, result.isRented());
    }

    /**
     * Test of findTitle method, of class VideoModel.
     */
    @Test
    public void testFindTitle() {
        System.out.println("findTitle");
        VideoTitle result = model.findTitle("Cars 2");
        assertEquals("Cars 2", result.name);
    }
}
