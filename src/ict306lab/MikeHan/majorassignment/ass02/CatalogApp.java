package ict306lab.MikeHan.lectures.topic06;

// SimplApp.java
// A simple example of a GUI program to demonstrate the AWT & swing

import javax.swing.*;  		// for JFrame, JButton, JLabel
import java.awt.*;  		// for BorderLayout
import java.awt.event.*;	// for WindowAdapter, ActionListener

public class SimpleApp extends JFrame {

        JLabel infoLabel;
        int counter=0;

      class MyButtonListener implements ActionListener {
      // inner class - implements the interface ActionListener
                public void actionPerformed(ActionEvent e){
                        infoLabel.setText("that's "+(++counter));
                }// end of method actionedPerformed
        } // end of class MyButtonListener

        // constructor for SimplApp objects
        public SimpleApp(String frameTitle){
                super(frameTitle);
                infoLabel=new JLabel("unpressed", JLabel.CENTER);
                // a label with the String centred
                getContentPane().add(infoLabel,
                         BorderLayout.CENTER);	// goes in middle

                JButton dpm= new JButton("Don't Press Me!");
                getContentPane().add(dpm, BorderLayout.NORTH); 	// goes at top
                dpm.addActionListener(new MyButtonListener());

                addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent e) {
                                System.exit(0);
                        } // end of windowClosing()
                }); // end of addWindowListener statement
        } // end of SimplApp constructor

        public static void main(String[] args) {

                SimpleApp app = new SimpleApp("Zzzz");

                app.setSize(700,400);
                app.setVisible(true);

                while (true)
                        System.out.println("From SimplApp.main()");

        } // end of SimplApp.main()

} // end of SimplApp class

// end of SimplApp.java file