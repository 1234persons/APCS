package Final;

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Main extends JFrame {
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    static JFrame F = new Main();
    Screen screenObject = new Screen();

    public Main() {
        add(screenObject);
        setUndecorated(true);
        setSize(screenSize);
        setVisible(true);
    }

    public static void main(String[] args) {

    }

}
