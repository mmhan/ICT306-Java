/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ict306lab.MikeHan.majorassignment.ass01.Question02.Customer;

import ict306lab.MikeHan.majorassignment.ass01.Question02.Video.VideoCopy;
import java.util.Arrays;

/**
 *
 * @author mmhan
 */
public class CustomerModel {
    /**
     * Keep count of all the customers
     */
    private int count = 0;
    
    /**
     * Storage of customers
     */
    protected GenericCustomer[] customers;
    /**
     * Index of customer id-s.
     */
    protected int[] ids;
    /**
     * Size of the initial array and also incremental steps
     */
    static int increment = 10;
    
    /**
     * Just initiate this model, with a predicted number of customers
     */
    public CustomerModel(){
        customers = new Customer[increment];
        ids = new int[increment];
    }
	
	/**
	 * Initiating with given size
	 **/
    public CustomerModel(int size){
        CustomerModel.increment = size;
        customers = new Customer[increment];
        ids = new int[increment];
    }
    
    /**
     * Returns the number of models that are stored in the data.
     */
    public int getCount(){
        return count;
    }
    
    /**
     * Returns the whole collection of customers in string
     * 
     * @return  a 2d array of customers' names and id
     */
    public String[][] getList(){
        String[][] names = new String[this.count][2];
        for(int i = 0; i < count; i++){
            names[i] = new String[2];
            names[i][0] = this.customers[i].getName();
            names[i][1] = Integer.toString(this.customers[i].getId());
        }
        return names;
    }
    
    /**
     * Returns the rented customers in strings
     * 
     * @return a 2d array of customers who rented something.
     */
     public String[][] getRentedList(){
        String[][] names = new String[this.count][2];
        int rentedCustomers = 0;
        for(int i = 0; i < count; i++){
            if(this.customers[i].getRented() > 0){
                names[i] = new String[2];
                names[i][0] = this.customers[i].getName();
                names[i][1] = Integer.toString(this.customers[i].getId());
                rentedCustomers++;
            }
        }
        String[][] retNames = new String[rentedCustomers][2];
        int retNamesCount = 0;
        for(int i = 0; i < count; i++){
            if(names[i][0] != null){
                retNames[retNamesCount++] = names[i];
            }
        }
        return retNames;
    }
    
    /**
     * Gets a new customer and saves it in its storage
     * 
     */
    public boolean save(Customer cust){
        beforeSave();
        customers[count] = cust;
        ids[count] = cust.getId();
        afterSave();
        return true;
    }
    /**
     * Gets a new Credit Customer and saves it in its storage
	 * 
	 * @return true 	at all time. Develop further to report status
     **/
    public boolean save(CreditCustomer cust){
        beforeSave();
        customers[count] = cust;
        ids[count] = cust.getId();
        afterSave();
        return true;
    }
    /**
     * Find the customer and returns it.
     * 
     * @param id
     * @return 
     */
    public GenericCustomer find(int id){
        return customers[this.findKey(id)];
    }
    
    /***
     * Find the rented videos of the given customer and return.
     * 
     */
    public VideoCopy[] findRentedCopies(int id){
        return find(id).copies;
    }
    /**
     * Find the key of the customer in the storage.
     * 
     * @param id
     * @return 
     */
    protected int findKey(int id){
       for(int i = 0; i < count; i++){
            if(ids[i] == id){
                return i;
            }
       }
       return -1;
    }      
        
    /**
     * A private method to call before saving
     * 
     * To resize the array of the customers if necessary
     */
    private void beforeSave(){
        if(customers.length > count+1) return;
        customers =  Arrays.copyOf(customers, customers.length + increment);
        ids = Arrays.copyOf(ids, ids.length + increment);
    }
    /**
     * A private method to call after saving
     * 
     * To keep the count of the customers and other 
     */
    private void afterSave(){
        count++;
    }
} 
