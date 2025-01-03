package Midterm;

abstract class Item extends DungeonTile {
    
    int xcoord;
    int ycoord;
    Object itemObject;

    public Item(int X, int Y, Object item) {
        super(X, Y, item);
    }
}
