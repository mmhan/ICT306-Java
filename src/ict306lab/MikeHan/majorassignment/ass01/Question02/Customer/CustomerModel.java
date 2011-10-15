/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ict306lab.MikeHan.majorassignment.ass01.Question02.Customer;

import java.util.Arrays;

/**
 *
 * @author mmhan
 */
public class CustomerModel {
    /**
     * Keep count of all the models
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
     * Index
     */
    static int increment = 10;
    
    /**
     * Just initiate this model, with a predicted number of customers
     */
    public CustomerModel(){
        customers = new Customer[increment];
        ids = new int[increment];
    }
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
     **/
    public boolean save(CreditCustomer cust){
        beforeSave();
        customers[count] = cust;
        ids[count] = cust.getId();
        afterSave();
        return true;
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
