package ict306lab.MikeHan.majorassignment.ass02;

// SimplApp.java
// A simple example of a GUI program to demonstrate the AWT & swing

import javax.swing.*;  		// for JFrame, JButton, JLabel
import java.awt.*;  		// for BorderLayout
import java.awt.event.*;	// for WindowAdapter, ActionListener

import javax.swing.filechooser.FileFilter;

import java.io.File;
import java.io.IOException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CatalogApp extends JFrame {

    
    
    BooksController con = new BooksController();
    
    CategoriesListPane catList;
    BooksListPane bookList;
    DetailsPane details;
    
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
        
        public ListPane(String name){
            title = new JLabel(name, JLabel.LEFT);
            this.genList();
            this.makeList();
        }
        
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
        
        public void updateUI(){
            this.genList();
            super.updateUI();
        }
        
        protected abstract void genList();
        
        
        public abstract void onListItemSelected();
    }
    
    class CategoriesListPane extends ListPane{
        
        Category selected;
        
        JLabel lbl;
        JTextField txt;
        JButton btn, selectNoneBtn;
        
        public CategoriesListPane(){
            super("Categories");
        }
        
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
        
        public void save(boolean isNew){
            if(isNew){
                con.newCategory(txt.getText());
            }else{
                this.selected.name = txt.getText();
            }
            list.clearSelection();
            this.updateUI();
        }
        
        @Override
        public void genList() {
            if(model == null) model = new DefaultListModel();
            else model.clear();
            
            Category[] cats = con.getAllCategory();
            for(int i = 0; i < cats.length; i++){
                model.addElement(cats[i]);
            }
        }
        
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
    
    class ListsPane extends JPanel{
        public ListsPane(CategoriesListPane catList, BooksListPane bookList){
            this.setLayout(new GridLayout(1, 2));
            this.add(catList);
            this.add(bookList);
        }
    }
    
    class DetailsPane extends JPanel{
        
        Book data;
        
        JTextField title, isbn, author;
        JLabel titleLbl, isbnLbl, authorLbl;
        JButton saveBtn;
        
        
        public DetailsPane(){
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            
            Dimension dim = new Dimension(150, 0);
            titleLbl = new JLabel("Title : ");            
            titleLbl.setMinimumSize(dim);
            isbnLbl = new JLabel("ISBN : ");
            isbnLbl.setMinimumSize(dim);
            authorLbl = new JLabel("Author : ");
            authorLbl.setMinimumSize(dim);
            
            
            
            title = new JTextField(100);
            isbn = new JTextField(100);
            author = new JTextField(100);
            
            JPanel titlePane = new JPanel();
            titlePane.setLayout(new BoxLayout(titlePane, BoxLayout.X_AXIS));
            titlePane.add(titleLbl); titlePane.add(title);
            
            JPanel isbnPane = new JPanel();
            isbnPane.setLayout(new BoxLayout(isbnPane, BoxLayout.X_AXIS));
            isbnPane.add(isbnLbl); isbnPane.add(isbn);
            
            JPanel authorPane = new JPanel();
            authorPane.setLayout(new BoxLayout(authorPane, BoxLayout.X_AXIS));
            authorPane.add(authorLbl); authorPane.add(author);
            
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
            this.add(saveBtn);
            this.add(Box.createRigidArea(new Dimension(0,5)));
        }
        
        public void updateUI(){
            if(this.data != null){
                title.setText(data.title);
                isbn.setText(data.isbn);
                author.setText(data.author);
                this.setTitle("Edit Book Details");
                saveBtn.setText("Edit");
            }else{
                try{
                    title.setText("");
                    isbn.setText("");
                    author.setText("");
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
                        author.getText());
            }else{
                this.data.title = title.getText();
                this.data.isbn = isbn.getText();
                this.data.author = author.getText();
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
    }
    
    // constructor for CatalogApp object
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
        
        /**
        infoLabel=new JLabel("unpressed", JLabel.CENTER);
        // a label with the String centred
        getContentPane().add(infoLabel,
                 BorderLayout.CENTER);	// goes in middle

        JButton dpm= new JButton("Don't Press Me!");
        getContentPane().add(dpm, BorderLayout.NORTH); 	// goes at top
        dpm.addActionListener(new MyButtonListener());
         *  
         * */

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
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
                    boolean createdNew = this.createNew(fc);
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
    
    private boolean createNew(JFileChooser fc){
        int returnVal = fc.showSaveDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile();
            if(!file.getName().toLowerCase().endsWith(".lib")){
                file = new File(file.getPath() + ".lib");
            }

            boolean newLib = con.newLib(file.getPath());
            if(newLib)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CatalogApp app = new CatalogApp("My Catalog");

        app.setSize(700,400);
        app.setVisible(true);
    } // end of SimplApp.main()

} // end of SimplApp class

// end of SimplApp.java file