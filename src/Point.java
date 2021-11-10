public final class Point {
    public static void main(String[] args) {

    }
private double x;
    private double y;
    public Point(double x1 , double y1){
        this.x=x1;
        this.y=y1;

    }

    public Point (Point other){
        this.x = other.x;
        this.y = other.y;
    }
public Point(){
        x=0;
        y=0;
}
public double getX(){
        return this.x;
}
public double getY(){
        return this.y;
}
public double distance(Point p){
        double pX = Math.pow(this.x-p.x,2);
        double pY = Math.pow(this.y-p.y,2);
        return Math.sqrt(pX+pY);
}

}
