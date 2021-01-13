public class Triangle extends Polygon implements Shape {

    public Triangle(long a, long b, long c) throws InstantiationException {
        super(a,b,c);
    }

    public double getPerimeter(){
        return this.sides[0] +  this.sides[1] +  this.sides[2];
    }

    public int sideCount(){
        return 3;
    }

    public double getArea(){
        double p = this.getPerimeter()/2;
        double a = this.sides[0];
        double b = this.sides[1];
        double c = this.sides[2];
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    public static void main(String args[]) throws InstantiationException {

        Triangle t = new Triangle(4,5,3);
        System.out.println("Triangle perimeter: " + t.getPerimeter());
        System.out.println("Triangle area: " + t.getArea());

    }
}
