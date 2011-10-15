package ict306lab.MikeHan.majorassignment.ass01.Question02.Customer;

/**
 * This is a generic customer class to hold the data of a customer.
 * 
 * @author mmhan
 */
public class Customer {
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
     * Generate ID of a customer and set it to customer
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
    public int getMaxAllowed() {
        return maxAllowed;
    }
    /**
     * Set max number of videos allowed to rent
     * 
     * @param maxAllowed 
     */
    public void setMaxAllowed(int maxAllowed) {
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
     * Return the number of customers that has been generated. 
     * This is not an accurate counter. 
     * It merely serves as auto-increment of MySQL and 
     * will not account for deleted objects
     * 
     * @return 
     */
    private static int getCount(){
        return Customer.count;
    }
    
    /**
     * Will return a string representation of a customer.
     * 
     * @return string
     */
    @Override
    public String toString(){
        String[] array = new String[] {
            Integer.toString(this.id), 
            this.name, 
            this.address, 
            Integer.toString(this.maxAllowed)
        };
        String str = "";
        for(int i = 0; i < array.length; i++){
            str += (array[i] + "\t");
        }
        return str;
    }
}
