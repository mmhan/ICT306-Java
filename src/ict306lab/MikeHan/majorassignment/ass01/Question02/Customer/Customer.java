package ict306lab.MikeHan.majorassignment.ass01.Question02.Customer;

import ict306lab.MikeHan.majorassignment.ass01.Question02.Video.VideoCopy;
import java.util.Arrays;

/**
 * This is a generic customer class to hold the data of a customer.
 * 
 * @author mmhan
 */
abstract class GenericCustomer{
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
    @Override
    public abstract String toString();
}

public class Customer extends GenericCustomer{
    
    public boolean isOverMax = false;
    
    /**
     * Initialize an empty customer with no values.
     */
    public Customer() {
        this.id = Customer.generateId();
    }
    
    /**
     * Initialize a new Customer 
     * 
     * @param name          Name of customer
     * @param address       Address of customer
     * @param maxAllowed    maximum number of copies that a customer is 
     *                      allowed to rent
     */
    public Customer(String name, String address, int maxAllowed) {
        this.name = name;
        this.address = address;
        this.maxAllowed = maxAllowed;
        this.copies = new VideoCopy[maxAllowed];
        this.id = Customer.generateId();
    }
    /**
     * Get the address of the customer
     * 
     * @return address of customer
     */
    @Override
    public String getAddress() {
        return address;
    }
    /**
     * set the address of customer
     * 
     * @param address 
     */
    @Override
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * Get id of a customer
     * 
     * @return 
     */
    @Override
    public int getId() {
        return id;
    }
    /**
     * Generate ID of a customer
     * 
     * @param id 
     */
    protected static int generateId() {
        /** use private static function to generate **/
        return ++count;
    }
    /**
     * Get maximum rental of copies allowed.
     * 
     * @return maxAllowed 
     */
    @Override
    public int getMaxAllowed() {
        return maxAllowed;
    }
    /**
     * Set max number of videos allowed to rent
     * 
     * @param maxAllowed 
     */
    @Override
    public void setMaxAllowed(int maxAllowed) {
        if(this.rented > maxAllowed){
            //if Customer has rented more copies at the moment remember to
            //change the array size when customer return.
            this.isOverMax = true;
        }else if(this.copies != null){
            this.copies = Arrays.copyOf(this.copies, maxAllowed);
        }else{
            this.copies = new VideoCopy[maxAllowed];
        }
        this.maxAllowed = maxAllowed;
    }
    /**
     * Get name of customer
     * 
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }
    /**
     * Set name of customer 
     * 
     * @param name 
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Returns the number of videos rented.
     * 
     * @return  rented.
     */
    @Override
    public int getRented(){
        return this.rented;
    }
    
    /**
     * Will add the copy to the rented list.
     * 
     * @param   VideoCopy
     * @return  boolean for the status
     */
    public boolean rent(VideoCopy copy){
        
        //if more than max don't allow
        if(maxAllowed <= rented){
            return false;
        }
        
        //if user is over limit, don't allow
        //we could easily use isOverMax flag to detect
        //this is just a fancier way to introduce try...catch
        try{    
            copies[rented] = copy;
            rented++;
            return true;
        }catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
    }
    
    /**
     * Will return video 
     */
    public boolean returnCopy(int id){
        int key = -1;
        for(int i = 0; i < rented; i++){
           if(copies[i].getId() == id) key = i;
           if(key != -1){
               //shift all copies a place up
               try{
                   copies[i - 1] = copies[i];
               }catch (ArrayIndexOutOfBoundsException e){
                   //looks like this is the first copy in the array
                   //do nothing.
               }               
               copies[i] = null;
           }
        }
        if(key != -1){
            rented--;
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Will return a string representation of a customer.
     * 
     * @return string
     */
    @Override
    public String toString(){
        String str = "";
        str += "==================================\n";
        str += "Customer Info\n";
        str += "==================================\n";
        str += "ID:\t\t\t" + Integer.toString(this.id) + "\n";
        str += "Name:\t\t\t" + this.name+ "\n";
        str += "Address:\t\t" + this.address+ "\n";
        str += "Max Allowed:\t\t" + this.getMaxAllowed()+ "\n";
        str += "Rented:\t\t\t" + this.rented + "\n";
        return str;
    }
}
