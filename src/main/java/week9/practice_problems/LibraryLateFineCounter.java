import java.util.*;

abstract class Item {
    String title;
    int daysLate;
    Item(String title, int daysLate) { this.title = title; this.daysLate = daysLate; }
    abstract double fine();
}

class Book extends Item {
    Book(String t, int d) { super(t, d); }
    double fine() { return 2 * daysLate; }
}

class Dvd extends Item {
    Dvd(String t, int d) { super(t, d); }
    double fine() { return Math.min(5 * daysLate, 50); }
}

class Magazine extends Item {
    Magazine(String t, int d) { super(t, d); }
    double fine() { return daysLate; }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        while (n-- > 0) {
            String type = sc.next(), title = sc.next();
            int d = sc.nextInt();
            Item i = type.equals("BOOK") ? new Book(title, d)
                   : type.equals("DVD") ? new Dvd(title, d)
                   : new Magazine(title, d);
            System.out.printf("%s: %.2f%n", i.title, i.fine());
            total += i.fine();
        }
        System.out.printf("Total Fines: %.2f%n", total);
    }
}