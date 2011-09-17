/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ict306lab.MikeHan.labs.lab01;

/**
 *
 * @author mmhan
 */
public class StudentTest {
    public static void main(String args[]){
        Student[] students = new Student[3];
        students[0] = new Student("Mike", 23);
        students[1] = new Student("Lee", 21);
        students[2] = new Student("Arthur", 19);
        for (int i = 0; i < students.length; i++){
            System.out.printf("Hi, I am %s and I am %d years old.\n", 
                    students[i].getName(), 
                    students[i].getAge());
        }
    }
}
