package Final;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

class BVHCollision {

   public static List<HitResult> collectHits(Ray ray, BVHNode node) {
        List<HitResult> hits = new ArrayList<>();
        collectHitsRecursive(ray, node, hits);
        hits.sort(Comparator.comparingDouble(h -> h.distance));
        return hits;
    }

    private static void collectHitsRecursive(Ray ray, BVHNode node, List<HitResult> hits) {
        if (!node.box.intersects(ray)) return;

        if (node.isLeaf()) {
            List<Vector> verts = node.polygon.vertices;
            for (int i = 1; i < verts.size() - 1; i++) {
                Double t = Ray.rayIntersectTriangle(ray, verts.get(0), verts.get(i), verts.get(i + 1));
                if (t != null) {
                    hits.add(new HitResult(node.polygon, t));
                    break; // only add the first hit per polygon (optional)
                }
            }
        } else {
            collectHitsRecursive(ray, node.left, hits);
            collectHitsRecursive(ray, node.right, hits);
        }
    }

    public static boolean isMovementBlocked(Vector from, Vector to, BVHNode node) {
        return isSegmentBlocked(from, to, node);
    }

    private static boolean isSegmentBlocked(Vector from, Vector to, BVHNode node) {
        AABB moveBox = AABB.fromPoints(from, to);  // Expand to include both points
        if (!node.box.intersects(moveBox)) return false;

        if (node.isLeaf()) {
            List<Vector> verts = node.polygon.vertices;
            for (int i = 1; i < verts.size() - 1; i++) {
                if (Ray.segmentIntersectsTriangle(from, to, verts.get(0), verts.get(i), verts.get(i + 1))) {
                    return true;
                }
            }
            return false;
        }

        return isSegmentBlocked(from, to, node.left) || isSegmentBlocked(from, to, node.right);
    }
}