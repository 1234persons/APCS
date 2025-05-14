package Final;

import java.awt.Color;
import java.awt.Polygon;

public class DPoly {
    Color c;
	double[] x, y, z;
	boolean draw = true;
	double[] CalcPos, newX, newY;
	PolygonObject drawablePolygon;
	double avgDist;
    public DPoly(double[] x, double[] y, double[] z,  Color color) {
        
        this.c = color;
        this.x = x;
        this.y = y;
        this.z = z;
        createPolygon();
    }

    void createPolygon() {
        drawablePolygon = new PolygonObject(new double[x.length], new double[x.length], c);
    }

    void updatePolygon() {
        newX = new double[x.length];
		newY = new double[x.length];
		draw = true;
		for(int i=0; i < x.length; i++)
		{
			CalcPos = PointCalc.calculatePositionP(Screen.viewFrom, Screen.viewTo, x[i], y[i], z[i]);
			newX[i] = (Main.screenSize.getWidth()/2 - PointCalc.calcFocusPos[0]) + CalcPos[0] * Screen.zoom;
			newY[i] = (Main.screenSize.getHeight()/2 - PointCalc.calcFocusPos[1]) + CalcPos[1] * Screen.zoom;	
			if(PointCalc.t <= 0)
				draw = false;
		}
		
		drawablePolygon.draw = draw;
		drawablePolygon.update2gon(newX, newY);
		avgDist = getDist();
    }


    double getDist() {

        double total = 0;

        for (int i = 0; i < x.length; i++) {
            total += getDistanceToP(i);
        }

        return(total/x.length);

    }

    double getDistanceToP(int i) {
        return(Math.sqrt(  (Screen.viewFrom[0] - x[i])*(Screen.viewFrom[0] - x[i])
                         + (Screen.viewFrom[1] - y[i])*(Screen.viewFrom[1] - y[i])
                         + (Screen.viewFrom[2] - z[i])*(Screen.viewFrom[2] - z[i])));
    }

}
 
