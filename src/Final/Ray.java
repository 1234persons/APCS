package Final;

import java.util.ArrayList;
import java.util.List;

class Ray {
    Vector origin;
    Vector direction; // Must be normalized

    Ray(Vector origin, Vector direction) {
        this.origin = origin;
        this.direction = direction.normalize();
    }

     // Check if a ray intersects a triangle (Möller–Trumbore algorithm)
    public static boolean rayIntersectsTriangle(Ray ray, Vector v0, Vector v1, Vector v2) {
        final double EPSILON = 1e-6;
        Vector edge1 = v1.subtract(v0);
        Vector edge2 = v2.subtract(v0);
        Vector h = ray.direction.cross(edge2);
        double a = edge1.dot(h);

        if (Math.abs(a) < EPSILON) return false; // Ray is parallel to triangle

        double f = 1.0 / a;
        Vector s = ray.origin.subtract(v0);
        double u = f * s.dot(h);
        if (u < 0.0 || u > 1.0) return false;

        Vector q = s.cross(edge1);
        double v = f * ray.direction.dot(q);
        if (v < 0.0 || u + v > 1.0) return false;

        double t = f * edge2.dot(q);
        return t > EPSILON; // Ray intersection
    }

    public static Double rayIntersectTriangle(Ray ray, Vector v0, Vector v1, Vector v2) {
        final double EPSILON = 1e-6;
        Vector edge1 = v1.subtract(v0);
        Vector edge2 = v2.subtract(v0);
        Vector h = ray.direction.cross(edge2);
        double a = edge1.dot(h);

        if (Math.abs(a) < EPSILON) return null; // Parallel

        double f = 1.0 / a;
        Vector s = ray.origin.subtract(v0);
        double u = f * s.dot(h);
        if (u < 0.0 || u > 1.0) return null;

        Vector q = s.cross(edge1);
        double v = f * ray.direction.dot(q);
        if (v < 0.0 || u + v > 1.0) return null;

        double t = f * edge2.dot(q);
        return (t > EPSILON) ? t : null; // t is distance from ray origin
    }

    // Check if the ray intersects with any face in the polygon list
    public static boolean rayHitsPolygons(Ray ray, ArrayList<DPoly> polygons) {
        for (DPoly poly : polygons) {
            ArrayList<Vector> verts = poly.vertices;

            // Triangulate polygon (fan method)
            for (int i = 1; i < verts.size() - 1; i++) {
                if (rayIntersectsTriangle(ray, verts.get(0), verts.get(i), verts.get(i + 1))) {
                    return true;
                }
            }
        }
        return false;
    }
}
