import java.util.concurrent.TransferQueue;

public class Triangle implements Drawable{
    private  Point c1;
    private Point c2;
    private Point c3;


    public Triangle(Point a, Point b ,Point c){
        this.c1 = a;
        this.c2 = b;
        this.c3 = c;
    }
    public Triangle (Triangle other){
        this.c1 = new Point(other.c1);
        this.c2 = new Point(other.c2);
        this.c3 = new Point(other.c3);
    }


    @Override
    public boolean equals(Drawable d) {
        if (d instanceof Triangle){
            if (((Triangle) d).c1 == this.c1 && ((Triangle) d).c2==this.c2 && ((Triangle) d).c3 == this.c3) return true;
        }
    return false;
    }

    @Override
    public boolean contains(Point p) {
        boolean has_neg , has_pos;
        double d1,d2,d3 ;
        d1 = sign(p, this.c1, this.c2);
        d2 = sign(p, this.c2, this.c3);
        d3 = sign(p, this.c3, this.c1);
        has_neg = (d1 < 0) || (d2 < 0) || (d3 < 0);
        has_pos = (d1 > 0) || (d2 > 0) || (d3 > 0);
        return !(has_neg && has_pos);
    }

    @Override
    public double perimeter() {
        return c1.distance(this.c2)+c2.distance(c3)+c1.distance(c3);
    }

    @Override
    public double area() {
        double s = perimeter()/2;
        double calc = s*(s- c1.distance(c2))*(s- c3.distance(c2))*(s- c1.distance(c3)) ;
        return Math.sqrt(calc);

    }

    @Override
    public void translate(Point p) {

    }
    private double sign (Point p1, Point p2, Point p3)
    {
        return (p1.getX() - p3.getX()) * (p2.getY() - p3.getY()) - (p2.getX() - p3.getX()) * (p1.getY() - p3.getY());
    }

}
