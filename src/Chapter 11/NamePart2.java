
import javax.swing.*;
import java.awt.event.*;

public class NamePart2 implements ActionListener {
    
	final static String LABEL_TEXT = "Gino Millas";
	JFrame frame;
	JPanel contentPane;
	JLabel label;
    JButton button;

	public NamePart2(){

		/* Create and set up the frame */
		frame = new JFrame("NamePart2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Create a content pane */
		contentPane = new JPanel();

		/* Create and add label */
		label = new JLabel(LABEL_TEXT);
		contentPane.add(label);

        // Create and add button
        button = new JButton("Hide");
        button.setActionCommand("Hide");
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
        String eventName = event.getActionCommand();

        if (eventName.equals("Hide")) {
            label.setText(" ");
            button.setText("Show");
            button.setActionCommand("Show");
        } else {
            label.setText(LABEL_TEXT);
            button.setText("Hide");
            button.setActionCommand("Hide");
        }
    }

	/**
	* Create and show the GUI.
	*/
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		NamePart2 name = new NamePart2();
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
