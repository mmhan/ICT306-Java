/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ict306lab.MikeHan.labs.chapter03;

/**
 * GradeBook class that contains a courseName instance variable
 * and methods to set and get its value.
 * 
 * @author mmhan
 */
public class GradeBook {
    private String courseName;  //course name for this GradeBook
    
    //method to set the course name
    public void setCourseName(String name){
        this.courseName = name;
    }
    //method to get the course name
    public String getCourseName(String name){
        return courseName;
    }
    
    //display a welcome message to the GradeBook user
    public void displayMessage(){
        System.out.printf("Welcome to the grade book for \n%s\n", courseName);
    }
    
}
