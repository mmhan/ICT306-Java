/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ict306lab.MikeHan.majorassignment.ass02;

import java.io.IOException;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.NotSerializableException;

/**
 *
 * @author mmhan
 */
public class BooksController {
    
    public static final String UNCAT = "Uncategorized";
    
    /**
     * ref to model
     */
    private BookModel Book;
    /**
     * Ref to filename of lib.
     */
    private String filename;
    
    public BooksController(){
        Book = new BookModel();
    }
    
    /**
     * Creates new library at given filename
     * 
     * @param   filename
     * @return  
     * @throws IOException 
     */
    public boolean newLib(String filename) throws IOException{
        if(FileHelper.isWritable(filename)){
            this.filename = filename;
            return true;
        }else{
            return false;
        }
    }
    /**
     * Load a library from given filename.
     * 
     * @param filename
     * @return
     * @throws IOException 
     */
    public boolean loadLib(String filename) throws IOException{
        ObjectInputStream input = 
                new ObjectInputStream(new FileInputStream(filename));
        try {
            Book = (BookModel) input.readObject();
            return true;
        } catch (NotSerializableException e){
            e.printStackTrace();
            return false;
        } catch (EOFException e){
            return false;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
    /**
     * Save current version of library 
     * 
     * @return 
     */
    public boolean saveLib(){
        if(filename == null) return false;
        
        try {
            ObjectOutputStream output = 
                    new ObjectOutputStream(new FileOutputStream(filename));
            output.writeObject(Book);
            output.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    public Book[] getAllBooks(){
        return this.Book.getAll();
    }
    
    public Category[] getAllCategory(){
        return this.Book.getAllCat();
    }
    
    public Book[] getBooksOfCategory(Category c){
        return c.getBooks();
    }
    
    public Book newBook(String name, String isbn, String author){
        return this.newBook(name, isbn, author, BooksController.UNCAT);
    }
    
    public Book newBook(String name, String isbn, String author, String catStr){
        Book b = new Book(name, isbn, author);
        Category cat = this.Book.findCat(catStr);
        if(cat == null){
            cat = new Category(catStr);
        }
        b.setCategory(cat);
        this.Book.save(b);
        return b;
    }
    
    public boolean editBook(int id, Book book){
        return Book.edit(id, book);
    }
    
    public boolean newCategory(String cat){
        return Book.newCat(cat);
    }
}
