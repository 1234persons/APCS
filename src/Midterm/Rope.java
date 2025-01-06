package Midterm;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Rope {
    
    ImageIcon icon = new ImageIcon("i:\\Downloads\\pixil-frame-0 (2).png");
    int xcoord;
    int ycoord;

    public Rope(int X, int Y) {
        xcoord = X;
        ycoord = Y;
    }

    public String getItem() {
        return("Rope");
    }

    public Icon getIcon() {
        return(new ImageIcon("i:\\Downloads\\pixil-frame-0 (2).png"));
    }

    

}
