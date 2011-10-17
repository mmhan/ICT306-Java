/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ict306lab.MikeHan.majorassignment.ass01.Question02.Video;

/**
 *
 * @author mmhan
 */
public class VideoCopy {
    /**
     * A counter to keep incrementing every time a copy is created.
     */
    public static int count;
    
    /**
     * to store id of copy
     */
    protected int id;
    
    /**
     * store its title
     */
    protected VideoTitle title;
    
    /**
     * store if the copy is rented
     */
    protected boolean isRented = false;
    
    /**
     * Constructor of class
     * @param title 
     */
    public VideoCopy(VideoTitle title){
        this.title = title;
        this.id = VideoCopy.generateId();
    }
    
    /**
     * Returns the VideoTitle of this object.
     * @return 
     */
    
    public VideoTitle getTitle(){
        return this.title;
    }
    
    /**
     * Returns ID of this object.
     * @return 
     */
    public int getId(){
        return this.id;
    }
    
    /**
     * Returns the status of object.
     * 
     * @return 
     */
    public boolean isRented(){
        return this.isRented;
    }
    
    /**
     * Set the status of object
     */
    protected void setAsRented(){
        this.isRented = true;
    }
    /**
     * Set the status of the object
     */
    protected void setAsReturned(){
        this.isRented = false;
    }
    /**
     * Generate ID of a video copy
     * 
     * @return 
     */
    protected static int generateId() {
        /** use private static function to generate **/
        return ++count;
    }
    
    /***
     * Overrides and returns a string representation of VideoCopy
     * 
     * @return 
     */
    @Override
    public String toString(){
        String str = "";
        str += this.title.name + " - " 
                + this.title.cost + " - " 
                + this.title.rentalDays + " - " 
                + this.id;
        return str;
    }
}
