/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ict306lab.MikeHan.majorassignment.ass01.Question02;

import ict306lab.MikeHan.majorassignment.ass01.Question02.Customer.CreditCustomer;
import ict306lab.MikeHan.majorassignment.ass01.Question02.Customer.Customer;
import ict306lab.MikeHan.majorassignment.ass01.Question02.Customer.CustomerModel;
import ict306lab.MikeHan.majorassignment.ass01.Question02.Video.VideoModel;
import ict306lab.MikeHan.majorassignment.ass01.Question02.Video.VideoTitle;


/**
 *
 * @author mmhan
 */
public class VideoRental {
    public static void main(String[] args){
        VideoRentalController abc = new VideoRentalController("ABC");
    }
    
    
}

class VideoRentalController{
    private String name = "";
    private VideoModel catalog;
    private CustomerModel customers;
    public VideoRentalController(String name){
        this.name = name;
        this.catalog = new VideoModel(10);
        this.customers = new CustomerModel(10);
        
        this.vWelcome();
        this.cMainMenu();
    }
    /**
     * A view for welcome
     */
    private void vWelcome(){
        Cli.out(
            "=============================================================\n" +
            "Welcome to " + this.name + " Video Rental\n" +
            "============================================================="
        );
        Cli.pause();
        //In.choice("Please select one of the options.", q, true);
    }
    /**
     * Handles view side of the MainMenu
     * @return 
     */
    private int vMainMenu(){
        String[] choices = new String[]{
            "List all titles",
            "Add New Title",
            "List all customers",
            "Add New Customer",
            "Rent Video",
            "Return Video",
            "Import Test Data"
        };
        return Cli.choice("Please choose an action.", choices, false);
    }
    /**
     * Controls controller side of MainMenu
     * @return 
     */
    private void cMainMenu(){
        int choice = this.vMainMenu();
        while(choice != -1){
            switch(choice){
                case 0: //List all titles
                    this.cListAllTitles();
                    break;
                case 1: //Add New Title
                    this.cAddNewTitle();
                    break;
                case 2: //List all Customers
                    break;
                case 3: //Add new Customer
                    break;
                case 4: //Rent Video
                    break;
                case 5: //Return Video
                    break;
                case 6: //Import Test Data
                    this.cImportTestData();
                    break;
                default:
                    continue;
            }
            if(choice != -1) choice = this.vMainMenu();
        }
    }
    
    /*************************************
     * Option 1 - List all titles
     */
    /**
     * View to list all titles.
     */
    private int vListAllTitles(String[][] titles){
        String[] titleStr =  new String[titles.length];
        for(int i = 0; i < titles.length ; i++){
            titleStr[i] = titles[i][0] + " (" + titles[i][1] + ")";
        }
        int choice = Cli.choice(
                "All available titles are listed below. \n"
                + "Please enter the number that belongs "
                + "to the title to see the details.\n"
                + "Title Name <id> (Available Number of Copies) \n"
                + "============================================", 
                titleStr, true);
        return choice;
    }
    /**
     * Controller to list all titles
     */
    private void cListAllTitles(){
        String[][] titles = catalog.findAllTitles();
        int choice = this.vListAllTitles(titles);
        while(choice != -1){
            cListTitle(titles[choice][0]);
            choice = this.vListAllTitles(titles);
        }
    }
    /**
     * Controller to list the given title
     * @param id 
     */
    private void cListTitle(String title){
        VideoTitle titleObj = catalog.findTitle(title);
        Cli.out(titleObj.toString());
        Cli.pause();
    }
    
    /*************************************
     * Option 2 - Add new titles
     *
     * The controller for adding new title.
     * 
     * There will not be any view for this to make it less complicated
     * 
     * TODO: develop this further to let user take a step back.
     */
    private void cAddNewTitle(){
        //Get string
        String iName = Cli.str("Please enter the name of the new title.");
        if(iName == null) return;
        
        //get double
        double cost = Cli.dbl("Please enter the cost of the title per day."
                + "(In decimal number)");
        if(cost == -1) return;
        
        //get int
        int rentalDays = Cli.num("Please enter the number of days"
                + " the title is allowed to be rented.");
        if(rentalDays == -1) return;
        
        //get int
        int copies = Cli.num("Please enter the number of copies"
                + " to add to catalog");
        if(copies == -1) return;
        
        boolean save = catalog.save(iName, cost, rentalDays, copies);
        if(save){
            Cli.out("New title: '" + iName + "' is successfully created.");
            Cli.pause();
        }else{
            Cli.out("Error: There seems to be a problem in creating the new title."
                    + "Please try again.");
            cAddNewTitle();
        }
    }
    /*************************************
     * Option 3 - List all Customers
     */
    private void cListAllCustomers(){
        customers.getList();
    }
    /*************************************
     * Option 4 - Add new Customers
     */
    /*************************************
     * Option 5 - Rent Video
     */
    /*************************************
     * Option 6 - Return Video
     */
    /*************************************
     * Option 7 - Import Test Data
     */
    private void cImportTestData(){
        if(Cli.confirm("Are you sure you want to import test data?\n" +
                "This will clear all the data you may have created.") != true)
            return;
        
        Cli.out("Importing Test data now.");
        customers.save(new Customer("John", "101 Main Street", 3));
        customers.save(new Customer("Cindy", "102 Main Street", 4));
        customers.save(new Customer("Mark", "21 Side Street", 5));
        customers.save(new CreditCustomer("Marcus", "1 Central Road", 7, "1234"));
        customers.save(new CreditCustomer("Mary", "21 Beach Road", 7, "5678"));
        customers.save(new CreditCustomer("Gary", 
                "42 Filthy Rich Avenue", 8, "9123"));
        Cli.out("Imported " + customers.getCount() + " customers.");
        
        catalog.save("Horrible Bosses", 2, 1, 2);
        catalog.save("Green Lantern", 3, 1, 3);        
        Cli.out("Imported " + catalog.getTitleCount() +" titles, and" +
                " a total of " + catalog.getCopiesCount() +" copies.");
        Cli.pause();
    }
}