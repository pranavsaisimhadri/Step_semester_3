import java.util.*;

abstract class Plot {
    String owner;
    Plot(String owner) { this.owner = owner; }
    abstract double area();
    String shape() { return getClass().getSimpleName().toUpperCase(); }
}

class Circle extends Plot {
    double r;
    Circle(String o, double r) { super(o); this.r = r; }
    double area() { return Math.PI * r * r; }
}

class Rectangle extends Plot {
    double l, w;
    Rectangle(String o, double l, double w) { super(o); this.l = l; this.w = w; }
    double area() { return l * w; }
}

class Triangle extends Plot {
    double b, h;
    Triangle(String o, double b, double h) { super(o); this.b = b; this.h = h; }
    double area() { return 0.5 * b * h; }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        while (n-- > 0) {
            String shape = sc.next(), owner = sc.next();
            Plot p;
            if (shape.equals("CIRCLE")) p = new Circle(owner, sc.nextDouble());
            else if (shape.equals("RECTANGLE")) p = new Rectangle(owner, sc.nextDouble(), sc.nextDouble());
            else p = new Triangle(owner, sc.nextDouble(), sc.nextDouble());
            System.out.printf("%s (%s): %.2f%n", p.owner, p.shape(), p.area());
            total += p.area();
        }
        System.out.printf("Total Area: %.2f%n", total);
    }
}