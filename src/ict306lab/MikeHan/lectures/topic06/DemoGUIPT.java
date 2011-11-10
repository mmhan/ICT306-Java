/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ict306lab.MikeHan.lectures.topic06;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author wengchew
 */
public class DemoGUIPT {
    public static void main(String[] args) {
        // TODO code application logic here
        MyFrame app = new MyFrame();
        app.setSize(400,500);
        app.setVisible(true);
    }
}
class MyFrame extends JFrame{
    Container cp = getContentPane();
    JPanel menuP, detailP, resultP;
    JButton addObjB, addCatB, submitObjB;
    JLabel label1, label2;
    JTextField nameT, dateT;
    
    class ShowAddObjListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            ShowAddObj();
        }
    }
    
    MyFrame()
    {
        super("My Application");//set the title
        menuP = new JPanel(); 
        detailP = new JPanel(); 
        resultP = new JPanel(); 
        
        resultP.setBackground(Color.LIGHT_GRAY);
        menuP.setBackground(Color.BLUE);
        cp.setLayout(new BorderLayout());
        cp.add(menuP, BorderLayout.NORTH);               
        cp.add(detailP, BorderLayout.CENTER);
        cp.add(resultP, BorderLayout.SOUTH);
        ShowMenu();
        ShowAddObj();
        
        addWindowListener
        (
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e)
                    {
                        System.exit(0);
                    }
                }
        );
    }
    void ShowMenu(){
        addObjB = new JButton("Add Object");
        addCatB = new JButton("Add Category");
        menuP.setLayout(new FlowLayout());
        menuP.add(addObjB);
        menuP.add(addCatB);
        addObjB.addActionListener(new ShowAddObjListener());
        
    }
    void ShowAddObj(){
        
        detailP.removeAll();
        
        label1 = new JLabel("NAme:", JLabel.LEFT);
        label2 = new JLabel("Date:", JLabel.LEFT);        
        nameT = new JTextField (50);
        dateT = new JTextField (8);
        submitObjB = new JButton("Submit");
        detailP.setLayout(new GridLayout(3,2));       
        detailP.add(label1);
        detailP.add(nameT);
        detailP.add(label2);
        detailP.add(dateT);
        detailP.add(submitObjB);
        
        detailP.setVisible(false);
        detailP.setVisible(true);
    }
}
