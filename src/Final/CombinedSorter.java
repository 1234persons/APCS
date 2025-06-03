package Final;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class CombinedSorter {
    public static List<DPoly> sortVisiblePolygons(Vector cameraPos, Vector viewDir, List<DPoly> polygons, double fovDegrees) {
        return polygons.stream()
            .filter(p -> Visibility.isVisible(cameraPos, viewDir, p.centroid(), fovDegrees))
            .sorted(Comparator.comparingDouble(p -> p.centroid().distanceTo(cameraPos)))
            .collect(Collectors.toList());
    }
}
