package Final;

public class AABB {
    Vector min;
    Vector max;

    AABB(Vector min, Vector max) {
        this.min = min;
        this.max = max;
    }

    boolean intersects(Ray ray) {
        double tMin = (min.x - ray.origin.x) / ray.direction.x;
        double tMax = (max.x - ray.origin.x) / ray.direction.x;

        if (tMin > tMax) { double temp = tMin; tMin = tMax; tMax = temp; }

        double tyMin = (min.y - ray.origin.y) / ray.direction.y;
        double tyMax = (max.y - ray.origin.y) / ray.direction.y;

        if (tyMin > tyMax) { double temp = tyMin; tyMin = tyMax; tyMax = temp; }

        if ((tMin > tyMax) || (tyMin > tMax)) return false;

        if (tyMin > tMin) tMin = tyMin;
        if (tyMax < tMax) tMax = tyMax;

        double tzMin = (min.z - ray.origin.z) / ray.direction.z;
        double tzMax = (max.z - ray.origin.z) / ray.direction.z;

        if (tzMin > tzMax) { double temp = tzMin; tzMin = tzMax; tzMax = temp; }

        return !((tMin > tzMax) || (tzMin > tMax));
    }

    static AABB fromPolygon(DPoly poly) {
        double minX = Double.MAX_VALUE, minY = Double.MAX_VALUE, minZ = Double.MAX_VALUE;
        double maxX = -Double.MAX_VALUE, maxY = -Double.MAX_VALUE, maxZ = -Double.MAX_VALUE;
        for (Vector v : poly.vertices) {
            minX = Math.min(minX, v.x);
            minY = Math.min(minY, v.y);
            minZ = Math.min(minZ, v.z);
            maxX = Math.max(maxX, v.x);
            maxY = Math.max(maxY, v.y);
            maxZ = Math.max(maxZ, v.z);
        }
        return new AABB(new Vector(minX, minY, minZ), new Vector(maxX, maxY, maxZ));
    }

    static AABB combine(AABB a, AABB b) {
        return new AABB(
            new Vector(
                Math.min(a.min.x, b.min.x),
                Math.min(a.min.y, b.min.y),
                Math.min(a.min.z, b.min.z)
            ),
            new Vector (
                Math.max(a.max.x, b.max.x),
                Math.max(a.max.y, b.max.y),
                Math.max(a.max.z, b.max.z)
            )
        );
    }
}

