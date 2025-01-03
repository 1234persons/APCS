package Midterm;

import javax.swing.ImageIcon;

public class Rope extends Item {
    
    ImageIcon icon = new ImageIcon("i:\\Downloads\\pixil-frame-0 (2).png");

    public Rope(int X, int Y) {
        super(X,Y, "Rope");
    }

    public String getItem() {
        return("Rope");
    }

}
