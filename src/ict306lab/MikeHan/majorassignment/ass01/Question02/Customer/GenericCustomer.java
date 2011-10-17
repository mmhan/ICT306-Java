/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ict306lab.MikeHan.majorassignment.ass01.Question02.Customer;

import ict306lab.MikeHan.majorassignment.ass01.Question02.Video.VideoCopy;

/**
 *
 * @author mmhan
 */
/**
 * This is a generic customer class to hold the data of a customer.
 * 
 * @author mmhan
 */
public abstract class GenericCustomer{
    /**
     * To keep count of the number of customers created to
     * assist auto-generating the id,
     * Not an actual representation of how many customers is in existence.
     */
    protected static int count = 0;
    /**
     * To store the id of the customer.
     */
    protected int id;
    /**
     * To store the name of Customer.
     */
    protected String name = "";
    /**
     * To store the address of Customer
     */
    protected String address = "";
    /**
     * To store the maximum number of videos that a customer is allowed to rent
     * at the same time.
     */
    protected int maxAllowed = 0;
    /**
     * To store the video copies rented by a customer.
     */
    protected VideoCopy[] copies;
    /**
     * To store the number of videos rented.
     */
    protected int rented = 0;
    
    /**
     * This should return the address
     * @return
     */
    public abstract String getAddress();
    /**
     * Should set address
     * @param address
     */
    public abstract void setAddress(String address);
    /**
     * Should get ID of customer.
     * @return
     */
    public abstract int getId();
    /**
     * Should get maxAllowed rentals
     * @return
     */
    public abstract int getMaxAllowed();
    /**
     * should set maxAllowed
     * @param maxAllowed
     */
    public abstract void setMaxAllowed(int maxAllowed);
    /**
     * should get Name
     * @return
     */
    public abstract String getName();
    /**
     * should set name
     * @param name
     */
    public abstract void setName(String name);
    /**
     * Should get num of rented copies
     * @return
     */
    public abstract int getRented();
    /**
     * should perform rent operation
     * @param copy
     * @return
     */
    public abstract boolean rent(VideoCopy copy);
    /**
     * should return the copy
     * @param id
     * @return
     */
    public abstract boolean returnCopy(int id);
    public abstract String toString();
}