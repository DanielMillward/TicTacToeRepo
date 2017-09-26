/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
Change the three top icons to line
pause for a second
display win screen
Problem: thread is taking precedence in every method it's in 
 */
package tictactoe;
import java.awt.*;
import static java.awt.BorderLayout.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *  O GOES FIRST
 * Just need to fix the making of a new scene and stuff, but otherwise this thing is good to go!
 * @author Daniel Millward <Daniel.Millward at Nominal.ga>
 */
public class GUIClass{
    ImageIcon BlankIcon = this.createImageIcon("/tictactoe/resources/Blank image.png", "a thing"); // blank image
    ImageIcon OIcon = this.createImageIcon("/tictactoe/resources/O image.png", "a thing"); // O image
    ImageIcon XIcon = this.createImageIcon("/tictactoe/resources/X image.png", "a thing"); // X image
    JButton[] Squares = new JButton[9];
   ButtonListener ButtonListener = new ButtonListener();
     JFrame MyFrame = new JFrame();
     Container MyPane = MyFrame.getContentPane();
     JPanel MyPanel = new JPanel(); 
     JPanel TopPanel = new JPanel();
     JPanel BottomPanel = new JPanel();
     JLabel WinnerLabel = new JLabel();

     
     
     
     
  // So the changes have been made, if this shows up for github
public void WinActions(boolean WhichOne){

    
//    System.out.println("you won dude!"); 
//  
//    MyPanel.setLayout(new FlowLayout());
//           MyPanel.removeAll();
//           MyPanel.revalidate();
//           MyPanel.repaint();
//           JTextField WinText = new JTextField("Someone won!");
//           MyPanel.add(WinText);
}







//panel for stuff but moved here so WinChecker could access it
   public void WinChecker(boolean WhichOne){
       
       if (
          (Squares[3].getIcon() == Squares[4].getIcon() && Squares[4].getIcon() == Squares[5].getIcon()) && (Squares[5].getIcon() != BlankIcon)  || //mid row
          (Squares[6].getIcon() == Squares[7].getIcon() && Squares[7].getIcon() == Squares[8].getIcon()) && (Squares[8].getIcon() != BlankIcon)  || //bot row
          (Squares[0].getIcon() == Squares[3].getIcon() && Squares[3].getIcon() == Squares[6].getIcon()) && (Squares[6].getIcon() != BlankIcon)  || //1st clm
          (Squares[1].getIcon() == Squares[4].getIcon() && Squares[4].getIcon() == Squares[7].getIcon()) && (Squares[7].getIcon() != BlankIcon)  || //2nd clm
          (Squares[2].getIcon() == Squares[5].getIcon() && Squares[5].getIcon() == Squares[8].getIcon()) && (Squares[8].getIcon() != BlankIcon)  || //3rd clm
          (Squares[0].getIcon() == Squares[4].getIcon() && Squares[4].getIcon() == Squares[8].getIcon()) && (Squares[8].getIcon() != BlankIcon)  || //lft slant
          (Squares[6].getIcon() == Squares[4].getIcon() && Squares[4].getIcon() == Squares[2].getIcon()) && (Squares[2].getIcon() != BlankIcon)  //rgt slant
          ) { // If it's three in a row
              if (WhichOne){
        //If WhichOne is true, then its O, if false, X
        WinnerLabel.setText("O won the game!");

    } else {
        WinnerLabel.setText("X won the game!");

    }   
       } //end win thing 
       
       //now tie code
       if (Squares[0].getIcon() != BlankIcon && Squares[1].getIcon() != BlankIcon && Squares[2].getIcon() != BlankIcon && 
               Squares[3].getIcon() != BlankIcon && Squares[4].getIcon() != BlankIcon && Squares[5].getIcon() != BlankIcon && 
               Squares[6].getIcon() != BlankIcon && Squares[7].getIcon() != BlankIcon && Squares[8].getIcon() != BlankIcon) 
       { // this is the tied code
           System.out.println("Someone tied!"); 
           MyPanel.setLayout(new FlowLayout());
           MyPanel.removeAll();
           MyPanel.revalidate();
           MyPanel.repaint();
           JTextField TieText = new JTextField("You guys tied!");
           MyPanel.add(TieText);
       } // end tied code
       
   } // end WinChecker code
   
   
   
   
   
   
  
   public class ButtonListener implements ActionListener  {//actionlistener thing
       boolean thing = false;
            boolean XODetector = true;
         //checks if it is X or O's turn. False is X, True is O
        public void setXODetector (boolean thingy) {
       this.XODetector = thingy;
       }   
        
     @Override public void actionPerformed(ActionEvent e){ 
         Object source = e.getSource(); //making the type of source that e is a variable
        if (source instanceof JButton) { //if the source is JButton
            JButton SquareThing = (JButton)source;
        

//         
         
          //Can reference the component with JButton stuff
            // Go ahead and do what you like
            if (SquareThing.getIcon() != BlankIcon) {
               //nothing happens if it is a different icon
            } else { // if it's blank
                           
                if (XODetector == false) { //actually  O, because switched
                    WinChecker(true);
                } else {
                    WinChecker(false);
                }
            
                if (XODetector == true) { //if it is O's turn
                   // System.out.println("You got this far");             
                    SquareThing.setIcon(OIcon);    // FOr some reason, this line refuses to work
                    //System.out.println("The OIcon thing got called");
//                    WinChecker(true);
                    setXODetector(false);
                }
               else { //if it is X's turn
                    SquareThing.setIcon(XIcon);
//                           WinChecker(false);                 
                    setXODetector(true);
                }
                
            } // end the if blank thing 
            
           
        }
     }   
   } //end action listener

   
   
   
   
   
     public GUIClass() { //constructor
      //new frame
      MyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      MyFrame.setVisible(true);
      MyFrame.setSize(380,605);
       MyFrame.setLocationRelativeTo(null);
       // new panel
       MyPane.add(TopPanel, NORTH);
       MyPane.add(BottomPanel, SOUTH);
       MyPane.add(MyPanel, CENTER); //add panel to pane. ADD ALL STUFF
       BottomPanel.add(WinnerLabel);
       TopPanel.setPreferredSize(new Dimension(380, 75));
       MyPanel.setPreferredSize(new Dimension(380, 380));
       BottomPanel.setPreferredSize(new Dimension(380, 150));
      MyPanel.setLayout(new GridLayout(3,3, 10, 10)); //spacing of 20
      MyPanel.setBackground(Color.black);
      for (int i = 0; i < 9; i++) {
    Squares[i] = new JButton(BlankIcon);   // assigns each reference in Squares to a JButton
    MyPanel.add(Squares[i]); //, adds the 9 squares to MyPanel
    Squares[i].addActionListener(ButtonListener); //gotta remember its an object, not class
     } // end for loop
} //end constructor
    
     
     
     
  // Dont touch the below code: It somehow allows an image to be used. sooo yeah   
     protected ImageIcon createImageIcon(String path, String description) {
    java.net.URL imgURL = getClass().getResource(path);
    if (imgURL != null) {
        return new ImageIcon(imgURL, description);
    } else {
        System.err.println("Couldn't find file: " + path);
        return null;
    }
}
 //protection ended here    
     
     
     
     
     
}