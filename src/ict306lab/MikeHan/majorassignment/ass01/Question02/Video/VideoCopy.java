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
    
    protected int id;
    
    protected VideoTitle title;
    
    public VideoCopy(VideoTitle title){
        this.title = title;
        this.id = VideoCopy.generateId();
    }
    
    public VideoTitle getTitle(){
        return this.title;
    }
    
    public int getId(){
        return this.id;
    }
    
    /**
     * Generate ID of a video copy
     * 
     * @param id 
     */
    protected static int generateId() {
        /** use private static function to generate **/
        return ++count;
    }
}
