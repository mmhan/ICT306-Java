/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ict306lab.MikeHan.labs.chapter01;

import java.util.Scanner;

/**
 *
 * @author mmhan
 * 
 */
public class Addition {
    //main method begins excution of Java app
    public static void main(String args[]){
        //create a scanner to obtain inut from the command line
        Scanner input = new Scanner(System.in);
        
        int number1, number2, sum;
        System.out.println("Gimme two quick numbers to add:");
        number1 = input.nextInt();
        number2 = input.nextInt();
        
        sum = number1 + number2;
        
        System.out.printf("The sum of %d and %d is %d\n", number1, number2, sum);
    }
}
