import java.util.*;

abstract class Booking {
    static final double FEE = 50;
    double km;
    Booking(double km) { this.km = km; }
    abstract double fare();
    double total() { return fare() + FEE; }
}

class Bus extends Booking {
    Bus(double km) { super(km); }
    double fare() { return 2 * km; }
}

class Train extends Booking {
    Train(double km) { super(km); }
    double fare() { return 1.5 * km; }
}

class Flight extends Booking {
    Flight(double km) { super(km); }
    double fare() { return 2500 + 4 * km; }
}

public class TravelBookingFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            String mode = sc.next();
            double km = sc.nextDouble();
            Booking b = mode.equals("BUS") ? new Bus(km)
                      : mode.equals("TRAIN") ? new Train(km)
                      : new Flight(km);
            System.out.printf("%s: %.2f%n", mode, b.total());
        }
    }
}