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
}