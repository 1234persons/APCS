package Final;

public class Vector {
    double x, y , z;

    public Vector(double x, double y, double z) {
        
            this.x = x;
            this.y = y;
            this.z = z;
        
    }

    Vector cross(Vector V)
	{
		Vector CrossVector = new Vector(
				y * V.z - z * V.y,
				z * V.x - x * V.z,
				x * V.y - y * V.x);
		return CrossVector;		
	}

    Vector subtract(Vector V)
	{
		Vector returnVec = new Vector(x - V.x, y - V.y, z - V.z);
		return returnVec;		
	}

    Vector add(Vector V)
	{
		Vector returnVec = new Vector(x + V.x, y + V.y, z + V.z);
		return returnVec;		
	}

    double dot(Vector V)
	{
		double product = x*V.x + y * V.y + z * V.z;
		return product;		
	}

    Vector normalize() {
        double len = Math.sqrt(x*x + y*y + z*z);
        return new Vector(x / len, y / len, z / len);
    }

	public double distanceTo(Vector other) {
    double dx = this.x - other.x;
    double dy = this.y - other.y;
    double dz = this.z - other.z;
    return Math.sqrt(dx * dx + dy * dy + dz * dz);
}

}
