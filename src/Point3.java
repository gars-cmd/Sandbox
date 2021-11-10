public class Point3 implements Point3Interface {
    public static void main(String[] args) {

    }
    private double x;
    private double y;
    private double z;

    public Point3(double x, double y, double z){
        this.x = x;
        this.y =y;
        this.z = z;
    }

    public Point3(Point3 other){
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
    }


    @Override
    public double distance(Point3 p) {
        double pX =Math.pow(this.x-p.x , 2);
        double pY =Math.pow(this.y-p.y , 2);
        double pZ = Math.pow(this.z-p.z ,2);
        return Math.sqrt(pX+pY+pZ);
    }

    @Override
    public Boolean equals(Point3 p) {
        return ( (p.x==this.x) && (p.y==this.y) && (p.z==this.z));
    }
}
