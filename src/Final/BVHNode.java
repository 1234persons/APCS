package Final;

public class BVHNode {
    AABB box;
    BVHNode left, right;
    DPoly polygon; // Only for leaf nodes

    // Leaf
    BVHNode(DPoly polygon) {
        this.polygon = polygon;
        this.box = AABB.fromPolygon(polygon);
    }

    // Internal
    BVHNode(BVHNode left, BVHNode right) {
        this.left = left;
        this.right = right;
        this.box = AABB.combine(left.box, right.box);
    }

    boolean isLeaf() {
        return polygon != null;
    }
}
