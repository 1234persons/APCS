

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;


public class Roll implements ActionListener{
    JFrame frame;
	JPanel contentPane;
	JLabel dieFace;
	JButton rollDie;

    public Roll() {
        // Create and set up the frame
        frame = new JFrame("Roll");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create content pane with box layout and empty borders
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPane.setBackground(Color.white);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

        //Make label that shows die face
        dieFace = new JLabel(new ImageIcon("i:\\Downloads\\die1.gif"));
        dieFace.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        dieFace.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        contentPane.add(dieFace);

        // Create a roll button
        rollDie = new JButton("Roll Die");
        rollDie.setAlignmentX(JButton.CENTER_ALIGNMENT);
        rollDie.addActionListener(this);
        contentPane.add(rollDie);

        // Add to frame
        frame.setContentPane(contentPane);

        //Size and pack
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        int newRoll;

        newRoll = (int)(6*Math.random() + 1);

        if (newRoll == 1) {
            dieFace.setIcon(new ImageIcon("i:\\Downloads\\die1.gif"));
        } else if (newRoll == 2) {
            dieFace.setIcon(new ImageIcon("i:\\Downloads\\die2.gif"));
        } else if (newRoll == 3) {
            dieFace.setIcon(new ImageIcon("i:\\Downloads\\die3.gif"));
        } else if (newRoll == 4) {
            dieFace.setIcon(new ImageIcon("i:\\Downloads\\die4.gif"));
        } else if (newRoll == 5) {
            dieFace.setIcon(new ImageIcon("i:\\Downloads\\die5.gif"));
        } else if (newRoll == 6) {
            dieFace.setIcon(new ImageIcon("i:\\Downloads\\die6.gif"));
        }
    }

    /**
	 * Create and show the GUI.
	 */
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		@SuppressWarnings("unused")
        Roll die = new Roll();
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
