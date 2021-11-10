public interface Point3Interface {
    //public Point3(double x, double y, double z);//constructor
    //public Point3(Point3 p);// copy constructor
    public double distance(Point3 p); // distance from other point p.
    Boolean equals(Point3 p); // returns true if two points are equal
    public String toString();
}
