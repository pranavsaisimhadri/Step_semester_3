import java.util.*;

abstract class Vehicle {
    String type;
    int hours;

    Vehicle(String type, int hours) {
        this.type = type;
        this.hours = hours;
    }

    abstract double charge();
}

class Bike extends Vehicle {
    Bike(int h) { super("BIKE", h); }
    double charge() { return 10 * hours; }
}

class Car extends Vehicle {
    Car(int h) { super("CAR", h); }
    double charge() { return 30 + 20 * (hours - 1); }
}

class Truck extends Vehicle {
    Truck(int h) { super("TRUCK", h); }
    double charge() { return Math.max(100, 50 * hours); }
}

public class CampusParkingChargeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            switch (type) {
                case "BIKE":  vehicles.add(new Bike(hours));  break;
                case "CAR":   vehicles.add(new Car(hours));   break;
                case "TRUCK": vehicles.add(new Truck(hours)); break;
            }
        }

        double total = 0;
        for (Vehicle v : vehicles) {
            double c = v.charge();
            System.out.printf("%s: %.2f%n", v.type, c);
            total += c;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}