/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ict306lab.MikeHan.majorassignment.ass01.Question02.Customer;

/**
 *
 * @author mmhan
 */
public class CreditCustomer extends Customer{
    private String ccNumber = "";
    private Double balance = 0.0;
    
    /**
     * Creates an empty CreditCustomer
     */
    public CreditCustomer(){
       super();
    }
    
    /**
     * Creates a CreditCustomer using full info
     */
    public CreditCustomer(String name, String address, int maxAllowed, String ccNumber){
        super(name, address, maxAllowed);
        this.ccNumber = ccNumber;
    }
    /**
     * Creates a CreditCustomer out of a normal customer
     */
    public CreditCustomer(Customer customer, String ccNumber){
        super(customer.name, customer.address, customer.maxAllowed);
        this.ccNumber = ccNumber;
        this.id = customer.id;
    }
    
    /****************
     * Getter and setters
     */
    
    /**
     * Get the balance of customer
     */
    public Double getBalance() {
        return balance;
    }
    
    /**
     * Set the balance of customer
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }
    
    /**
     * Get the ccNumber of customer
     */
    public String getCcNumber() {
        return ccNumber;
    }
    
    /**
     * Set the CCNumber of customer
     */
    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }
    
    /**
     * Add to balance with given amount
     */
    public void addBalance(Double add){
        this.setBalance(this.balance + add);
    }
    
    /**
     * Clear the balance of customer
     */
    public void clearBalance(){
        this.setBalance(0.0);
    }
    
    /**
     * To String for this object
     */
    @Override
    public String toString(){
        String[] array = new String[] {
            Integer.toString(this.id),
            this.name,
            this.address,
            Integer.toString(this.maxAllowed),
            this.getCcNumber(),
            Double.toString(this.balance)
        };
        String ret = "";
        for(int i = 0; i < array.length; i++){
            ret += (array[i] + "\t");
        }
        return ret;
    }
}
