package Midterm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

@SuppressWarnings("unused")
public class DungeonsClient {
    public int ropeX, ropeY, arrowX, arrowY, dragonX, dragonY, playerX, playerY, ropeNum, arrowNum;
    
    Random rand = new Random();
    // MAIN PANEL
    JPanel mainPane = new JPanel();
    // Grid components
    JPanel gridPane = new JPanel();
    JLabel[][] dungeonTiles = new JLabel[10][10];
    JFrame frame;
    DungeonTile[][] tiles = new DungeonTile[10][10];

    // Userside components
    JPanel userPane = new JPanel();
    JLabel arrowLabel, ropeLabel, alertLabel;

    public DungeonsClient() {
        
        /* Create and set up the frame */
        frame = new JFrame("Dungeons and Dragons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setForeground(Color.black);

        gridPane.setLayout(new GridLayout(10, 10, 0, 0));
        userPane.setLayout(new BoxLayout(userPane, BoxLayout.PAGE_AXIS));
        mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.PAGE_AXIS));
        userPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        

        //userPane Contents
        arrowLabel = new JLabel(new ImageIcon(new ImageIcon("i:\\Downloads\\pixil-frame-0 (5).png").getImage().getScaledInstance(67, 67, 0)));
        arrowLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        arrowLabel.setBackground(Color.BLACK);
        userPane.add(arrowLabel);

        //userPane Contents
        ropeLabel = new JLabel(new ImageIcon(new ImageIcon("i:\\Downloads\\pixil-frame-0 (6).png").getImage().getScaledInstance(67, 67, 0)));
        ropeLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        ropeLabel.setBackground(Color.BLACK);
        userPane.add(ropeLabel);

        //gridPane contents

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                tiles[x][y] = new DungeonTile(x, y, "");
                dungeonTiles[x][y] = new JLabel(tiles[x][y].getIcon());
            }
        }

        placeArrow();
        placeRope();
        placeDragon();
        placePits();

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                gridPane.add(dungeonTiles[x][y]);
            }
        }

        if (playerX == arrowX && playerY == arrowY) {
            JOptionPane itemPickup = new JOptionPane("You have found the arrow!");
            itemPickup.setBackground(Color.green);
            JOptionPane.showMessageDialog(frame, "You have found the arrow!");
            arrowNum++;

       }

       gridPane.setAlignmentY(JPanel.TOP_ALIGNMENT);
       userPane.setAlignmentY(JPanel.BOTTOM_ALIGNMENT);
       mainPane.add(gridPane); 
       mainPane.add(userPane); 

        /* Add content pane to frame */
        frame.setContentPane(mainPane);

        /* Size and then display the frame. */
        frame.pack();
        frame.setVisible(true);
    }

    public void placeArrow() {
        arrowX = rand.nextInt(10);
        arrowY = rand.nextInt(10);
        tiles[arrowX][arrowY].setItem("arrow");
        dungeonTiles[arrowX][arrowY].setIcon(tiles[arrowX][arrowY].getIcon());
    }

    public void placeRope() {
        ropeX = rand.nextInt(10);
        ropeY = rand.nextInt(10);
        tiles[ropeX][ropeY].setItem("rope");
        dungeonTiles[ropeX][ropeY].setIcon(tiles[ropeX][ropeY].getIcon());
    }

    public void placeDragon() {
        dragonX = rand.nextInt(10);
        dragonY = rand.nextInt(10);
        tiles[dragonX][dragonY].setItem("dragon");
        dungeonTiles[dragonX][dragonY].setIcon(tiles[dragonX][dragonY].getIcon());
    }

    public void placePits() {
        for (int pits = 0; pits < 10; pits++) {
            int tempXcord = rand.nextInt(10);
            int tempYcord = rand.nextInt(10);
            if (!tiles[tempXcord][tempYcord].getItem().equals("rope") && !tiles[tempXcord][tempYcord].getItem().equals("rope")) {
                tiles[tempXcord][tempYcord].setItem("pit");
                dungeonTiles[tempXcord][tempYcord].setIcon(tiles[tempXcord][tempYcord].getIcon());
            }
        }
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
