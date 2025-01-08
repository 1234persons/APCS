import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameOfLight {
    JFrame frame;
    JPanel contentPane;
    JButton[][] lightBoard;
    int rows, columns;

    public GameOfLight() {
        // Create and set up the frame
        frame = new JFrame("Game of Light");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500); 

        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel userPanel = new JPanel();
        userPanel.setLayout(new FlowLayout());

        JLabel rowsLabel = new JLabel("Rows:");
        JTextField rowsTextField = new JTextField(10);
        userPanel.add(rowsLabel);
        userPanel.add(rowsTextField);

        JLabel columnsLabel = new JLabel("Columns:");
        JTextField columnsTextField = new JTextField(10);
        userPanel.add(columnsLabel);
        userPanel.add(columnsTextField);

        // Create a button to start the game
        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> {
            // Get the rows and columns from the text fields
            rows = Integer.parseInt(rowsTextField.getText());
            columns = Integer.parseInt(columnsTextField.getText());

            // Validate the input
            if (rows < 3 || rows > 9 || columns < 3 || columns > 9) {
                JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a number between 3 and 9 for rows and columns.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Remove the input panel
            contentPane.remove(userPanel);

            // Create a grid layout for the light board
            contentPane.setLayout(new GridLayout(rows, columns, 0, 0));
            contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // Create and add buttons to the light board
            lightBoard = new JButton[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    lightBoard[i][j] = new JButton();
                    lightBoard[i][j].setPreferredSize(new Dimension(50, 50)); // Set preferred size to create equal-sized squares
                    lightBoard[i][j].setBackground(Color.BLACK);
                    lightBoard[i][j].addActionListener(lightButtonListener);
                    contentPane.add(lightBoard[i][j]);
                }
            }

            // Add the light board to the content pane
            frame.setContentPane(contentPane);

        });
        userPanel.add(startButton);

        // Add the input panel to the content pane
        contentPane.add(userPanel);

        // Add content pane to frame
        frame.setContentPane(contentPane);

        // Size and then display the frame.
        frame.pack();
        frame.setVisible(true);
    }

    ActionListener lightButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            int row = -1;
            int col = -1;
            // Find the button's position in the light board
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (lightBoard[i][j] == button) {
                        row = i;
                        col = j;
                        break;
                    }
                }
                if (row != -1 && col != -1) {
                    break;
                }
            }

            if (row != -1 && col != -1) {
                if (button.getBackground() == Color.WHITE) {
                    button.setBackground(Color.BLACK);
                } else {
                    button.setBackground(Color.WHITE);
                }

                // Toggle the state of the adjacent buttons
                if (row > 0) {
                    JButton aboveButton = lightBoard[row - 1][col];
                    toggleButtonState(aboveButton);
                }
                if (row < rows - 1) {
                    JButton belowButton = lightBoard[row + 1][col];
                    toggleButtonState(belowButton);
                }
                if (col > 0) {
                    JButton leftButton = lightBoard[row][col - 1];
                    toggleButtonState(leftButton);
                }
                if (col < columns - 1) {
                    JButton rightButton = lightBoard[row][col + 1];
                    toggleButtonState(rightButton);
                }

                // Check if all buttons are turned on (red)
                boolean won = true;
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        if (lightBoard[i][j].getBackground() != Color.WHITE) {
                            won = false;
                            break;
                        }
                    }
                    if (!won) {
                        break;
                    }
                }
                if (won) {
                    JOptionPane.showMessageDialog(frame, "Congratulations! You won the game.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

        private void toggleButtonState(JButton button) {
            if (button.getBackground() == Color.WHITE) {
                button.setBackground(Color.BLACK);
            } else {
                button.setBackground(Color.WHITE);
            }
        }
    };

    public static void main(String[] args) {
        new GameOfLight();
    }
}
