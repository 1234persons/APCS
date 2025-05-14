package Final;

public class Plane {
    Vector v1, v2, nv;
    double[] p = new double[3];

    public Plane(DPoly dp) {
        p[0] = dp.x[0];
        p[1] = dp.y[1];
        p[2] = dp.z[2];

        v1 = new Vector(dp.x[1] - dp.x[0], dp.y[1] - dp.y[0], dp.z[1] - dp.z[0]);
        v2 = new Vector(dp.x[2] - dp.x[0], dp.y[2] - dp.y[0], dp.z[2] - dp.z[0]);

        nv = v1.crossProduct(v2);
    }

    public Plane(Vector VE1, Vector VE2, double[] z) {
        p = z;
        v1 = VE1;
        v2 = VE2;

        nv = v1.crossProduct(v2);
    }
}
