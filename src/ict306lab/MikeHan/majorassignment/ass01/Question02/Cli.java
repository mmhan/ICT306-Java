/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ict306lab.MikeHan.majorassignment.ass01.Question02;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A helper Command Line Interface class for VideoRental system
 * 
 * @author mmhan
 */
public class Cli {
    
    private static Scanner scan = new Scanner(System.in);
    
    /**
     * This shall only be run for the purpose of testing.
     * 
     * I have checked out the JUnit's way of testing 
     * and I just like this test to be more manual at first.
     * without having to change system.in stream.
     * 
     * @param args
     */
    public static void main(String[] args){
        
        Cli.out("confirm");
        Cli.out(Cli.confirm("Select Yes.")? "Okay" : "Fail");
        Cli.out(!Cli.confirm("Select No.")? "Okay" : "Fail");
        Cli.out(!Cli.confirm("Select something else.")? "Okay" : "Fail");
        
        
        Cli.out("str");
        String expected = "car";
        String result = Cli.str("Please enter 'car'.");
        Cli.out(expected.equals(result) ? "Okay" : "Fail");
        
        result = Cli.str("Please enter 'back'");
        Cli.out(result == null ? "Okay" : "Fail");
        
        result = Cli.str("Please enter 'exit'", false);
        Cli.out(result == null ? "Okay" : "Fail");
        
        Cli.out("int");
        int iresult = Cli.num("Enter 1");
        Cli.out(iresult == 1  ? "Okay" : "Fail");
        
        iresult = Cli.num("Enter -1", false);
        Cli.out(iresult == -1  ? "Okay" : "Fail");
        
        Cli.out("double");
        double dblresult = Cli.dbl("Enter 1");
        Cli.out(dblresult == 1.0  ? "Okay" : "Fail");
        
        dblresult = Cli.dbl("Enter -1", false);
        Cli.out(dblresult == -1.0  ? "Okay" : "Fail");
        
        Cli.out("choice");
        iresult = Cli.choice("Choose anything.", 
                new String[]{"A", "B", "C", "D"}, true);
        Cli.out(iresult < 4 && iresult != -1 ? "Okay" : "Fail");
        
        iresult = Cli.choice("Choose to exit", 
                new String[]{"A", "B"} , true);
        Cli.out(iresult == -1 ? "Okay" : "Fail");
    }
    
    /**
     * Will simply output text
     * @param out text to output
     */
    public static void out(String out){
        System.out.println(out);
    }
    /**
     * Will output text with > character
     * 
     * @param out       text to output
     * @param isPrompt  to prompt or not
     */
    public static void out(String out, boolean isPrompt){
        Cli.out(out);
        if(isPrompt) Cli.prompt();
    }
    /**
     * Will wait for user to press enter first.
     */
    public static void pause(){
        Cli.out("Press enter to continue");
        Cli.prompt();
        Cli.scan.nextLine();
    }
    
    /**
     * Will output prompt
     */
    public static void prompt(){
        System.out.print("> ");
    }
    /**
     * Will get the boolean for the question
     * @param q  question to ask
     * @return boolean
     */
    public static boolean confirm(String q){
        Cli.out(q + "\t y/n", true);
        String str = Cli.scan.nextLine();
        if(str.isEmpty()) str = Cli.scan.nextLine();
        char chr = str.charAt(0);
        if(chr == 'n'){
            return false;
        }else if(chr == 'y'){
            return true;
        }else{
            Cli.out("Invalid character " + chr);
            return Cli.confirm(q);
        }
    }
    /**
     * Will get the text for the question
     * 
     * @param q question to ask
     * @return input or null if the user decides to exit
     */
    public static String str(String q){
        return Cli.str(q, true);
    }
    /**
     * Will get the text for question
     * 
     * @param q         question to ask
     * @param isInMenu  
     * @return          input or null if user decides to exit
     */
    public static String str(String q, boolean isInMenu){
        Cli.out(q);
        Cli.printExit(isInMenu);
        Cli.prompt();
        String input = Cli.scan.nextLine();
        if(input.isEmpty()) return Cli.str(q, isInMenu);
        if(Cli.isToExit(isInMenu, input)) return null;
        
        return input;
    }
    /**
     * Get an integer while in menu
     * 
     * @param q
     * @return 
     */
    public static int num(String q){
        return Cli.num(q, true);
    }
    /**
     * Get integer as input
     * 
     * @param q         
     * @param isInMenu  
     * @return
     */
    public static int num(String q, boolean isInMenu){
        Cli.out(q);
        Cli.printExitInt(isInMenu);
        Cli.prompt();
        int input;
        try{
            input = Cli.scan.nextInt();
        }catch (InputMismatchException e){
            Cli.scan.nextLine();
            return Cli.num(q, isInMenu);
        }
        Cli.scan.nextLine();
        return input;
    }
    /**
     * Get double as input.
     * @param q
     * @return 
     */
    public static double dbl(String q){
        return Cli.dbl(q, true);
    }
    /**
     * Get double as input
     * @param q 
     * @param isInMenu 
     * @return 
     */
    public static double dbl(String q, boolean isInMenu){
        Cli.out(q);
        Cli.printExitInt(isInMenu);
        Cli.prompt();
        double input = Cli.scan.nextDouble();
        try{
            input = Cli.scan.nextDouble();
        }catch (InputMismatchException e){
            Cli.scan.nextLine();
            return Cli.dbl(q, isInMenu);
        }
        return input;
    }
    /**
     * Return the choice from an array of choices.
     * @param pre       Instruction before listing choices.
     * @param q         choices
     * @param isInMenu  
     * @return 
     */
    public static int choice(String pre, String[] q, boolean isInMenu){
        Cli.out(pre);
        for(int i = 0; i < q.length; i++){
            Cli.out(" [" + (i+1) + "] " + q[i]);
        }
        int input = Cli.num("", isInMenu) - 1;
        //bool expression is compensated for indexing.
        if(input == -2) return -1;
        
        try{
            Cli.out("You chose - " + q[input]);
            return input;
        }catch (ArrayIndexOutOfBoundsException e){
            Cli.out("Invalid Choice.");
            return Cli.choice(pre, q, isInMenu);
        }
    }
    
    /**
     * To help with exit line.
     * @param isInMenu 
     */
    private static void printExit(boolean isInMenu){
        if(isInMenu){
            Cli.out("\t\t\tOr enter \"back\" to return to previous menu.");
        }else{
            Cli.out("\t\t\tOr enter \"exit\" to exit the program.");
        }
    }
    /**
     * To help with exit line.
     * 
     * @param isInMenu 
     */
    private static void printExitInt(boolean isInMenu){
        if(isInMenu){
            Cli.out("\t\t\tOr enter -1 to return to previous menu.");
        }else{
            Cli.out("\t\t\tOr enter -1 to exit the program.");
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