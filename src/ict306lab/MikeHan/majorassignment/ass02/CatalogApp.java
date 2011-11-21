package ict306lab.MikeHan.majorassignment.ass02;

// SimplApp.java
// A simple example of a GUI program to demonstrate the AWT & swing

import javax.swing.*;  		// for JFrame, JButton, JLabel
import java.awt.*;  		// for BorderLayout
import java.awt.event.*;	// for WindowAdapter, ActionListener

import javax.swing.filechooser.FileFilter;

import java.io.File;
import java.io.IOException;

public class CatalogApp extends JFrame {

    
    
    BooksController con = new BooksController();
    
    CategoryListPane catList;
    
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
        
//    class MyButtonListener implements ActionListener {
//        // inner class - implements the interface ActionListener
//        public void actionPerformed(ActionEvent e){
//            infoLabel.setText("that's "+(++counter));
//        }// end of method actionedPerformed
//    } // end of class MyButtonListener
    
    class CategoryListPane extends JPanel{
        public CategoryListPane(){
            JLabel label = new JLabel("Categories", JLabel.CENTER);
            this.add(label, BorderLayout.NORTH);
        }
    }
    
    // constructor for CatalogApp object
    public CatalogApp(String frameTitle){
        super(frameTitle);
        initLibrary();
        
        catList = new CategoryListPane();
        getContentPane().add(catList,
                BorderLayout.WEST);
        
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