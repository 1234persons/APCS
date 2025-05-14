package Final;

public class PointCalc {

    static double t = 0;
    static Plane p;
    static Vector n1, n2, viewVector, rotVector,  planeVect1, planeVect2, directionVector;
    static double[] calcFocusPos = new double[2];

    static double[] calculatePositionP(double[] viewFrom, double[] viewTo, double x, double y, double z) {

        double[] projP = getProj(viewFrom, viewTo, x, y, z, p);
        double[] drawP = getDrawP(projP[0], projP[1], projP[2]);
        return (drawP);

    }


    static double[] getProj(double[] VF, double[] VT, double x, double y, double z, Plane p) {
        Vector viewToPoint = new Vector(x - VF[0], y - VF[1], z - VF[2]);

        t =        (p.nv.x*p.p[0] + p.nv.y*p.p[1] + p.nv.z*p.p[2]
				 - (p.nv.x*VF[0] + p.nv.y*VF[1] + p.nv.z*VF[2]))
				 / (p.nv.x*viewToPoint.x + p.nv.y*viewToPoint.y + p.nv.z*viewToPoint.z);

        x = VF[0] + viewToPoint.x * t;
        y = VF[1] + viewToPoint.y * t;
        z = VF[2] + viewToPoint.z * t;

        return(new double[] {x, y, z});

    }

    static double[] getDrawP(double x, double y, double z) {
        double drawX = n2.x * x + n2.y * y + n2.z * z;
        double drawY = n1.x * x + n1.y * y + n1.z * z;

        return(new double[] {drawX, drawY});
    }

    static Vector getRVector(double[] VF, double[] VT) {
        double dx = Math.abs(VF[0] - VT[0]);
        double dy = Math.abs(VF[1] - VT[1]);

        double xRot, yRot;

        xRot = dy / (dx + dy);
        yRot = dx / (dx + dy);

        if (VF[1] > VT[1]) {
            xRot = -xRot;
        }
        if (VF[0] < VT[0]) {
            yRot = -yRot;
        }
        Vector v = new Vector(xRot, yRot, 0);
        return (v);

    }

    static void setStartingInfo() {
        viewVector = new Vector(Screen.viewTo[0] - Screen.viewFrom[0], Screen.viewTo[1] - Screen.viewFrom[1], Screen.viewTo[2] - Screen.viewFrom[2]);
        directionVector = new Vector(1, 1, 1);

        planeVect1 = viewVector.crossProduct(directionVector);
        planeVect2 = viewVector.crossProduct(planeVect1);

        p = new Plane(planeVect1, planeVect2, Screen.viewTo);

        rotVector = PointCalc.getRVector(Screen.viewFrom, Screen.viewTo);
        n1 = viewVector.crossProduct(rotVector);
        n2 = viewVector.crossProduct(n1);

        calcFocusPos = PointCalc.calculatePositionP(Screen.viewFrom, Screen.viewTo, Screen.viewTo[0], Screen.viewTo[1], Screen.viewTo[2]);
        calcFocusPos[0] *= Screen.zoom;
        calcFocusPos[1] *= Screen.zoom;
        

    }
}
 