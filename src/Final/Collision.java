package Final;

import java.awt.Dimension;
import java.awt.Rectangle;

public class Collision {
    double[] x, y, z;
    public Collision(double[] x, double[] y ,double[] z) {
        this.x = x;
        this.y = y;
        this.z = z;
        generateColRects(x, y, z);
    }
    void generateColRects(double[] x2, double[] y2, double[] z2) {
        for (int i = 0; i < x2.length; i++) {
            Screen.colRects.add(new Rectangle((int)x2[i], (int)y2[i], (int)x2[i], (int)y2[i]));
        } 
    }

    


}
