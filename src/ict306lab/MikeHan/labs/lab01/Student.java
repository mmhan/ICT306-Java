/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ict306lab.MikeHan.labs.lab01;

import java.util.Date;

/**
 *
 * @author mmhan
 */
public class Student {
    String name;
    int age;
    char sex;

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}
