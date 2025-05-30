package Final;

public class HitResult {
    DPoly polygon;
    double distance;

    public double getDistance() {
        return this.distance;
    }

    HitResult(DPoly polygon, double distance) {
        this.polygon = polygon;
        this.distance = distance;
    }

    
}
