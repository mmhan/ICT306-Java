/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ict306lab.MikeHan.majorassignment.ass02;

import java.util.ArrayList;

/**
 *
 * @author mmhan
 */
public class Category {
    /**
     * Name of the category.
     */
    String name;
    /**
     * To remember the books that are in this category.
     */
    ArrayList<Book> books;
    
    /**
     * Constructor
     * 
     * @param name 
     */
    public Category(String name){
        this.name = name;
        this.books = new ArrayList<Book>();
    }
    
    /**
     * Add a book to this category
     * 
     * @param book
     * @return 
     */
    public boolean add(Book book){
        return this.books.add(book);
    }
    
    /**
     * Remove a book from this category
     * 
     * @param book
     * @return 
     */
    public boolean remove(Book book){
        return this.books.remove(book);
    }
    
    /**
     * Get all books of this category
     * 
     * @return 
     */
    public Book[] getBooks(){
        return this.books.toArray(new Book[0]);
    }
    /**
     * Return the number of books this category has.
     * @return  number of books this category has.
     */
    public int count(){
        return this.books.size();
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
