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
    protected Book[] books;
    /**
     * Index of customer id-s.
     */
    protected int[] ids;
    
    /**
     * Storage of categories
     */
    protected Category[] cats;
        
    /**
     * Size of the initial array and also incremental steps
     */
    static int increment = 10;
    
    /**
     * Just initiate this model, with a predicted number of books
     */
    public BookModel(){
        books = new Book[increment];
        ids = new int[increment];
    }
	
	/**
	 * Initiating with given size
     *
     * @param size 
     */
    public BookModel(int size){
        BookModel.increment = size;
        books = new Book[increment];
        ids = new int[increment];
    }
    
    /**
     * Returns the number of books that are stored in the data.
     * @return 
     */
    public int getCount(){
        return count;
    }
    
    /**
     * Gets a new book and saves it in its storage
     * 
     * @param cust
     * @return  
     */
    public boolean save(Book book){
        beforeSave();
        books[count] = book;
        ids[count] = book.getId();
        afterSave();
        return true;
    }
    /**
     * Gets a book and save it 
     * 
     * @param id
     * @param book
     * @return 
     */
    public boolean edit(int id, Book book){
        try{
            books[this.findKey(id)] = book;
        }catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
        return true;
    }
    /**
     * Returns the full list of all books.
     * @return 
     */
    public Book[] getAll(){
        return Arrays.copyOfRange(books, 0, count);
    }
    /**
     * Find the book in storage and returns it.
     * 
     * @param id
     * @return 
     */
    public Book find(int id){
        try{
            return books[this.findKey(id)];
        }catch(ArrayIndexOutOfBoundsException e){
            return null;
        }
    }
    /**
     * Delete the book with given id.
     * 
     * @param id
     * @return 
     */
    public boolean delete(int id){
        try{
            List<Book> list = new ArrayList<Book>(Arrays.asList(books));
            list.remove(books[this.findKey(id)]);
            books = list.toArray(BookModel.EMPTY_BOOKS);
            count--;
            this.reconstructIdsArr();
        }catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
        return true;
    }
    
    /**
     * Find the key of the book in the storage.
     * 
     * @param id
     * @return 
     */
    protected int findKey(int id){
       for(int i = 0; i < count; i++){
            if(ids[i] == id){
                return i;
            }
       }
       return -1;
    }
    
    /**
     * A private method to call before saving
     * 
     * To resize the array of the customers if necessary
     */
    private void beforeSave(){
        if(books.length > count+1) return;
        books =  Arrays.copyOf(books, books.length + increment);
        ids = Arrays.copyOf(ids, ids.length + increment);
    }
    
    /**
     * A private method to call after saving
     * 
     * To keep the count of the customers and other 
     */
    private void afterSave(){
        count++;
    }
    
    /**
     * A private method to call after deleting an item from books array.
     * This will reconstruct the 'ids' array.
     */
    private void reconstructIdsArr(){
        ids = new int[books.length];
        for(int i = 0; i < count; i++){
            ids[i] = books[i].getId();
        }
    }
}
