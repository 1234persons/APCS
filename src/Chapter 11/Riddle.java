import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.*;

public class Riddle implements ActionListener {

	final static String LABEL_TEXT = "Why did the chicken cross the road?";
	final static String ANSWER = "To get to the other side.";
	JFrame frame;
	JPanel contentPane;
	JLabel label;
	JLabel answer;
	JButton button;

	public Riddle() {

		/* Create and set up the frame */
		frame = new JFrame("Riddle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Create a content pane */
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(2, 2, 5, 5));
		contentPane.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

		/* Create and add label */
		label = new JLabel(LABEL_TEXT);
		label.setAlignmentX(1);
		label.setAlignmentY(1);
		contentPane.add(label);

		answer = new JLabel();
		label.setAlignmentX(2);
		label.setAlignmentY(1);
		contentPane.add(answer);

		// Create and add button
		button = new JButton("Answer");
		label.setAlignmentX(1);
		label.setAlignmentY(2);
		button.addActionListener(this);
		contentPane.add(button);

		/* Add content pane to frame */
		frame.setContentPane(contentPane);

		/* Size and then display the frame. */
		frame.pack();
		frame.setVisible(true);
	}

	// Handle button click event
	public void actionPerformed(ActionEvent event) {
		answer.setText(ANSWER);
	}

	/**
	 * Create and show the GUI.
	 */
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		@SuppressWarnings("unused")
		Riddle Riddle = new Riddle();
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
