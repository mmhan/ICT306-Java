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
     * @param name
     * @param address
     * @param maxAllowed
     * @param ccNumber 
     */
    public CreditCustomer(String name, String address, int maxAllowed, String ccNumber){
        super(name, address, maxAllowed);
        this.ccNumber = ccNumber;
    }
    /**
     * Creates a CreditCustomer out of a normal customer
     * @param customer
     * @param ccNumber 
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
     * @return double 
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * Set the balance of customer
     * @param balance
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }
    
    /**
     * Get the ccNumber of customer
     * @return ccNumber
     */
    public String getCcNumber() {
        return ccNumber;
    }
    
    /**
     * Set the CCNumber of customer
     * @param ccNumber
     */
    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }
    
    /**
     * Add to balance with given amount
     * @param add
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
    
    public boolean returnCopy(int id){
        //the following code is more or less the same with the parent's code
        //it has only been copied anti-patternly due to:
        // 1) The project scope doesn't require it
        // 2) It's much faster to implement it this way. 
        //    (Other than seperating this loop into three: -findKey(), -shiftArray()
        //     and ~getPriceForCopy(id))
        int key = -1;
        for(int i = 0; i < rented; i++){
           if(copies[i].getId() == id){
               key = i;
               //this is the additional code that was added in.
               this.addBalance(copies[key].getTitle().cost);
           }
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
     * To String for this object
     */
    public String toString(){
        String[] array = new String[] {
            Integer.toString(this.id),
            this.name,
            this.address,
            Integer.toString(this.maxAllowed),
            this.getCcNumber(),
            Double.toString(this.balance)
        };
        String ret = super.toString();
        ret += "CC:\t\t\t" + this.getCcNumber() + "\n";
        ret += "Balance:\t\t" + Double.toString(this.balance) + "\n";
        
        return ret;
    }
}
