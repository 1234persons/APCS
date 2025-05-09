package Final;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.*;

public class PolygonObject {

    Polygon p;
    Color c;
    public PolygonObject(double[] x, double[] y, Color c) {

        p = new Polygon();

        for (int i = 0; i < x.length; i++) {

            p.addPoint((int) x[i], (int) y[i]);

        }

        this.c = c;

    }

    void drawPolygon(Graphics g) {
        g.setColor(c);
        g.drawPolygon(p);
    }

    

}
