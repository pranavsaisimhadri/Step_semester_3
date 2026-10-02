import java.util.*;

abstract class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double bonus();
}

class FullTime extends Employee {
    FullTime(String n, double s) { super(n, s); }
    double bonus() { return salary * 0.10; }
}

class PartTime extends Employee {
    PartTime(String n, double s) { super(n, s); }
    double bonus() { return salary * 0.05; }
}

class Intern extends Employee {
    Intern(String n, double s) { super(n, s); }
    double bonus() { return 2000; }
}

public class FestivalBonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Employee> staff = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();
            switch (type) {
                case "FULLTIME": staff.add(new FullTime(name, salary)); break;
                case "PARTTIME": staff.add(new PartTime(name, salary)); break;
                case "INTERN":   staff.add(new Intern(name, salary));   break;
            }
        }

        double total = 0;
        for (Employee e : staff) {
            double b = e.bonus();
            System.out.printf("%s: %.2f%n", e.name, b);
            total += b;
        }
        System.out.printf("Total Bonus: %.2f%n", total);
    }
}