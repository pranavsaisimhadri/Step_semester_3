import java.util.*;

abstract class Staff {
    String name;
    Staff(String name) { this.name = name; }
    abstract double pay();
}

class FullTime extends Staff {
    double salary;
    FullTime(String n, double s) { super(n); salary = s; }
    double pay() { return salary; }
}

class Hourly extends Staff {
    double hours, rate;
    Hourly(String n, double h, double r) { super(n); hours = h; rate = r; }
    double pay() {
        return hours <= 40 ? hours * rate : 40 * rate + (hours - 40) * rate * 1.5;
    }
}

class Intern extends Staff {
    double stipend;
    Intern(String n, double s) { super(n); stipend = s; }
    double pay() { return stipend; }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        while (n-- > 0) {
            String type = sc.next(), name = sc.next();
            Staff s;
            if (type.equals("FULLTIME")) s = new FullTime(name, sc.nextDouble());
            else if (type.equals("HOURLY")) s = new Hourly(name, sc.nextDouble(), sc.nextDouble());
            else s = new Intern(name, sc.nextDouble());
            System.out.printf("%s: %.2f%n", s.name, s.pay());
            total += s.pay();
        }
        System.out.printf("Total Payroll: %.2f%n", total);
    }
}