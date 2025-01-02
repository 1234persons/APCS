package Midterm;

import javax.swing.JFrame;

import GameOfLife.LifeGUI;

public class DungeonsClient {
    
    public DungeonGame() {

    }
    
    
    /**
      * Create and show the GUI.
      */
     private static void runGUI() {
         JFrame.setDefaultLookAndFeelDecorated(true);
 
         LifeGUI playDAndD = new LifeGUI();
     }
      
 
     public static void main(String[] args) {
         /* Methods that create and show a GUI should be 
            run from an event-dispatching thread */
         javax.swing.SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                 runGUI();
             }
         });
     }
}
