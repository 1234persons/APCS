package Final;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;


public class Screen extends JPanel {
    PolygonObject p1;

    double[] viewFrom = new double[]{10,10,10};
    double[] viewTo = new double[]{0,0,0};

    DPoly dp = new DPoly(new double[] {2, 4, 2}, new double[] {3, 5, 3}, new double[] {5, 5, 5}, Color.black);
    public Screen() {

        p1 = new PolygonObject(new double[] {100,200,50}, new double[] {0,100,200} , Color.black);

    }
    public void paintComponent(Graphics g) {
        p1.drawPolygon(g);
    }

    

}
