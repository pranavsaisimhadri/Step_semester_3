import java.util.*;

abstract class Connection {
    double units;
    Connection(double units) { this.units = units; }
    abstract double bill();
}

class Home extends Connection {
    Home(double u) { super(u); }
    double bill() { return units <= 100 ? units * 5 : 500 + (units - 100) * 7; }
}

class Shop extends Connection {
    Shop(double u) { super(u); }
    double bill() { return units * 8 + 100; }
}

class Factory extends Connection {
    Factory(double u) { super(u); }
    double bill() { return Math.max(units * 6, 1000); }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        while (n-- > 0) {
            String type = sc.next();
            double u = sc.nextDouble();
            Connection c = type.equals("HOME") ? new Home(u)
                         : type.equals("SHOP") ? new Shop(u)
                         : new Factory(u);
            System.out.printf("%s: %.2f%n", type, c.bill());
            total += c.bill();
        }
        System.out.printf("Total: %.2f%n", total);
    }
}