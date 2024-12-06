
import javax.swing.*;
import java.awt.event.*;

public class Sunflower implements ActionListener {
    JFrame frame;
	JPanel contentPane;
	JLabel label;
    JButton englishButton;
    JButton latinButton;


	public Sunflower(){

		/* Create and set up the frame */
		frame = new JFrame("Sunflower");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Create a content pane */
		contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        label = new JLabel("Sunflower");
        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        label.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        contentPane.add(label);

        // Create and add button
        englishButton = new JButton("English");
        englishButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        englishButton.addActionListener(this);
        englishButton.setActionCommand("English");
        contentPane.add(englishButton);

        latinButton = new JButton("Latin");
        latinButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        latinButton.addActionListener(this);
        latinButton.setActionCommand("Latin");
        contentPane.add(latinButton);

		/* Add content pane to frame */
		frame.setContentPane(contentPane);

		/* Size and then display the frame. */
		frame.pack();
		frame.setVisible(true);
	}

    // Handle button click event
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("Latin")) {
            label.setText("Helianthus");
        } else {
            label.setText("Sunflower");
        }
    }

	/**
	* Create and show the GUI.
	*/
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		Sunflower flower = new Sunflower();
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
