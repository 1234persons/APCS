package Final;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class BVHBuilder {

    public static BVHNode build(List<DPoly> polygons) {
        if (polygons.size() == 0) {
            return null;
        }
        if (polygons.size() == 1) {
            return new BVHNode(polygons.get(0));
        }

        // Sort polygons by center X
        polygons.sort(Comparator.comparingDouble(BVHBuilder::centerX));

        int mid = polygons.size() / 2;
        List<DPoly> leftPolys = polygons.subList(0, mid);
        List<DPoly> rightPolys = polygons.subList(mid, polygons.size());

        return new BVHNode(build(leftPolys), build(rightPolys));
    }

    private static double centerX(DPoly p) {
        double sum = 0;
        for (Vector v : p.vertices) sum += v.x;
        return sum / p.vertices.size();
    }
}