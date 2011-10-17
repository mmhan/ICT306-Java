package ict306lab.MikeHan.majorassignment.ass01.Question02.Customer;

import ict306lab.MikeHan.majorassignment.ass01.Question02.Video.VideoCopy;
import java.util.Arrays;

/**
 * 
 * @author mmhan
 */
public class Customer extends GenericCustomer{
    
    /**
     * 
     */
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
    public String getAddress() {
        return address;
    }
    /**
     * set the address of customer
     * 
     * @param address 
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * Get id of a customer
     * 
     * @return 
     */
    public int getId() {
        return id;
    }
    /**
     * Generate ID of a customer
     * 
     * @return  
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
    
    public int getMaxAllowed() {
        return maxAllowed;
    }
    /**
     * Set max number of videos allowed to rent
     * 
     * @param maxAllowed 
     */
    
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
    
    public String getName() {
        return name;
    }
    /**
     * Set name of customer 
     * 
     * @param name 
     */
    
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Returns the number of videos rented.
     * 
     * @return  rented.
     */
    
    public int getRented(){
        return this.rented;
    }
    
    /**
     * Will add the copy to the rented list.
     * 
     * @param copy 
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
     * @param id
     * @return  
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
    
    public String toString(){
        String str = "";
        str += "==================================\n";
        str += "Customer Info\n";
        str += "==================================\n";
        str += "ID:\t\t\t" + Integer.toString(this.id) + "\n";
        str += "Name:\t\t\t" + this.name+ "\n";
        str += "Address:\t\t" + this.address+ "\n";
        str += "Max Allowed:\t\t" + this.getMaxAllowed()+ "\n";
        str += "Rented Videos:\t\t" + this.rented + "\n";
        if(this.rented > 0){
            str += "\t===Rented Videos==========\n";
            for(int i = 0; i < this.rented; i++){
                str +="\t" + this.copies[i].toString() + "\n";
            }
        }
        return str;
    }
}
