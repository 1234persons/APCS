import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.*;
import java.lang.Double;

public class DivisibleByThree implements ActionListener {
	final static String LABEL_TEXT = "Enter an integer: ";
	JFrame frame;
	JPanel contentPane;
	JLabel label;
	JLabel answer;
	JButton button;
	JTextField text;

	public DivisibleByThree() {

		/* Create and set up the frame */
		frame = new JFrame("DivisibleByThree");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Create a content pane */
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(2, 2, 30, 5));
		contentPane.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

		/* Create and add label */
		label = new JLabel(LABEL_TEXT);
		label.setAlignmentX(1);
		label.setAlignmentY(2);
		contentPane.add(label);

		text = new JTextField(10);
		text.setAlignmentX(2);
		text.setAlignmentY(2);
		contentPane.add(text);

		// Create and add button
		button = new JButton("Check");
		button.setAlignmentX(2);
		button.setAlignmentY(2);
		button.addActionListener(this);
		contentPane.add(button);

		answer = new JLabel("Test");
		answer.setAlignmentX(1);
		answer.setAlignmentY(2);
		contentPane.add(answer);

		/* Add content pane to frame */
		frame.setContentPane(contentPane);

		/* Size and then display the frame. */
		frame.pack();
		frame.setVisible(true);
	}

	// Handle button click event
	public void actionPerformed(ActionEvent event) {
		double userNum = Double.parseDouble(text.getText());

		if (userNum / 3 == (int)userNum/3) {
			answer.setText((int)userNum + " is divisible by 3.");
		} else {
			answer.setText((int)userNum + " is not divisible by 3.");
		}

	}

	/**
	 * Create and show the GUI.
	 */
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		@SuppressWarnings("unused")
		DivisibleByThree divide = new DivisibleByThree();
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
