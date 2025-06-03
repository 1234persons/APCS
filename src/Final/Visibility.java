package Final;

class Visibility {
    public static boolean isVisible(Vector cameraPos, Vector viewDir, Vector target, double fovDegrees) {
        Vector toCentroid = target.subtract(cameraPos).normalize();
        double dot = viewDir.normalize().dot(toCentroid);
        double angle = Math.acos(dot) * (180.0 / Math.PI);
        return angle <= fovDegrees / 2;
    }
}
