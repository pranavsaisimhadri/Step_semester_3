import java.util.*;

abstract class Appliance {
    static final double RATE = 8;
    double hours;
    Appliance(double hours) { this.hours = hours; }
    abstract double power();
    double units() { return power() * hours / 1000; }
}

interface SaverMode {
    default double saverUnits(double units) { return units * 0.75; }
}

class Fridge extends Appliance {
    Fridge(double h) { super(h); }
    double power() { return 150; }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner(double h) { super(h); }
    double power() { return 1500; }
}

class Tv extends Appliance {
    Tv(double h) { super(h); }
    double power() { return 100; }
}

class Washer extends Appliance implements SaverMode {
    Washer(double h) { super(h); }
    double power() { return 500; }
}

public class ApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        while (n-- > 0) {
            String[] p = sc.nextLine().trim().split("\\s+");
            double h = Double.parseDouble(p[1]);
            boolean saver = p.length > 2;
            Appliance a = p[0].equals("FRIDGE") ? new Fridge(h)
                        : p[0].equals("AC") ? new AirConditioner(h)
                        : p[0].equals("TV") ? new Tv(h)
                        : new Washer(h);
            double units = a.units();
            if (saver) {
                if (a instanceof SaverMode) {
                    units = ((SaverMode) a).saverUnits(units);
                } else {
                    System.out.println(p[0] + ": saver mode not supported");
                    continue;
                }
            }
            double cost = units * Appliance.RATE;
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", p[0], units, cost);
            total += cost;
        }
        System.out.printf("Total Cost: %.2f%n", total);
    }
}