package ict306lab.MikeHan.majorassignment.ass02;

/**
 * This is an entity class for Book objects
 * 
 * @author mmhan
 */
public class Book {
    /**
     * Counter for generation of ID
     */
    public static int counter = 0;
    /**
     * ID to identify the book of the catalog
     */
    private int id;
    /**
     * Title of the book
     */
    public String title = "";
    /**
     * ISBN number of the book
     */
    public String isbn = "";
    /**
     * Name of the author.
     */
    public String author = "";
    /**
     * name of the note file that was uploaded.
     */    
    private String notesFile = "";
    /**
     * name of the image file
     */
    private String imageFile = "";

    
    /**
     * This is the function to generate the id.
     * 
     * @return
     */
    protected static int getNextId(){
        return ++Book.counter;
    }
            
    /**
     * Constructor of Book minimum constructor
     */
    public Book() {
        this.id = Book.getNextId();
    }
    /***
     * Constructor of Book with all parameters
     * 
     * @param title
     * @param isbn
     * @param author 
     */
    public Book(String title, String isbn, String author){
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    /**
     * Return the id of the book
     * 
     * @return  id of book
     */
    public int getId() {
        return id;
    }

    /**
     * Return the image of the book
     * 
     * @return  string name of image file.
     */
    public String getImageFile() {
        return imageFile;
    }

    /**
     * Return the name of the notes file.
     * 
     * @return  string name of notes file.
     */
    public String getNotesFile() {
        return notesFile;
    }

    /**
     * Sets the image file of cover
     * 
     * @param imageFile
     */
    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    /**
     * Sets the notes file of Book
     * 
     * @param notesFile
     */
    public void setNotesFile(String notesFile) {
        this.notesFile = notesFile;
    }
    
}
