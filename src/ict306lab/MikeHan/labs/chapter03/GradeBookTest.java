/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ict306lab.MikeHan.labs.chapter03;

import java.util.Scanner;

/**
 * This class is used to run the Gradebook
 * @author mmhan
 */
public class GradeBookTest {
    //main method
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        
        GradeBook myGradeBook = new GradeBook("Bla");
        
        myGradeBook.setCourseName(input.nextLine());
        System.out.println();
        
        myGradeBook.displayMessage();
    }
}
