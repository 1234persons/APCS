package Midterm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class DungeonsClient {

    // Grid components
    JPanel gridPane = new JPanel();
    JLabel[][] dungeonTiles = new JLabel[10][10];
    JFrame frame;
    DungeonTile[][] tiles = new DungeonTile[10][10];

    public DungeonsClient() {

        /* Create and set up the frame */
        frame = new JFrame("Dungeons and Dragons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gridPane.setLayout(new GridLayout(5, 5, 5, 5));

        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                tiles[x][y] = new DungeonTile(x, y);
                Random rand = new Random();
                int randX = rand.nextInt(5);
                int randY = rand.nextInt(5);
                if (x == randX && y == randY) {
                    tiles[x][y].setItem("Rope");
                    dungeonTiles[x][y] = new JLabel(tiles[x][y].getIcon());
                } else {
                    dungeonTiles[x][y] = new JLabel(tiles[x][y].getIcon());
                }
                
                gridPane.add(dungeonTiles[x][y]);
            }
        }

         /* Add content pane to frame */
         frame.setContentPane(gridPane);
 
         /* Size and then display the frame. */
         frame.pack();
         frame.setVisible(true);
    }

    /**
     * Create and show the GUI.
     */
    private static void runGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        DungeonsClient playDAndD = new DungeonsClient();
    }

    public static void main(String[] args) {
        /*
         * Methods that create and show a GUI should be
         * run from an event-dispatching thread
         */
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                runGUI();
            }
        });
    }
}
