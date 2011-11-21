package ict306lab.MikeHan.majorassignment.ass02;

// SimplApp.java
// A simple example of a GUI program to demonstrate the AWT & swing

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;  		// for JFrame, JButton, JLabel
import java.awt.*;  		// for BorderLayout
import java.awt.event.*;	// for WindowAdapter, ActionListener

import java.awt.image.BufferedImage;
import javax.swing.event.ListDataListener;
import javax.swing.filechooser.FileFilter;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Catalog app
 * @author mmhan
 */
public class CatalogApp extends JFrame {

    
    
    BooksController con = new BooksController();
    
    CategoriesListPane catList;
    BooksListPane bookList;
    DetailsPane details;
    String libFile;
    
    /**
     * Filter for .lib files.
     */
    class LibFileFilter extends FileFilter{
        
        public boolean accept(File f){
            return f.isDirectory() || f.getName().toLowerCase().endsWith(".lib");
        }

        @Override
        public String getDescription() {
            return "Library File";
        }
    }
        
    /**
     * To Handle to list selections
     */
    class SharedListSelectionHandler implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            JList list = (JList) e.getSource();
            
            if(list.equals(catList.list)){
                catList.onListItemSelected();
            }else{
                bookList.onListItemSelected();
            }
        }
    }
    
    /**
     * For both category and books panels
     */
    abstract class ListPane extends JPanel{
        
        JLabel title;
        JList list;
        DefaultListModel model;
        
        /**
         * Construct pane
         * @param name 
         */
        public ListPane(String name){
            title = new JLabel(name, JLabel.LEFT);
            this.genList();
            this.makeList();
        }
        /**
         * Make a generic list
         */
        public void makeList(){
            //make list
            list = new JList(model);
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            list.setLayoutOrientation(JList.VERTICAL);
            list.setVisibleRowCount(-1);
            JScrollPane listScroller = new JScrollPane(list);
            listScroller.setMinimumSize(new Dimension(200, 50));
            listScroller.setPreferredSize(new Dimension(200, 400));
            listScroller.setAlignmentX(LEFT_ALIGNMENT);
            
            list    
                .addListSelectionListener(new SharedListSelectionHandler());
            
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            
            this.add(title);
            this.add(Box.createRigidArea(new Dimension(0,5)));
            this.add(listScroller);
        }
        /**
         * Updates the UI.
         */
        public void updateUI(){
            this.genList();
            super.updateUI();
        }
        /**
         * To generate the list 
         */
        protected abstract void genList();
        
        /**
         * To be called on every selection change
         */
        public abstract void onListItemSelected();
    }
    /**
     * To list the categories
     */
    class CategoriesListPane extends ListPane{
        
        Category selected;
        
        JLabel lbl;
        JTextField txt;
        JButton btn, selectNoneBtn;
        /**
         * Constructor
         */
        public CategoriesListPane(){
            super("Categories");
        }
        /**
         * To customize the interface
         */
        @Override
        public void makeList(){
            super.makeList();
            selectNoneBtn = new JButton("Select None");
            selectNoneBtn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    catList.list.clearSelection();
                }
            });
            
            lbl = new JLabel("Add New Category", JLabel.LEFT);
            txt = new JTextField(64);
            txt.setMaximumSize(new Dimension(200, 30));
            btn = new JButton("Add");
            btn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    JButton src = (JButton) e.getSource();
                    catList.save(src.getText().equals("Add"));
                }
            });
            
            this.add(Box.createRigidArea(new Dimension(0,5)));
            this.add(selectNoneBtn);
            this.add(Box.createRigidArea(new Dimension(0,5)));
            this.add(lbl);
            this.add(Box.createRigidArea(new Dimension(0,5)));
            this.add(txt);
            this.add(Box.createRigidArea(new Dimension(0,5)));
            this.add(btn);
            this.add(Box.createRigidArea(new Dimension(0,5)));
        }
        /**
         * Called when btn is clicked.
         * 
         * @param isNew 
         */
        public void save(boolean isNew){
            if(isNew){
                con.newCategory(txt.getText());
            }else{
                this.selected.name = txt.getText();
            }
            list.clearSelection();
            this.updateUI();
            details.makeComboxBox();
        }
        
        /**
         * Generates the list
         */
        @Override
        public void genList() {
            if(model == null) model = new DefaultListModel();
            else model.clear();
            
            Category[] cats = con.getAllCategory();
            for(int i = 0; i < cats.length; i++){
                model.addElement(cats[i]);
            }
        }
        /**
         * Called when an item is selected.
         */
        @Override
        public void onListItemSelected() {
            this.selected = (Category) list.getSelectedValue();
            if(this.selected == null){
                this.lbl.setText("Add New Category");
                this.txt.setText("");
                this.btn.setText("Add");
            }else{
                this.lbl.setText("Edit Category");
                this.txt.setText(this.selected.name);
                this.btn.setText("Edit");
            }
            bookList.updateUI();
        }
    }
    /***
     * To create the list of books.
     */
    class BooksListPane extends ListPane{
        
        Book selected;
        
        public BooksListPane(){
            super("Books");
        }
        
        public void genList(){
            try{
                model.clear();

                
            }catch (NullPointerException e){
                model = new DefaultListModel();
            }finally{
                Book[] books;
                try{
                    if(catList.selected == null){
                        this.title.setText("Books");
                        books = con.getAllBooks();
                    }else{
                        this.title.setText("Books : " + catList.selected.name);
                        books = catList.selected.getBooks();
                    }
                    for(int i = 0; i < books.length; i++){
                        model.addElement(books[i]);
                    }
                }catch (NullPointerException e){
                    
                }
            }
        }
        
        public void makeList(){
            super.makeList();
            
            JButton selectNoneBtn = new JButton("Select None");
            selectNoneBtn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    bookList.list.clearSelection();
                }
            });
            
            this.add(Box.createRigidArea(new Dimension(0,5)));
            this.add(selectNoneBtn);
            this.add(Box.createRigidArea(new Dimension(0,5)));
        }
        
        @Override
        public void onListItemSelected() {
            this.selected = (Book) list.getSelectedValue();
            details.update(this.selected);
        }
    }
    /**
     * JPanel of two lists.
     */
    class ListsPane extends JPanel{
        public ListsPane(CategoriesListPane catList, BooksListPane bookList){
            this.setLayout(new GridLayout(1, 2));
            this.add(catList);
            this.add(bookList);
        }
    }
    /**
     * To create the details panel
     */
    class DetailsPane extends JPanel{
        
        Book data;
        
        JTextField title, isbn, author;
        JLabel titleLbl, isbnLbl, authorLbl, catLbl;
        ImageField imgField;
        JButton saveBtn;
        JComboBox cats;
        String[] catsStr;
        
        public DetailsPane(){
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            
            //labels
            Dimension dim = new Dimension(150, 30);
            titleLbl = new JLabel("Title : ");            
            titleLbl.setMinimumSize(dim);
            titleLbl.setMaximumSize(dim);
            isbnLbl = new JLabel("ISBN : ");
            isbnLbl.setMinimumSize(dim);
            isbnLbl.setMaximumSize(dim);
            authorLbl = new JLabel("Author : ");
            authorLbl.setMinimumSize(dim);
            authorLbl.setMaximumSize(dim);
            catLbl = new JLabel("Category : ", JLabel.LEFT);
            catLbl.setMinimumSize(dim);
            catLbl.setMaximumSize(dim);
            
            //fields
            dim = new Dimension(200, 30);
            title = new JTextField(100);
            title.setMinimumSize(dim);
            title.setMaximumSize(dim);
            isbn = new JTextField(100);
            isbn.setMinimumSize(dim);
            isbn.setMaximumSize(dim);
            author = new JTextField(100);
            author.setMinimumSize(dim);
            author.setMaximumSize(dim);
            this.makeComboxBox();
            imgField = new ImageField();
            imgField.setSize(new Dimension(200, 200));
            
            //layouts
            JPanel titlePane = new JPanel();
            titlePane.setLayout(new BoxLayout(titlePane, BoxLayout.X_AXIS));
            titlePane.add(titleLbl); titlePane.add(title);
            
            JPanel isbnPane = new JPanel();
            isbnPane.setLayout(new BoxLayout(isbnPane, BoxLayout.X_AXIS));
            isbnPane.add(isbnLbl); isbnPane.add(isbn);
            
            JPanel authorPane = new JPanel();
            authorPane.setLayout(new BoxLayout(authorPane, BoxLayout.X_AXIS));
            authorPane.add(authorLbl); authorPane.add(author);
            
            JPanel catPane = new JPanel();
            catPane.setLayout(new BoxLayout(catPane, BoxLayout.X_AXIS));
            catPane.add(catLbl); catPane.add(cats);
            
            saveBtn = new JButton("Add");
            saveBtn.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton btn = (JButton) e.getSource();
                    details.save(btn.getText().equals("Add"));
                }
            });
            
            this.setTitle("New Book Details");
            this.add(titlePane);
            this.add(Box.createRigidArea(new Dimension(0,5)));
            this.add(isbnPane);
            this.add(Box.createRigidArea(new Dimension(0,5)));
            this.add(authorPane);
            this.add(Box.createRigidArea(new Dimension(0,5)));
            this.add(catPane);
            this.add(Box.createRigidArea(new Dimension(0,5)));
            this.add(imgField);
            this.add(Box.createRigidArea(new Dimension(0,5)));
            this.add(saveBtn);
            this.add(Box.createRigidArea(new Dimension(0,5)));
            
        }
        
        public void updateUI(){
            if(this.data != null){
                title.setText(data.title);
                isbn.setText(data.isbn);
                author.setText(data.author);
                cats.setSelectedItem(data.getCategory().toString());
                imgField.img.setFile(data.getImageFile());
                this.setTitle("Edit Book Details");
                saveBtn.setText("Edit");
            }else{
                try{
                    title.setText("");
                    isbn.setText("");
                    author.setText("");
                    cats.setSelectedItem(null);
                    imgField.img.clearFile();
                    this.setTitle("New Book Details");
                    saveBtn.setText("Add");
                }catch (NullPointerException e){
                    
                }
            }
            super.updateUI();
        }
        
        public void update(Book data){
            this.data = data;
            this.updateUI();
        }
        
        public void save(boolean isNew){
            if(isNew){
                Book newBook = con.newBook(
                        title.getText(), 
                        isbn.getText(), 
                        author.getText(),
                        (String) cats.getSelectedItem());
                try {
                    newBook.setImageFile(imgField.img.file);
                } catch (IOException ex) {
                    
                }
            }else{
                this.data.title = title.getText();
                this.data.isbn = isbn.getText();
                this.data.author = author.getText();
                //very bad.. must optimize.
                this.data.setCategory(
                        con.getAllCategory()[cats.getSelectedIndex()]);
                
                try {
                    this.data.setImageFile(imgField.img.file);
                } catch (IOException ex) {
                    
                }
                
                con.editBook(this.data.getId(), this.data);
            }
            Book b = null;
            this.update(b);
            bookList.updateUI();
        }
        
        private void setTitle(String str){
            this.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createTitledBorder(str),
                    BorderFactory.createEmptyBorder(5,5,5,5)
                    ));
        }
        
        private void makeComboxBox(){
            Category[] catObjs = con.getAllCategory();
            catsStr = new String[catObjs.length];
            for(int i = 0; i < catObjs.length; i++) 
                catsStr[i] = catObjs[i].toString();
            try{
                cats.setModel(new DefaultComboBoxModel(catsStr));
            }catch(NullPointerException e){
                cats = new JComboBox(new DefaultComboBoxModel(catsStr));
                Dimension dim = new Dimension(200, 30);
                cats.setMaximumSize(dim);
            }
        }
    }
    class ImageField extends JPanel{
        
        ShowImage img;
        JLabel lbl;
        
        public ImageField(){
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            
            Dimension dim = new Dimension(150, 30);
            lbl = new JLabel("Image");
            lbl.setSize(dim);
            
            JButton btn = new JButton("Browse...");
            btn.setSize(dim);
            btn.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton src = (JButton) e.getSource();
                    JFileChooser fc = new JFileChooser();
                    fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                    int returnVal = fc.showOpenDialog(src);
                    if(returnVal == JFileChooser.APPROVE_OPTION){
                        File file = fc.getSelectedFile();
                        img.setFile(file.getPath());
                    }
                }
            });
            
            JPanel pane = new JPanel();
            pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));
            pane.add(lbl);
            pane.add(btn);
            
            img = new ShowImage();
            
            this.add(img);
            this.add(Box.createRigidArea(new Dimension(0,5)));
            this.add(pane);
            
            this.setSize(new Dimension(200, 200));
            this.setMaximumSize(new Dimension(200, 200));
        }
        
        class ShowImage extends JPanel
        {

            BufferedImage image;

            String file;

            public ShowImage(){
            }
            
            public ShowImage(String filename){
                this.setFile(filename);
                this.paint(this.getGraphics());
            }
            
            public void clearFile(){
                file = null;
                image = null;
            }

            public String getFile(){ return file; }

            public void setFile(String filename){
                if(filename == null || filename.isEmpty()){
                    this.clearFile();
                    return;
                }
                
                File input = new File(filename);
                try{
                    image = ImageIO.read(input);
                }catch (IOException e){
                    JOptionPane.showMessageDialog(this, 
                            "Image couldn't be opened",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                file = filename;
                this.paint(this.getGraphics());
            }

            public void paint(Graphics g){
                try{
                    g.drawImage(image, 0, 0, null);
                }catch(NullPointerException e){}
            }
        }
    }
    
    /**
     * constructor for CatalogApp object
     * @param frameTitle
     */
    public CatalogApp(String frameTitle){
        super(frameTitle);
        initLibrary();
        
        catList = new CategoriesListPane();
        bookList = new BooksListPane();
        ListsPane lp = new ListsPane(catList, bookList);
        details = new DetailsPane();
        
        getContentPane().setLayout(new GridLayout(1, 2));
        getContentPane().add(lp);
        getContentPane().add(details);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exitLib();
                System.exit(0);
            } // end of windowClosing()
        }); // end of addWindowListener statement
        
    } // end of SimplApp constructor
    
    private void initLibrary(){
        //Custom button text
        Object[] options = {"Load Existing Library...",
                            "Create New Library...",
                            "Let me play around first!"};
        int n; 
        
        boolean repeat = true;
        while(repeat){
            n = JOptionPane.showOptionDialog(this,
                "Please select an option to load your library",
                "Welcome!",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]);
            
            // boiler plate for filechooser
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            fc.setFileFilter(new LibFileFilter());
            
            //depended on user's choice.
            switch(n){
                case 0:
                    //load existing
                    boolean loadedExisting = this.chooseExisting(fc);
                    repeat = !loadedExisting;
                    break;
                case 1:
                    //create new
                    boolean createdNew = this.createNew(fc, true);
                    repeat = !createdNew;
                    break;
                case 2:
                default:
                    //play around
                    repeat = false;
                    break;
            }
        }
    }
    
    private boolean chooseExisting(JFileChooser fc){
        //load existing
        int returnVal = fc.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile();
            boolean loaded = false;
            try{
                loaded = con.loadLib(file.getPath());
                if(loaded){
                    return true;
                }else{
                    JOptionPane.showMessageDialog(this, 
                        "Selected library can't be loaded.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }catch (IOException e){
                JOptionPane.showMessageDialog(this, 
                        "Selected library can't be loaded.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return false;
    }
    
    private boolean createNew(JFileChooser fc, boolean clearLib){
        int returnVal = fc.showSaveDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile();
            if(!file.getName().toLowerCase().endsWith(".lib")){
                file = new File(file.getPath() + ".lib");
            }
            
            boolean newLib;
            if(clearLib)
                newLib = con.newLib(file.getPath());
            else{
                con.filename = file.getPath();
                newLib = con.saveLib();
            }
            
            if(newLib)
                return true;
        }
        return false;
    }
    
    private void exitLib(){
        //Custom button text
        Object[] options = {"Save",
                            "Save As..",
                            "No, Don't Save"};
        int n; 
        
        boolean repeat = true;
        while(repeat){
            n = JOptionPane.showOptionDialog(this,
                "Do you wanna save your changes?",
                "",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]);
            
            // boiler plate for filechooser
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            fc.setFileFilter(new LibFileFilter());
            
            //depended on user's choice.
            switch(n){
                case 0:
                    //save existing
                    con.saveLib();
                    repeat = false;
                    break;
                case 1:
                    //create new
                    repeat = !this.createNew(fc, false);
                    break;
                case 2:
                default:
                    //play around
                    repeat = false;
                    break;
            }
        }
    }

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        CatalogApp app = new CatalogApp("My Catalog");

        app.setSize(1024,768);
        app.setVisible(true);
    }

} 