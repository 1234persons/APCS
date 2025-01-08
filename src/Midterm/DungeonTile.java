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
            ImageIcon icon = new ImageIcon(new ImageIcon("i:\\Downloads\\pixil-frame-0 (2).png").getImage().getScaledInstance(50, 50, 0));
            return(icon);      
        } else if (tileItem.equals("Arrow")) {
            ImageIcon icon = new ImageIcon(new ImageIcon("i:\\Downloads\\pixil-frame-0 (3).png").getImage().getScaledInstance(50, 50, 0));
            return(icon);  
        } else if (tileItem.equals("Pit")) {
            ImageIcon icon = new ImageIcon(new ImageIcon("i:\\Downloads\\pixil-frame-0 (4).png").getImage().getScaledInstance(50, 50, 0));
            return(icon);  
        } else {
            ImageIcon icon = new ImageIcon(new ImageIcon("i:\\Downloads\\pixilart-drawing (2).png").getImage().getScaledInstance(50, 50, 0));
            return(icon);  
        }
    
    }

    public String toString() {
        return ("Test");
    }

}
