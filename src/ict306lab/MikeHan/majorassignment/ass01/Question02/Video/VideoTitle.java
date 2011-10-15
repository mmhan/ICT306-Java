/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ict306lab.MikeHan.majorassignment.ass01.Question02.Video;

/**
 *
 * @author mmhan
 */
public class VideoTitle {
    /**
     * Stores the name of the title
     */
    public String name = "";
    /**
     * Stores the cost of rental per day.
     */
    public double cost = 0.0;
    /**
     * Stores the allowable rental days.
     */
    public int rentalDays = 0;
    /**
     * Creates a title with given parameters.
     * 
     * @param name          Name of the title.
     * @param cost          Cost of the title.
     * @param rentalDays    Maximum allowable days to rent out.
     */
    public VideoTitle(String name, double cost, int rentalDays){
        this.name = name;
        this.cost = cost;
        this.rentalDays = rentalDays;
    }
}
