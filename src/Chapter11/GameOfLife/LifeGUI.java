package GameOfLife;

/*
 * LifeGUI
 * Chapter 11 Exercise 5
 * Lawrenceville Press
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LifeGUI implements ActionListener {
    public static int X;
    public static int Y;
    JFrame frame;
    JPanel contentPane;
    JPanel gridPane;
    JPanel userPane;
    JLabel rowPrompt, colPrompt;
    JTextField rowEnter, colEnter;
    JOptionPane win;
    JButton[][] lifeWorld;
    JButton next, enter;
    LifeWorld lifeGame;

    public LifeGUI() {
        /* Create and set up the frame */
        frame = new JFrame("LifeGUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        userPane = new JPanel();
        userPane.setLayout(new GridLayout(1, 5, 5, 0));
        userPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        userPane.setAlignmentY(JPanel.TOP_ALIGNMENT);
        /* Create a content pane with a GridLayout and empty borders */
        gridPane = new JPanel();
        gridPane.setLayout(new GridLayout(21, 20, 0, 0));
        gridPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        gridPane.setAlignmentY(JPanel.BOTTOM_ALIGNMENT);

        // userPane contents
        rowPrompt = new JLabel("Rows: ");
        rowPrompt.setAlignmentX(1);
        userPane.add(rowPrompt);

        rowEnter = new JTextField(0);
        rowEnter.setAlignmentX(2);
        userPane.add(rowEnter);

        colPrompt = new JLabel("Col: ");
        colPrompt.setAlignmentX(1);
        userPane.add(colPrompt);

        colEnter = new JTextField(0);
        colEnter.setAlignmentX(4);
        userPane.add(colEnter);

        enter = new JButton("Enter");
        enter.setAlignmentX(5);
        enter.setActionCommand("MakeWorld");
        enter.addActionListener(this);
        userPane.add(enter);

        contentPane.add(userPane);

        /* Add content pane to frame */
        frame.setContentPane(contentPane);

        /* Size and then display the frame. */
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Handle Next button
     * pre: none
     * post: A new life world is displayed.
     */
    public void actionPerformed(ActionEvent event) {
        String eventName = event.getActionCommand();
        X = Integer.parseInt(colEnter.getText());
        Y = Integer.parseInt(rowEnter.getText());
        String[][] nextDay = new String[X][Y];
        int cellNum = 0;

        if (eventName.equals("next")) {

            nextDay = lifeGame.nextDay();
            
            for (int xcoord = 0; xcoord < X; xcoord++) {
                for (int ycoord = 0; ycoord < Y; ycoord++) {
                    lifeWorld[xcoord][ycoord].setText(nextDay[xcoord][ycoord]);
                }
            }

            for (int xcoord = 0; xcoord < X; xcoord++) {
                for (int ycoord = 0; ycoord < Y; ycoord++) {
                    if (lifeWorld[xcoord][ycoord].getText().equals("X")) {
                        cellNum++;
                    }
                }
            }

            if (cellNum == 0) {
                win = new JOptionPane("Every cell is dead.");
                JOptionPane.showMessageDialog(frame, "Every cell is dead", "Game over", 1);
                System.exit(1);
            }


        } else if (eventName.equals("MakeWorld")) {
            lifeGame = new LifeWorld(X,Y);
            /* Create and add buttons */
            lifeWorld = new JButton[X][Y];
            gridPane.setLayout(new GridLayout(X + 1, Y, 0, 0));

            for (int xcoord = 0; xcoord < X; xcoord++) {
                for (int ycoord = 0; ycoord < Y; ycoord++) {
                    lifeWorld[xcoord][ycoord] = new JButton("O");
                    lifeWorld[xcoord][ycoord].setActionCommand(xcoord + " " + ycoord);
                    lifeWorld[xcoord][ycoord].addActionListener(new WorldGridListener());
                    gridPane.add(lifeWorld[xcoord][ycoord]);
                }
            }

            /* add Next button */
            next = new JButton("Next");
            next.setActionCommand("next");
            next.addActionListener(this);
            gridPane.add(next);

            frame.setContentPane(gridPane);
            frame.pack();
            frame.setVisible(true);
        }
    }

    class WorldGridListener implements ActionListener {

        /**
         * Adds a live cell where the user clicks
         * pre: btnCoords is a string with a integer followed by a space
         * followed by a second integer.
         * post: A live cell has been added.
         */
        public void actionPerformed(ActionEvent event) {
            String btnCoords = event.getActionCommand();
            int spacePosition, xcoord, ycoord;

            spacePosition = btnCoords.indexOf(" ");
            xcoord = Integer.parseInt(btnCoords.substring(0, spacePosition));
            ycoord = Integer.parseInt(btnCoords.substring(spacePosition + 1));
            lifeGame.addLiveCell(xcoord, ycoord); // add a live cell
            lifeWorld[xcoord][ycoord].setText("X"); // show a live cell
        }
    }

    /**
     * Create and show the GUI.
     */
    private static void runGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        @SuppressWarnings("unused")
        LifeGUI playLife = new LifeGUI();
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