import java.util.*;

abstract class Delivery {
    String type;
    double weight, distance;

    Delivery(String type, double weight, double distance) {
        this.type = type;
        this.weight = weight;
        this.distance = distance;
    }

    abstract double fee();
}

class StandardDelivery extends Delivery {
    StandardDelivery(double w, double d) { super("STANDARD", w, d); }
    double fee() { return 5 + 0.50 * weight + 0.10 * distance; }
}

class ExpressDelivery extends Delivery {
    ExpressDelivery(double w, double d) { super("EXPRESS", w, d); }
    double fee() { return 15 + 1.00 * weight + 0.20 * distance; }
}

class InternationalDelivery extends Delivery {
    double customsFee;

    InternationalDelivery(double w, double d, double customsFee) {
        super("INTERNATIONAL", w, d);
        this.customsFee = customsFee;
    }

    double fee() { return 25 + 2.00 * weight + 0.50 * distance + customsFee; }
}

public class DeliveryFeeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Delivery> deliveries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            switch (type) {
                case "STANDARD":      deliveries.add(new StandardDelivery(weight, distance)); break;
                case "EXPRESS":       deliveries.add(new ExpressDelivery(weight, distance));  break;
                case "INTERNATIONAL": deliveries.add(new InternationalDelivery(weight, distance, sc.nextDouble())); break;
            }
        }

        double total = 0;
        for (Delivery d : deliveries) {
            double f = d.fee();
            System.out.printf("%s: %.2f%n", d.type, f);
            total += f;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}