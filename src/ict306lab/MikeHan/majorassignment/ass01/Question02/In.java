/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ict306lab.MikeHan.majorassignment.ass01.Question02;

import java.util.Scanner;

/**
 * A helper class for VideoRental system
 * 
 * @author mmhan
 */
public class In {
    
    private static Scanner scan = new Scanner(System.in);
    
    /**
     * This shall only be run for the purpose of testing.
     * 
     * I have checked out the JUnit's way of testing 
     * and I just like this test to be more manual at first.
     * without having to change system.in stream.
     */
    public static void main(String[] args){
        
        System.out.println("getText");
        String expected = "car";
        String result = In.getText("Please enter 'car'.");
        System.out.println(expected.equals(result) ? "Okay" : "Fail");
        
        result = In.getText("Please enter 'back'");
        System.out.println(result == null ? "Okay" : "Fail");
        
        result = In.getText("Please enter 'exit'", false);
        System.out.println(result == null ? "Okay" : "Fail");
        
        System.out.println("getInt");
        int iresult = In.getInt("Enter 1");
        System.out.println(iresult == 1  ? "Okay" : "Fail");
        
        iresult = In.getInt("Enter -1", false);
        System.out.println(iresult == -1  ? "Okay" : "Fail");
        
        System.out.println("getDouble");
        double dblresult = In.getDouble("Enter 1");
        System.out.println(dblresult == 1.0  ? "Okay" : "Fail");
        
        dblresult = In.getDouble("Enter -1", false);
        System.out.println(dblresult == -1.0  ? "Okay" : "Fail");
        
        System.out.println("getChoice");
        iresult = In.getChoice("Choose anything.", 
                new String[]{"A", "B", "C", "D"}, true);
        System.out.println(iresult < 4 && iresult != -1 ? "Okay" : "Fail");
        
        iresult = In.getChoice("Choose to exit", 
                new String[]{"A", "B"} , true);
        System.out.println(iresult == -1 ? "Okay" : "Fail");
    }
    
    /**
     * Will get the text for the question
     * 
     * @param q question to ask
     * @return input or null if the user decides to exit
     */
    public static String getText(String q){
        return In.getText(q, true);
    }
    /**
     * Will get the text for question
     * 
     * @param q         question to ask
     * @param isInMenu  
     * @return          input or null if user decides to exit
     */
    public static String getText(String q, boolean isInMenu){
        System.out.println(q);
        In.printExit(isInMenu);
        String input = In.scan.nextLine();
        if(input.isEmpty()) return In.getText(q, isInMenu);
        if(In.isToExit(isInMenu, input)) return null;
        
        return input;
    }
    /**
     * Get an integer while in menu
     * 
     * @param q
     * @return 
     */
    public static int getInt(String q){
        return In.getInt(q, true);
    }
    /**
     * Get integer as input
     * 
     * @param q         
     * @param isInMenu  
     * @return
     */
    public static int getInt(String q, boolean isInMenu){
        System.out.println(q);
        In.printExitInt(isInMenu);
        int input = In.scan.nextInt();
       
        return input;
    }
    /**
     * Get double as input.
     * @param q
     * @return 
     */
    public static double getDouble (String q){
        return In.getDouble(q, true);
    }
    /**
     * Get double as input
     * @param q 
     * @param isInMenu 
     * @return 
     */
    public static double getDouble(String q, boolean isInMenu){
        System.out.println(q);
        In.printExitInt(isInMenu);
        double input = In.scan.nextDouble();
                
        return input;
    }
    /**
     * Return the choice from an array of choices.
     * @param pre       Instruction before listing choices.
     * @param q         choices
     * @param isInMenu  
     * @return 
     */
    public static int getChoice(String pre, String[] q, boolean isInMenu){
        System.out.println(pre);
        for(int i = 0; i < q.length; i++){
            System.out.println(" [" + (i+1) + "] " + q[i]);
        }
        int input = In.getInt("", isInMenu);
        if(input == -1 ) return input;
        try{
            System.out.println("You chose - " + q[input]);
            return input;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Choice.");
            return In.getChoice(pre, q, isInMenu);
        }
    }
    
    /**
     * To help with exit line.
     * @param isInMenu 
     */
    private static void printExit(boolean isInMenu){
        if(isInMenu){
            System.out.println("\t\t\tOr enter \"back\" to return to previous menu.");
        }else{
            System.out.println("\t\t\tOr enter \"exit\" to exit the program.");
        }
    }
    /**
     * To help with exit line.
     * 
     * @param isInMenu 
     */
    private static void printExitInt(boolean isInMenu){
        if(isInMenu){
            System.out.println("\t\t\tOr enter -1 to return to previous menu.");
        }else{
            System.out.println("\t\t\tOr enter -1 to exit the program.");
        }
    }
    /**
     * To help with exiting
     * 
     * @param isInMenu
     * @param input
     * @return 
     */
    private static boolean isToExit(boolean isInMenu, String input){
        if(isInMenu && input.equals("back")){
            return true;
        }else if(!isInMenu && input.equals("exit")){
            return true;
        }
        return false;
    }
}