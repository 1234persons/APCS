
import javax.swing.*;
import java.awt.event.*;

public class NumClicks implements ActionListener{
	JFrame frame;
	JPanel contentPane;
	JLabel label;
    JButton button;
    public static int clickCount = 0;

	public NumClicks(){

		/* Create and set up the frame */
		frame = new JFrame("NumClicks");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Create a content pane */
		contentPane = new JPanel();

        // Create and add button
        button = new JButton("Clicks: " + clickCount);
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
        clickCount++;
        button.setText("Clicks: " + clickCount);
    }

	/**
	* Create and show the GUI.
	*/
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		@SuppressWarnings("unused")
		NumClicks clicker = new NumClicks();
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
