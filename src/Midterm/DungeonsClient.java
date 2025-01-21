
package Midterm;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

@SuppressWarnings("unused")
public class DungeonsClient implements KeyListener {
    public int ropeX, ropeY, arrowX, arrowY, dragonX, dragonY, plrX, plrY,
            ropeNum, arrowNum;
    public boolean shooting = false;
    final ImageIcon PLR_ICON = (new ImageIcon(
            new ImageIcon("i:\\Downloads\\pixil-frame-0 (12).png").getImage().getScaledInstance(50, 50, 0)));

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
        ropeNum = 1;
        /* Create and set up the frame */
        frame = new JFrame("Dungeons and Dragons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setForeground(Color.black);
        frame.addKeyListener(this);

        gridPane.setLayout(new GridLayout(10, 10, 0, 0));
        // userPane.setLayout(new BoxLayout(userPane, BoxLayout.PAGE_AXIS));
        mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.PAGE_AXIS));
        userPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // userPane Contents
        arrowLabel = new JLabel(new ImageIcon(new ImageIcon(
                "i:\\Downloads\\pixil-frame-0 (7).png").getImage()
                .getScaledInstance(67, 67, 0)));
        arrowLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        arrowLabel.setBackground(Color.BLACK);
        userPane.add(arrowLabel);

        // userPane Contents
        ropeLabel = new JLabel(new ImageIcon(new ImageIcon(
                "i:\\Downloads\\pixil-frame-0 (6).png").getImage()
                .getScaledInstance(67, 67, 0)));
        ropeLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        ropeLabel.setBackground(Color.BLACK);
        userPane.add(ropeLabel);

        // userPane Contents
        alertLabel = new JLabel("");
        alertLabel.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
        alertLabel.setBackground(Color.BLACK);
        userPane.add(alertLabel);

        // gridPane contents

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                tiles[x][y] = new DungeonTile(x, y, "");
                dungeonTiles[y][x] = new JLabel(tiles[x][y].getIcon());
            }
        }

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                gridPane.add(dungeonTiles[y][x]);
            }
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
        frame.setAlwaysOnTop(true);

        placeArrow();
        placeDragon();
        placePits();
        placePlr();
    }

    public void placeArrow() {
        arrowX = rand.nextInt(10);
        arrowY = rand.nextInt(10);
        while (!tiles[arrowY][arrowX].getItem().equals("")) {
            arrowX = rand.nextInt(10);
            arrowY = rand.nextInt(10);
        }
        tiles[arrowY][arrowX].setItem("arrow");
        System.out.println("Arrow X: " + arrowY);
        System.out.println("Arrow Y: " + arrowX);
        //dungeonTiles[arrowY][arrowX].setIcon(tiles[arrowY][arrowX].getIcon());
    }

    public void placeRope() {
        ropeX = rand.nextInt(10);
        ropeY = rand.nextInt(10);

        while (!tiles[ropeY][ropeX].getItem().equals("")) {
            ropeX = rand.nextInt(10);
            ropeY = rand.nextInt(10);
        }
        tiles[ropeY][ropeX].setItem("rope");
        //dungeonTiles[ropeY][ropeX].setIcon(tiles[ropeY][ropeX].getIcon());
    }

    public void placeDragon() {
        dragonX = rand.nextInt(10);
        dragonY = rand.nextInt(10);
        while (!tiles[dragonY][dragonX].getItem().equals("")) {
            dragonX = rand.nextInt(10);
            dragonY = rand.nextInt(10);
        }
        System.out.println("Dragon X: " + dragonY);
        System.out.println("Dragon Y: " + dragonX);
        tiles[dragonY][dragonX].setItem("dragon");
        //dungeonTiles[dragonY][dragonX].setIcon(tiles[dragonY][dragonX].getIcon());
    }

    public void placePits() {
        for (int pits = 0; pits < 10; pits++) {
            int tempXcord = rand.nextInt(10);
            int tempYcord = rand.nextInt(10);

            while (!tiles[tempYcord][tempXcord].getItem().equals("")) {
                tempXcord = rand.nextInt(10);
                tempYcord = rand.nextInt(10);
            }

            if (!tiles[tempYcord][tempXcord].getItem().equals("rope")
                    && !tiles[tempYcord][tempXcord].getItem().equals("rope")) {
                tiles[tempYcord][tempXcord].setItem("pit");
                //dungeonTiles[tempYcord][tempXcord].setIcon(tiles[tempYcord][tempXcord].getIcon());
            }
        }
    }

    public void placePlr() {
        plrX = rand.nextInt(10);
        plrY = rand.nextInt(10);
        while (!tiles[plrY][plrX].getItem().equals("")) {
            plrY = rand.nextInt(10);
            plrX = rand.nextInt(10);
        }
        dungeonTiles[plrY][plrX].setIcon(PLR_ICON);
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
         * Methods that create and show a GUI should be run from an
         * event-dispatching thread
         */
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                runGUI();
            }
        });
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // bruh
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // bruh

    }

    @Override
    public void keyTyped(KeyEvent e) {
        char keyChar = e.getKeyChar();

        if (keyChar == "w".charAt(0)) {
            if (!shooting) {
                moveUp();
            } else {
                shootUp();
            }
        }
        if (keyChar == "a".charAt(0)) {
            if (!shooting) {
                moveLeft();
            } else {
                shootLeft();
            }
        }
        if (keyChar == "s".charAt(0)) {
            if (!shooting) {
                moveDown();
            } else {
                shootDown();
            }
        }
        if (keyChar == "d".charAt(0)) {
            if (!shooting) {
                moveRight();
            } else {
                shootRight();
            }
        }

        if (keyChar == "z".charAt(0)) {
            if (arrowNum == 1) {
                //System.out.println("shoot");
                shootArrow();
            }
        }
    }

    public void moveLeft() {
        dungeonTiles[(plrY + 9) % 10][((plrX) + 10) % 10].setIcon(PLR_ICON);
        dungeonTiles[((plrY) + 10) % 10][((plrX) + 10) % 10].setIcon(tiles[((plrY) + 10) % 10][((plrX) + 10) % 10].getIcon());
        plrY = (plrY + 9) % 10;
        checkSurroundings();
    }

    public void moveUp() {
        dungeonTiles[((plrY) + 10) % 10][(plrX + 9) % 10].setIcon(PLR_ICON);
        dungeonTiles[((plrY) + 10) % 10][((plrX) + 10) % 10].setIcon(tiles[((plrY) + 10) % 10][((plrX) + 10) % 10].getIcon());
        plrX = (plrX + 9) % 10;
        checkSurroundings();
    }

    public void moveDown() {
        dungeonTiles[((plrY) + 10) % 10][(plrX + 11) % 10].setIcon(PLR_ICON);
        dungeonTiles[((plrY) + 10) % 10][((plrX) + 10) % 10]
                .setIcon(tiles[((plrY) + 10) % 10][((plrX) + 10) % 10].getIcon());
        plrX = (plrX + 11) % 10;
        checkSurroundings();
    }

    public void moveRight() {
        dungeonTiles[(plrY + 11) % 10][((plrX) + 10) % 10].setIcon(PLR_ICON);
        dungeonTiles[((plrY) + 10) % 10][((plrX) + 10) % 10]
                .setIcon(tiles[((plrY) + 10) % 10][((plrX) + 10) % 10].getIcon());
        plrY = (plrY + 11) % 10;
        checkSurroundings();
    }

    public void checkSurroundings() {
        alertLabel.setText("");
        if (!tiles[(plrY + 9) % 10][plrX].getItem().equals("")) {
            if (tiles[(plrY + 9) % 10][plrX].getItem().equals("arrow")) {
                alertLabel.setText("There is an arrow nearby");
            }
            if (tiles[(plrY + 9) % 10][plrX].getItem().equals("rope")) {
                alertLabel.setText("There is a rope nearby");
            }
            if (tiles[(plrY + 9) % 10][plrX].getItem().equals("dragon")) {
                alertLabel.setText("There is a dragon nearby");
            }
            if (tiles[(plrY + 9) % 10][plrX].getItem().equals("pit")) {
                alertLabel.setText("There is a pit nearby");
            }
        }

        if (!tiles[(plrY + 11) % 10][plrX].getItem().equals("")) {
            if (tiles[(plrY + 11) % 10][plrX].getItem().equals("arrow")) {
                alertLabel.setText("There is an arrow nearby");
            }
            if (tiles[(plrY + 11) % 10][plrX].getItem().equals("rope")) {
                alertLabel.setText("There is a rope nearby");
            }
            if (tiles[(plrY + 11) % 10][plrX].getItem().equals("dragon")) {
                alertLabel.setText("There is a dragon nearby");
            }
            if (tiles[(plrY + 11) % 10][plrX].getItem().equals("pit")) {
                alertLabel.setText("There is a pit nearby");
            }
        }

        if (!tiles[plrY][(plrX + 11) % 10].getItem().equals("")) {
            if (tiles[plrY][(plrX + 11) % 10].getItem().equals("arrow")) {
                alertLabel.setText("There is an arrow nearby");
            }
            if (tiles[plrY][(plrX + 11) % 10].getItem().equals("rope")) {
                alertLabel.setText("There is a rope nearby");
            }
            if (tiles[plrY][(plrX + 11) % 10].getItem().equals("dragon")) {
                alertLabel.setText("There is a dragon nearby");
            }
            if (tiles[plrY][(plrX + 11) % 10].getItem().equals("pit")) {
                alertLabel.setText("There is a pit nearby");
            }
        }

        if (!tiles[plrY][(plrX + 9) % 10].getItem().equals("")) {
            if (tiles[plrY][(plrX + 9) % 10].getItem().equals("arrow")) {
                alertLabel.setText("There is an arrow nearby");
            }
            if (tiles[plrY][(plrX + 9) % 10].getItem().equals("rope")) {
                alertLabel.setText("There is a rope nearby");
            }
            if (tiles[plrY][(plrX + 9) % 10].getItem().equals("dragon")) {
                alertLabel.setText("There is a dragon nearby");
            }
            if (tiles[plrY][(plrX + 9) % 10].getItem().equals("pit")) {
                alertLabel.setText("There is a pit nearby");
            }
        }
        if (plrY == arrowY && plrX == arrowX) {
            JOptionPane itemPickup = new JOptionPane("You have found the arrow!");
            itemPickup.setBackground(Color.green);
            JOptionPane.showMessageDialog(frame, "You have found the arrow!");
            arrowNum++;
            tiles[arrowY][arrowX].setItem("");
            dungeonTiles[arrowY][arrowX].setIcon(PLR_ICON);
            arrowLabel.setIcon(new ImageIcon(new ImageIcon("i:\\Downloads\\pixil-frame-0 (5).png").getImage().getScaledInstance(67, 67, 0)));

        } else if (plrY == ropeY && plrX == ropeX) {
            JOptionPane itemPickup = new JOptionPane("You have found the rope!");
            itemPickup.setBackground(Color.green);
            JOptionPane.showMessageDialog(frame, "You have found the rope!");
            tiles[ropeY][ropeX].setItem("");
            dungeonTiles[ropeY][ropeX].setIcon(PLR_ICON);
            ropeNum++;
            ropeLabel.setIcon(new ImageIcon(new ImageIcon("i:\\Downloads\\pixil-frame-0 (6).png").getImage().getScaledInstance(67, 67, 0)));

        } else if (tiles[plrY][plrX].getItem().equals("pit")) {

            JOptionPane itemPickup = new JOptionPane("You have fallen in a pit");
            itemPickup.setBackground(Color.green);
            JOptionPane.showMessageDialog(frame, "You have fallen in a pit");
            if (ropeNum < 1) {
                JOptionPane.showMessageDialog(frame, "You have no rope and cannot get out. Game over.");
                System.exit(1);
            } else {
                JOptionPane.showMessageDialog(frame, "You use the rope to get out, but lose the rope in the process.");
                ropeNum--;
                dungeonTiles[plrY][plrX].setIcon(tiles[plrY][plrX].getIcon());
                plrX = (plrX + 9) % 10;
                plrY = (plrY + 9) % 10;
                placeRope();
                ropeLabel.setIcon(new ImageIcon(new ImageIcon("i:\\Downloads\\pixil-frame-0 (7).png").getImage().getScaledInstance(67, 67, 0)));
                dungeonTiles[plrY][plrX].setIcon(PLR_ICON);
            }

        } else if (tiles[plrY][plrX].getItem().equals("dragon")) {

            JOptionPane itemPickup = new JOptionPane("You found the dragon");
            itemPickup.setBackground(Color.green);
            JOptionPane.showMessageDialog(frame, "The dragon has killed you");
            System.exit(1);
        }
    }

    public void shootArrow() {
        if (shooting) {
            shooting = false;
        } else {
            shooting = true;
        }
    }

    public void shootUp() {
        if ((plrX + 9) % 10 == dragonX && plrY == dragonY) {
            JOptionPane.showMessageDialog(frame, "You shot the dragon! You win!");
            System.exit(1);
        } else {
            JOptionPane.showMessageDialog(frame, "You missed the dragon.");
        }
        shooting = false;
        placeArrow();
    }

    public void shootLeft() {
        if (plrX == dragonX && (plrY + 9) % 10 == dragonY) {
            JOptionPane.showMessageDialog(frame, "You shot the dragon! You win!");
            System.exit(1);
        } else {
            JOptionPane.showMessageDialog(frame, "You missed the dragon.");
        }
        shooting = false;
        placeArrow();
    }

    public void shootRight() {
        if (plrX == dragonX && (plrY + 11) % 10 == dragonY) {
            JOptionPane.showMessageDialog(frame, "You shot the dragon! You win!");
            System.exit(1);
        } else {
            JOptionPane.showMessageDialog(frame, "You missed the dragon.");
        }
        shooting = false;
        placeArrow();
    }

    public void shootDown() {
        if ((plrX + 11) % 10 == dragonX && plrY == dragonY) {
            JOptionPane.showMessageDialog(frame, "You shot the dragon! You win!");
            System.exit(1);
        } else {
            JOptionPane.showMessageDialog(frame, "You missed the dragon.");
        }
        shooting = false;
        placeArrow();
    }
}