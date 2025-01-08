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
        Random rand = new Random();
        /* Create and set up the frame */
        frame = new JFrame("Dungeons and Dragons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gridPane.setLayout(new GridLayout(10, 10, 0, 0));
        int objectCount = 0;
        int randX = rand.nextInt(10);
        int randY = rand.nextInt(10);

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {

                randX = rand.nextInt(10);
                randY = rand.nextInt(10);
                
                tiles[x][y] = new DungeonTile(x, y);
                if (x == randX && y == randY && objectCount == 0) {

                    objectCount++;
                    tiles[x][y].setItem("Rope");
                    dungeonTiles[x][y] = new JLabel(tiles[x][y].getIcon());

                } else if (x == randX && y == randY && objectCount < 11) {

                    objectCount++;
                    tiles[x][y].setItem("Pit");
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
