import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.*;

public class MetricConversion implements ActionListener {

    final static String LABEL_TEXT = "Select a conversion: ";
    JFrame frame;
    JPanel contentPane;
    JLabel label;
    JLabel display;
    @SuppressWarnings("rawtypes")
    JComboBox userBox;

    public MetricConversion() {

        /* Create and set up the frame */
        frame = new JFrame("Metric Conversions");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Create a content pane */
        contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(3, 1, 4, 4));
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        

        /* Create and add label */
        label = new JLabel(LABEL_TEXT);
        label.setAlignmentX(1);
        label.setAlignmentY(3);
        contentPane.add(label);

        String[] conversions = {"Feet to Meters", "Inches to Centimeters", "Pounds to Kilograms", "Gallons to Liters"};
        userBox = new JComboBox<>(conversions);
        userBox.setAlignmentX(1);
        userBox.setAlignmentY(2);
        userBox.addActionListener(this);
        contentPane.add(userBox);

        display = new JLabel();
        display.setAlignmentX(1);
        display.setAlignmentY(1);
        contentPane.add(display);


        /* Add content pane to frame */
        frame.setContentPane(contentPane);

        /* Size and then display the frame. */
        frame.pack();
        frame.setVisible(true);
    }

    // Handle button click event
    public void actionPerformed(ActionEvent event) {

        if (userBox.getSelectedItem().equals("Feet to Meters")) {
            display.setText("1 foot = .3048 meters");
        } else if (userBox.getSelectedItem().equals("Inches to Centimeters")) {
            display.setText("1 inch = 2.54 centimeters");
        } else if (userBox.getSelectedItem().equals("Pounds to Kilograms")) {
            display.setText("1 pound = 0.4536Kg");
        } else if (userBox.getSelectedItem().equals("Gallons to Liters")) {
            display.setText("1 gallon = 4.5461 liters");
        }

    }

    /**
     * Create and show the GUI.
     */
    private static void runGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        @SuppressWarnings("unused")
        MetricConversion conversion = new MetricConversion();
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
