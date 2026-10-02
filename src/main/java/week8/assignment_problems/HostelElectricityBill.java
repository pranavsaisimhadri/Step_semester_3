import java.util.*;

abstract class Room {
    String type;
    int units;

    Room(String type, int units) {
        this.type = type;
        this.units = units;
    }

    abstract double bill();
}

class SingleRoom extends Room {
    SingleRoom(int u) { super("SINGLE", u); }
    double bill() { return 8.0 * units; }
}

class SharedRoom extends Room {
    int occupants;

    SharedRoom(int u, int occupants) {
        super("SHARED", u);
        this.occupants = occupants;
    }

    double bill() { return 6.0 * units / occupants; }
}

class ACRoom extends Room {
    ACRoom(int u) { super("AC", u); }
    double bill() { return 10.0 * units + 200; }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            switch (type) {
                case "SINGLE": rooms.add(new SingleRoom(units)); break;
                case "SHARED": rooms.add(new SharedRoom(units, sc.nextInt())); break;
                case "AC":     rooms.add(new ACRoom(units));     break;
            }
        }

        double total = 0;
        for (Room r : rooms) {
            double b = r.bill();
            System.out.printf("%s: %.2f%n", r.type, b);
            total += b;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}