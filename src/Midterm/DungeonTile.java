package Midterm;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class DungeonTile {

    int xCord;
    int yCord;
    String tileItem = "";

    public DungeonTile(int X, int Y) {
        xCord = X;
        yCord = Y;

    }

    public DungeonTile(int X, int Y, String item) {
        xCord = X;
        yCord = Y;
        tileItem = item;
    }

    public void setItem(String item) {
        tileItem = item;
    }

    public Icon getIcon() {
        if (tileItem.equals("Rope")) {
            return(new ImageIcon("i:\\Downloads\\pixil-frame-0 (2).png"));
        } else if (tileItem.equals("Arrow")) {
            return(new ImageIcon("i:\\Downloads\\pixil-frame-0 (3).png"));
        } else if (tileItem.equals("Pit")) {
            return(new ImageIcon("i:\\Downloads\\pixil-frame-0 (4).png"));
        } else {
            return(new ImageIcon("i:\\Downloads\\pixilart-drawing (2).png"));
        }
    
    }

    public String toString() {
        return ("Test");
    }

}
