package Final;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;


public class PolygonObject {

    Polygon p;
    Color c;
    double avgsdist = 0;
    boolean draw = true;
    public PolygonObject(double[] x, double[] y, Color c) {
        p = new Polygon();
        
        for (int i = 0; i < x.length; i++) {
            p.addPoint((int) x[i], (int) y[i]);
        }
        this.c = c;
    }

    void update2gon(double[] x, double[] y) {
        p.reset();
        for (int i = 0; i < x.length; i++) {
            p.xpoints[i] = (int) x[i];
            p.ypoints[i] = (int) y[i];
            p.npoints = (int) x.length;
        }

    }

    void drawPolygon(Graphics g) {
        if (draw) {
            g.setColor(c);
            g.fillPolygon(p);
            g.setColor(Color.BLACK);
            g.drawPolygon(p);  
        }
            
        
        

    }

    

}
