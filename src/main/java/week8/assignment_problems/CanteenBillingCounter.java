import java.util.*;

abstract class Customer {
    String type;
    double amount;

    Customer(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    abstract double finalAmount();
}

class Student extends Customer {
    Student(double a) { super("STUDENT", a); }
    double finalAmount() { return amount * 0.90; }
}

class Staff extends Customer {
    Staff(double a) { super("STAFF", a); }
    double finalAmount() { return amount * 0.95; }
}

class Guest extends Customer {
    Guest(double a) { super("GUEST", a); }
    double finalAmount() { return amount + 10; }
}

public class CanteenBillingCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Customer> bills = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            switch (type) {
                case "STUDENT": bills.add(new Student(amount)); break;
                case "STAFF":   bills.add(new Staff(amount));   break;
                case "GUEST":   bills.add(new Guest(amount));   break;
            }
        }

        double total = 0;
        for (Customer c : bills) {
            double f = c.finalAmount();
            System.out.printf("%s: %.2f%n", c.type, f);
            total += f;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}