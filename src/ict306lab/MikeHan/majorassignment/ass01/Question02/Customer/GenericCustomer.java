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
    
    public abstract String getAddress();
    public abstract void setAddress(String address);
    public abstract int getId();
    public abstract int getMaxAllowed();
    public abstract void setMaxAllowed(int maxAllowed);
    public abstract String getName();
    public abstract void setName(String name);
    public abstract int getRented();
    public abstract boolean rent(VideoCopy copy);
    public abstract boolean returnCopy(int id);
    @Override
    public abstract String toString();
}