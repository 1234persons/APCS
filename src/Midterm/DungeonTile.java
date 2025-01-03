package Midterm;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class DungeonTile {

    int xCord;
    int yCord;
    Object tileItem;

    public DungeonTile(int X, int Y) {
        xCord = X;
        yCord = Y;

    }

    public DungeonTile(int X, int Y, Object item) {
        xCord = X;
        yCord = Y;
        tileItem = item;
    }

    public Icon getIcon() {
        return(new ImageIcon("i:\\Downloads\\pixil-frame-0 (2).png"));
    }

    public String getItem() {
        return (tileItem.getItem());
    }

}
