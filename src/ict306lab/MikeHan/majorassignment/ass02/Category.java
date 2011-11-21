/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ict306lab.MikeHan.majorassignment.ass02;

/**
 *
 * @author mmhan
 */
public class Category {
    String name;
    public Category(String name){
        this.name = name;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
