/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ict306lab.MikeHan.majorassignment.ass02;

import ict306lab.MikeHan.majorassignment.ass01.Question02.Cli;
import java.io.IOException;

/**
 *
 * @author mmhan
 */
public class CatalogCLI {
    public static void main(String[] args){
        CatalogView v = new CatalogView();
        Cli.out("Buh-Bye");
    }
}

class CatalogView{
    private BooksController con = new BooksController();

    public CatalogView(){
        this.welcome();

        if(!lib()) return;

        this.mainMenu();
    }

    private void welcome(){
        Cli.out(
            "=============================================================\n" +
            "Welcome to your books catalog \n" +
            "============================================================="
        );
        Cli.pause();
    }

    private boolean lib(){
        int choice = this.printLib();
        while(
                choice != -1 && //exit
                choice != 42    //success
        ){
            switch(choice){
                case 0: //load
                    String str = Cli.str("Please enter file path of your library.", true);
                    if(str == null){
                        choice = this.printLib();
                        break;
                    }
                    try{
                        boolean loadLib = con.loadLib(str);
                        if(loadLib){
                            choice = 42;
                            break;
                        }else{
                            Cli.out("Couldn't load library please try again.");
                            break;
                        }
                    }catch (IOException e){
                        Cli.out("Couldn't load library please try again.");
                        break;
                    }
                case 1: //new
                    String strNew = Cli.str("Please enter file path for your new library", true);
                    if(strNew == null){
                        choice = this.printLib();
                        break;
                    }
                    try{
                        boolean newLib = con.newLib(strNew);
                        if(newLib){
                            choice = 42;
                            break;
                        }else{
                            Cli.out("Couldn't create library please try again.");
                            break;
                        }
                    }catch (IOException e){
                        Cli.out("Couldn't create library please try again.");
                        break;
                    }
            }
        }
        return choice == 42;
    }
    private int printLib(){
        return Cli.choice("Do you wish to load your library?", new String[]{
            "Load",
            "New",
        }, false);
    }


    private void mainMenu(){
        int choice = this.printMainMenu();
        while(choice != -1){
            switch(choice){
                case 0: //List all cats
                    this.allCats();
                    break;
                case 1: //Add New cat
                    break;
                case 2: //List all books
                    
                    break;
                case 3: //Add new book
                    
                    break;
                default:
                    continue;
            }
            if(choice != -1) choice = this.printMainMenu();
        }
    }
    private int printMainMenu(){
        String[] choices = new String[]{
            "List all categories",
            "New category",
            "List all books",
            "New book"
        };
        return Cli.choice("Please choose an action.", choices, false);
    }
    
    /*========================================
     * Choice #1 - All categories.
     *========================================*/
    
    /**
     * Show list of all category
     */
    private void allCats(){
        Category[] cat = con.getAllCategory();
        String[] choices = this.catsToString(cat);
        int choice = printAllCats(
                "Here's a list of all categories"
                + "\nSelect a number to view details of a category.",
                choices);
        while(choice != -1){
            this.catDetails(cat[choice]);
            choice = printAllCats(
                "Here's a list of all categories"
                + "\nSelect a number to view details of a category.",
                choices);
        }
        
    }
    /**
     * Print category list.
     * @param q
     * @return 
     */
    private int printAllCats(String pre, String[] q){
        return Cli.choice(
                pre
                , q, true);
    }
    /**
     * Will show details of a category
     * 
     * @param cat 
     */
    private void catDetails(Category cat){
        Book[] books = cat.getBooks();
        String[] choices = booksToString(books);
        int choice = printAllBooks(
                "Here's a list of all books under " + cat.name ,
                choices);
        while(choice != -1){
            this.bookDetails(books[choice]);
        }
    }
    /**
     * Will print a list of books and return the choice
     * @param q
     * @return 
     */
    private int printAllBooks(String pre, String[] q){
        return Cli.choice(
                pre
                + "\nSelect a number to view details of a book"
                , q, true);
    }
    /**
     * Will handle book details section.
     * 
     * @param b 
     */
    private void bookDetails(Book b){
        int choice = printBookDetails(b);
        while(choice != -1){
            switch(choice){
                case 0: //edit
                    this.bookInput(b);
                    break;
                case 1: //delete
                    if(con.deleteBook(b.getId())){
                        Cli.out("Book successfully deleted");
                        Cli.pause();
                        choice = -1;
                    }else{
                        Cli.out("Couldn't delete book. Please try again.");
                        Cli.pause();
                    }
                    break;
            }
            if(choice != -1){
                choice = printBookDetails(b);
            }
        }
    }
    /**
     * Will print details of a book.
     * 
     * @param b
     * @return 
     */
    private int printBookDetails(Book b){
        Cli.out(b.toString());
        return Cli.choice(
                "Please select an action", 
                new String[]{
                    "Edit",
                    "Delete"
                }, 
                true);
    }
    
