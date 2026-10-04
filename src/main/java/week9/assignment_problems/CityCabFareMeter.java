import java.util.*;

abstract class Cab {
    static final double MIN_FARE = 100;
    abstract double rate();
    double fare(double km) { return Math.max(km * rate(), MIN_FARE); }
}

interface NightService {
    default double nightFare(double fare) { return fare * 1.2; }
}

class Mini extends Cab {
    double rate() { return 10; }
}

class Sedan extends Cab implements NightService {
    double rate() { return 14; }
}

class Suv extends Cab implements NightService {
    double rate() { return 18; }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        while (n-- > 0) {
            String type = sc.next();
            double km = sc.nextDouble();
            boolean night = sc.next().equals("NIGHT");
            Cab c = type.equals("MINI") ? new Mini()
                  : type.equals("SEDAN") ? new Sedan()
                  : new Suv();
            double fare = c.fare(km);
            if (night) {
                if (c instanceof NightService) {
                    fare = ((NightService) c).nightFare(fare);
                } else {
                    System.out.println(type + ": night service not available");
                    continue;
                }
            }
            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}