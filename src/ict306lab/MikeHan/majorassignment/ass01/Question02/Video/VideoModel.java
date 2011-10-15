/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ict306lab.MikeHan.majorassignment.ass01.Question02.Video;

import java.util.Arrays;

/**
 *
 * @author mmhan
 */
public class VideoModel {
    /**
     * Keep count of all the VideoTitles
     */
    private int titlesCount = 0;
    
    /**
     * Storage of all the video titles
     */
    protected VideoTitle[] titles;
    
    /**
     * Index of all the titles
     */
    protected String[] titleIndex; 
      
    /**
     * Keep count of all the copies
     */
    private int copiesCount = 0;
    /**
     * Storage of all the video copies
     */
    protected VideoCopy[] copies;
    
    /**
     * Index of video copy id
     */
    protected int[] copyIds;
    
    /**
     * Size of the initial array and also incremental steps
     */
    static int increment = 10;
    
    /**
     * Just initiate this model, with a predicted number of customers
     */
    public VideoModel(){
        titles = new VideoTitle[increment];
        titleIndex = new String[increment];
        //Cos there could be multiple copies of videos
        copies = new VideoCopy[increment * 5];
        copyIds = new int[increment * 5];
    }
    /**
     * Initiating with given size
     **/
    public VideoModel(int size){
        VideoModel.increment = size;
        titles = new VideoTitle[increment];
        titleIndex = new String[increment];
        //Cos there could be multiple copies of videos
        copies = new VideoCopy[increment * 5];
        copyIds = new int[increment * 5];
    }
    /**
     * Returns the number of models that are stored in the data.
     */
    public int getTitleCount(){
        return titlesCount;
    }
    /**
     * Returns the number of models that are stored in the data.
     */
    public int getCopiesCount(){
        return copiesCount;
    }
    
    /**
     * Return the copies count of a certain title in the data
     * 
     * @param VideoTitle    
     */
    public int getCopiesCount(VideoTitle title){
        int count = 0;
        for(int i = 0; i < copiesCount; i++){
            if(copies[i].getTitle().equals(title)) count++;
        }
        return count;
    }
    
    /**
     * Will find the copies count of a certain title in the data
     * @param   title
     * @return  count of title.
     */
    public int getCopiesCount(String title){
        //TODO: implement this after getTitleKey
        //return this.getCopiesCount(null);
        return 0;
    }
    /**
     * Using given parameters add new video titles and its copies to storage
     * 
     * @param title
     * @param cost
     * @param rentalDays
     * @param copies
     * @return      always returns true, develop further for error reporting
     */
    public boolean save(String title, double cost, int rentalDays, int copies){
        //find key of title, if can't find, add to storage
        int key = this.findTitleKey(title);
        if(key == -1){
            this.saveTitle(title, cost, rentalDays);
            key = titlesCount - 1;
        }
        //use the titles[index] to create new copies
        for(int i = 0; i < copies; i++){
            this.saveCopy(new VideoCopy(titles[key]));
        }
        //add all the copies to storage
        return true;
    }
    /**
     * Using given parameters to save title to storage
     * 
     * @param title
     * @param cost
     * @param rentalDays
     * @return          always return true develop further for error reporting.
     */
    private boolean saveTitle(String title, double cost, int rentalDays){
        this.beforeTitleSave();
        VideoTitle newTitle = new VideoTitle(title, cost, rentalDays);
        this.titles[titlesCount] = newTitle;
        this.titleIndex[titlesCount] = newTitle.name;
        this.afterTitleSave();        
        return true;
    }
    /***
     * Add copy to storage
     * @param copy
     * @return          always return true develop further for error reporting.
     */
    private boolean saveCopy(VideoCopy copy){
        this.beforeCopySave();
        this.copies[copiesCount] = copy;
        this.copyIds[copiesCount] = copy.id;
        this.afterCopySave();
        return true;
    }
    /**
     * To find the key of the title in titles
     * @param title
     * @return 
     */
    protected int findTitleKey(String title){
        for(int i = 0; i < titlesCount; i++){
            if(titleIndex[i].equals(title)){
                return i;
            }
       }
       return -1;
    }
    
    /**
     * A private method to call before saving title
     * 
     * To resize the array of the titles if necessary
     */
    private void beforeTitleSave(){
        if(titles.length > titlesCount +1) return;
        titles =  Arrays.copyOf(titles, titles.length + increment);
        titleIndex = Arrays.copyOf(titleIndex, titleIndex.length + increment);
    }
    /**
     * A private method to call after saving title
     * 
     * To keep the count of the titles and other 
     */
    private void afterTitleSave(){
        titlesCount++;
    }
    
    /**
     * A private method to call before saving copy
     * 
     * To resize the array of the copies if necessary
     */
    private void beforeCopySave(){
        if(copies.length > copiesCount +1) return;
        copies =  Arrays.copyOf(copies, copies.length + increment * 5);
        copyIds = Arrays.copyOf(copyIds, copyIds.length + increment * 5);
    }
    /**
     * A private method to call after saving copy
     * 
     * To keep the count of the copies and other 
     */
    private void afterCopySave(){
        copiesCount++;
    }
}
