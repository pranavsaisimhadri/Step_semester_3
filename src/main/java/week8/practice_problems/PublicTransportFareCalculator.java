import java.util.*;

abstract class Journey {
    String type;
    double distance;

    Journey(String type, double distance) {
        this.type = type;
        this.distance = distance;
    }

    abstract double fare();
}

class BusJourney extends Journey {
    BusJourney(double d) { super("BUS", d); }
    double fare() { return Math.min(10, 2 + 0.10 * distance); }
}

class TrainJourney extends Journey {
    TrainJourney(double d) { super("TRAIN", d); }
    double fare() { return 3 + 0.15 * distance; }
}

class MetroJourney extends Journey {
    double peakFactor;

    MetroJourney(double d, double peakFactor) {
        super("METRO", d);
        this.peakFactor = peakFactor;
    }

    double fare() { return (1.50 + 0.20 * distance) * peakFactor; }
}

public class PublicTransportFareCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Journey> journeys = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            switch (type) {
                case "BUS":   journeys.add(new BusJourney(distance));   break;
                case "TRAIN": journeys.add(new TrainJourney(distance)); break;
                case "METRO": journeys.add(new MetroJourney(distance, sc.nextDouble())); break;
            }
        }

        double total = 0;
        for (Journey j : journeys) {
            double f = j.fare();
            System.out.printf("%s: %.2f%n", j.type, f);
            total += f;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}