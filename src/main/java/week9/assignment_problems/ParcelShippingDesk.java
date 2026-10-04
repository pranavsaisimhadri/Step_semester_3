import java.util.*;

abstract class Parcel {
    double weight, value;
    Parcel(double weight, double value) { this.weight = weight; this.value = value; }
    abstract double charge();
}

interface Insurable {
    default double insurance(double value) { return 0.02 * value; }
}

class Standard extends Parcel {
    Standard(double w, double v) { super(w, v); }
    double charge() { return 40 + 10 * weight; }
}

class Express extends Parcel implements Insurable {
    Express(double w, double v) { super(w, v); }
    double charge() { return 80 + 15 * weight; }
}

class Fragile extends Parcel implements Insurable {
    Fragile(double w, double v) { super(w, v); }
    double charge() { return 40 + 10 * weight + 50; }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grand = 0;
        while (n-- > 0) {
            String type = sc.next();
            double w = sc.nextDouble(), v = sc.nextDouble();
            Parcel p = type.equals("STANDARD") ? new Standard(w, v)
                     : type.equals("EXPRESS") ? new Express(w, v)
                     : new Fragile(w, v);
            double ins = p instanceof Insurable ? ((Insurable) p).insurance(v) : 0;
            double total = p.charge() + ins;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", type, p.charge(), ins, total);
            grand += total;
        }
        System.out.printf("Grand Total: %.2f%n", grand);
    }
}