    private void bookInput(Book b){
        String title, isbn, author, cat = null;
        Category[] cats = con.getAllCategory();
        boolean isNew = b == null;
        
        int i = -1;
        //allow for "back" options
        try{
            title = Cli.str(
                    "Enter a title for the book."
                    + ((isNew) ? "" : "\nCurrent title : " + b.title)) ;
            title = title.trim();
            isbn = Cli.str(
                    "Enter ISBN of the book."
                    + ((isNew) ? "" : "\nCurrent ISBN : " + b.isbn));
            isbn = isbn.trim();
            author =  Cli.str(
                    "Enter author of the book."
                    + ((isNew) ? "" : "\nCurrent author : " + b.author));
            author = author.trim();
            
            //category
            boolean chooseCat = Cli.confirm(
                    "Do you wish to select a category for the book?"
                    + ((isNew) ? "" : "\nCurrent category : " 
                        + b.getCategory().name));
            if(chooseCat){
                i = this.printAllCats(
                        "Please select a category. "
                        + "\nSelecting -1 will skip this step."
                        , this.catsToString(cats));
                if(i != -1)
                    cat = cats[i].name;
            }
        }catch (NullPointerException e){
            return;
        }
        
        //edit now.
        if(isNew){
            if(cat == null){
                b = con.newBook(title, isbn, author);
            }else{
                b = con.newBook(title, isbn, author, cat);
            }
        }else{
            b.title = title;
            b.isbn = isbn;
            b.author = author;
            if(i != -1){
                b.setCategory(cats[i]);
            }
        }
        
        boolean editImage = Cli.confirm(
                "Do you wish to add image to this book?"
                + (
                    b.getImageFile().length() == 0 ? ""
                    : "Current Image : " + b.getImageFile()
                ));
        if(editImage){
            boolean tryAgain = true;
            while(tryAgain){
                try{
                    String file = Cli.str("Please input filename for this book.");
                    b.setImageFile(file);
                }catch (IOException e){
                    tryAgain = Cli.confirm("Invalid filename, do you want to try again?");
                    continue;
                }catch (NullPointerException e){
                    tryAgain = false;
                }
                tryAgain = false;
            }
        }
        
        boolean editNotes = Cli.confirm(
                "Do you wish to add image to this book?"
                + (
                    b.getNotesFile().length() == 0 ? ""
                    : "Current Image : " + b.getNotesFile()
                ));
        if(editNotes){
            boolean tryAgain = true;
            while(tryAgain){
                try{
                    String file = Cli.str("Please input filename for this book.");
                    b.setNotesFile(file);
                }catch (IOException e){
                    tryAgain = Cli.confirm("Invalid filename, do you want to try again?");
                    continue;
                }catch (NullPointerException e){
                    tryAgain = false;
                }
                tryAgain = false;
            }
        }
    }
    
    /**
     * Will create a list of category for menu
     * 
     * @param cats
     * @return 
     */
    private String[] catsToString(Category[] cats){
        String[] choices = new String[cats.length];
        for(int i = 0; i < cats.length; i++){
            choices[i] = cats[i].name;
        }
        return choices;
    }
    
    /**
     * Will create a list of books for menu
     * @param books
     * @return 
     */
    private String[] booksToString(Book[] books){
        String[] choices = new String[books.length];
        for(int i = 0; i < books.length; i++){
            choices[i] = books[i].title;
        }
        return choices;
    }
}
