package Final;

import java.util.ArrayList;
import java.util.List;

class CollisionDetector {

    public static boolean checkCollision(ArrayList<DPoly> shapeA, ArrayList<DPoly> shapeB) {
        ArrayList<Vector> axes = new ArrayList<>();

        // Get face normals from both shapes
        for (DPoly face : shapeA) {
            axes.add(face.getNormal());
        }
        for (DPoly face : shapeB) {
            axes.add(face.getNormal());
        }

        // Get cross products of edges from both shapes (edge cross edge)
        for (DPoly polyA : shapeA) {
            for (Vector edgeA : polyA.getEdges()) {
                for (DPoly polyB : shapeB) {
                    for (Vector edgeB : polyB.getEdges()) {
                        Vector axis = edgeA.cross(edgeB);
                        if (axis.x != 0 || axis.y != 0 || axis.z != 0) {
                            axes.add(axis.normalize());
                        }
                    }
                }
            }
        }

        // Check for separation on each axis
        for (Vector axis : axes) {
            double[] projectionA = projectShape(shapeA, axis);
            double[] projectionB = projectShape(shapeB, axis);

            if (!overlaps(projectionA, projectionB)) {
                return false; // Found a separating axis
            }
        }

        return true; // No separating axis found, shapes are colliding
    }

    private static double[] projectShape(ArrayList<DPoly> shape, Vector axis) {
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;

        for (DPoly poly : shape) {
            for (Vector vertex : poly.vertices) {
                double projection = vertex.dot(axis);
                if (projection < min) min = projection;
                if (projection > max) max = projection;
            }
        }

        return new double[]{min, max};
    }

    private static boolean overlaps(double[] a, double[] b) {
        return !(a[1] < b[0] || b[1] < a[0]);
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