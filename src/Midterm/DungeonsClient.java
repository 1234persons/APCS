package Midterm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

@SuppressWarnings("unused")
public class DungeonsClient {

    // MAIN PANEL
    JPanel whatamidoingwithmylife = new JPanel();
    // Grid components
    JPanel gridPane = new JPanel();
    JLabel[][] dungeonTiles = new JLabel[10][10];
    JFrame frame;
    DungeonTile[][] tiles = new DungeonTile[10][10];

    // Userside components
    JPanel userPane = new JPanel();
    JLabel arrowLabel, ropeLabel, alertLabel = new JLabel();

    public DungeonsClient() {
        Random rand = new Random();
        /* Create and set up the frame */
        frame = new JFrame("Dungeons and Dragons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gridPane.setLayout(new GridLayout(10, 10, 0, 0));
        userPane.setLayout(new BoxLayout(userPane, BoxLayout.PAGE_AXIS));

        int tempXcord = rand.nextInt(10);
        int tempYcord = rand.nextInt(10);

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                tiles[x][y] = new DungeonTile(x, y, "");
                dungeonTiles[x][y] = new JLabel(tiles[x][y].getIcon());
            }
        }
        tiles[tempXcord][tempYcord].setItem("rope");
        dungeonTiles[tempXcord][tempYcord].setIcon(tiles[tempXcord][tempYcord].getIcon());

        tempXcord = rand.nextInt(10);
        tempYcord = rand.nextInt(10);
        tiles[tempXcord][tempYcord].setItem("arrow");
        dungeonTiles[tempXcord][tempYcord].setIcon(tiles[tempXcord][tempYcord].getIcon());

        tempXcord = rand.nextInt(10);
        tempYcord = rand.nextInt(10);
        tiles[tempXcord][tempYcord].setItem("dragon");


        for (int pits = 0; pits < 10; pits++) {
            tempXcord = rand.nextInt(10);
            tempYcord = rand.nextInt(10);
            if (!tiles[tempXcord][tempYcord].getItem().equals("rope")) {
                tiles[tempXcord][tempYcord].setItem("pit");
                dungeonTiles[tempXcord][tempYcord].setIcon(tiles[tempXcord][tempYcord].getIcon());
            }
        }

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                gridPane.add(dungeonTiles[x][y]);
            }
        }

        // if ()
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
