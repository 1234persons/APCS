package Final;

import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DPoly {
    Color c;
	double[] x, y, z;
	boolean draw = true;
	double[] CalcPos, newX, newY;
	PolygonObject drawablePolygon;
	double avgDist;
    ArrayList<Vector> vertices = new ArrayList<Vector>();
    public DPoly(double[] x, double[] y, double[] z,  Color color) {
        
        this.c = color;
        this.x = x;
        this.y = y;
        this.z = z;
        makeVertices(x, y, z);
        drawablePolygon = new PolygonObject(x, y, c);
    }

    void makeVertices(double[] x, double[] y, double[] z) {
        for (int i = 0; i < x.length; i++) {
            vertices.add(new Vector(x[i], y[i], z[i]));
        }
    }

    Vector getNormal() {
        Vector v1 = vertices.get(1).subtract(vertices.get(0));
        Vector v2 = vertices.get(2).subtract(vertices.get(0));
        return v1.cross(v2).normalize();
    }

    Vector centroid() {
        double cx = 0, cy = 0, cz = 0;
        for (Vector v : vertices) {
            cx += v.x;
            cy += v.y;
            cz += v.z;
        }
        int n = vertices.size();
        return new Vector(cx / n, cy / n, cz / n);
    }

    static List<DPoly> sortByCentroidDistance(Vector cameraPos, List<DPoly> polygons) {
        return polygons.stream()
            .sorted(Comparator.comparingDouble(p -> p.centroid().distanceTo(cameraPos)))
            .collect(Collectors.toList());
    }

    ArrayList<Vector> getEdges() {
        ArrayList<Vector> edges = new ArrayList<>();
        for (int i = 0; i < vertices.size(); i++) {
            Vector edge = vertices.get((i + 1) % vertices.size()).subtract(vertices.get(i));
            edges.add(edge);
        }
        return edges;
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
 
