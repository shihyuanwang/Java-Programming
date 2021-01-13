public class Rectangle extends Polygon implements Shape {
    public Rectangle(long a, long b, long c, long d) throws InstantiationException {
        super(a,b,c,d);
    }

    public double getPerimeter(){
        return this.sides[0] +  this.sides[1] +  this.sides[2] + this.sides[3];
    }

    public int sideCount(){
        return 4;
    }

    public double getArea(){
        double a = this.sides[0];
        double b = this.sides[1];
        double c = this.sides[2];
        double d = this.sides[3];
        double area = 0;

        if (a == b && c == d)
            area = a * c;
        else if (a == d && b == c)
            area = a * b;
        else if (a == c && b == d)
            area = a * b;
        return area;
    }

    public static void main(String args[]) throws InstantiationException {

        Rectangle r = new Rectangle(3,3,4,4);
        System.out.println("Rectangle perimeter: " + r.getPerimeter());
        System.out.println("Rectangle area: " + r.getArea());

    }
}
