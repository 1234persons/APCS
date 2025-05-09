package Final;

import javax.swing.*;

import javafx.scene.control.Slider;

import java.awt.Toolkit;

public class Threedimension extends JFrame {
    
    static JFrame F = new Threedimension();
    Screen screenObject = new Screen();


    public Threedimension() {

        add(screenObject);
        setUndecorated(true);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setVisible(true);
    }
    public static void main(String[] args) {
        
    }

}
