/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ict306lab.MikeHan.majorassignment.ass02;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Model of books and category, this is a modified version of CustomerModel from
 * assignment 1. 
 *  
 * @author mmhan
 */
public class BookModel implements Serializable{
    
    /**
     * empty array
     */
    private static final Book[] EMPTY_BOOKS = new Book[0];
    
    /**
     * Keep count of all the books
     */
    private int count = 0;
    
    /**
     * Storage of books
     */
    protected ArrayList<Book> books;
    /**
     * Index of customer id-s.
     */
    protected ArrayList<Integer> ids;
    
    /**
     * Storage of categories
     */
    protected Category[] cats;
    
    
    /**
     * Just initiate this model, with a predicted number of books
     */
    public BookModel(){
        books = new ArrayList<Book>();
        ids = new ArrayList<Integer>();
    }
	
	/**
	 * Initiating with given size
     *
     * @param size 
     */
    public BookModel(int size){
        books = new ArrayList<Book>(size);
        ids = new ArrayList<Integer>(size);
    }
    
    /**
     * Returns the number of books that are stored in the data.
     * @return 
     */
    public int getCount(){
        return books.size();
    }
    
    /**
     * Gets a new book and saves it in its storage
     * 
     * @param cust
     * @return  
     */
    public boolean save(Book book){
        if(books.add(book)){
            ids.add(new Integer(book.getId()));
            return true;
        }else{
            return false;
        }
    }
    /**
     * Gets a book and save it 
     * 
     * @param id
     * @param book
     * @return 
     */
    public boolean edit(int id, Book book){
        int i = ids.indexOf(new Integer(id));
        if(i == -1) return false;
        Book bookInStorage = books.get(i);
        bookInStorage = book;
        return true;
    }
    /**
     * Returns the full list of all books.
     * @return 
     */
    public Book[] getAll(){
        return books.toArray(BookModel.EMPTY_BOOKS);
    }
    
    /**
     * Find the book in storage and returns it.
     * 
     * @param id
     * @return 
     */
    public Book find(int id){
        int i = ids.indexOf(new Integer(id));
        if(i == -1) return null;
        return books.get(i);
    }
    /**
     * Delete the book with given id.
     * 
     * @param id
     * @return 
     */
    public boolean delete(int id){
        
        int i = ids.indexOf(id);
        if(i == -1) return false;
        try{
            books.remove(i);
            ids.remove(new Integer(id));
            return true;
        }catch(IndexOutOfBoundsException e){
            return false;
        }
    }
}
