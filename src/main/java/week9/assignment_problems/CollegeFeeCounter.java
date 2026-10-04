import java.util.*;

abstract class Student {
    String name;
    Student(String name) { this.name = name; }
    abstract double tuition();
    double totalFee() {
        return tuition() + (this instanceof BusUser ? BusUser.TRANSPORT_FEE : 0);
    }
}

interface BusUser {
    double TRANSPORT_FEE = 12000;
}

class DayScholar extends Student implements BusUser {
    DayScholar(String n) { super(n); }
    double tuition() { return 40000; }
}

class Hosteller extends Student {
    Hosteller(String n) { super(n); }
    double tuition() { return 40000 + 60000; }
}

class Scholar extends Student implements BusUser {
    Scholar(String n) { super(n); }
    double tuition() { return 20000; }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        while (n-- > 0) {
            String[] p = sc.nextLine().trim().split(" ", 2);
            Student s = p[0].equals("DAY_SCHOLAR") ? new DayScholar(p[1])
                      : p[0].equals("HOSTELLER") ? new Hosteller(p[1])
                      : new Scholar(p[1]);
            System.out.printf("%s: %.2f%n", s.name, s.totalFee());
            total += s.totalFee();
        }
        System.out.printf("Total Collected: %.2f%n", total);
    }
}