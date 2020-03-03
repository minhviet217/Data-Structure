
/** class Point2D - models a point in 2 dimensions
    author:  Dr. Summa
*/
public class Point2D {

    private double[] coords;

    // default constructor - this constructor calls the other one
    // giving default x and y coordinates of 0.0 , 0.0
    public Point2D() {
        this(0.0,0.0);
    }

    // overloaded constructor taking two doubles as arguments for the
    // x and y coordinates
    public Point2D(double x, double y) {
        coords = new double[2];
        coords[0] = x;
        coords[1] = y;
    }

    // getter or query methods to get the coordinates
    public double getX() {
        return coords[0];
    }

    public double getY() {
        return coords[1];
    }

    public double[] getCoords() {
        return coords;
    }

    public void setX(double newX) {
        coords[0] = newX;
    }

    public void setY(double newY) {
        coords[1] = newY;
    }

    public void setCoords(double[] coords) {
        this.coords = coords;
    }

    public void moveTo(double x, double y) {
        this.coords[0] = x;
        this.coords[1] = y;
    }

    public void moveBy(double dx, double dy) {
        this.coords[0] += dx;
        this.coords[1] += dy;
    }

    // calculates this distance from the current point to another point,
    // accessed by a reference passed in to this method.
    public double distance(Point2D other) {
        double dX = this.getX() - other.getX();
        double dY = this.getY() - other.getY();
        double dist = Math.sqrt( dX * dX + dY * dY );
        return dist;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Point2D) {
            Point2D other = (Point2D)o;
            if ( Math.abs (this.getY() - other.getY()) < 0.01 &&
                 Math.abs (this.getX() - other.getX()) < 0.01     )
                return true;
        }
        return false; // if the thing passed in is not a Point2D, how can they be equal?!?!?
        

    }

    @Override
    public String toString() {
        return "x: " + coords[0] + " y: " + coords[1];
    }


} // end class
