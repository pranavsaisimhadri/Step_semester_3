import java.util.*;

abstract class Ticket {
    static final double FEE = 20;
    int count;
    Ticket(int count) { this.count = count; }
    abstract double price();
    double amount() { return count * (price() + FEE); }
}

class Regular extends Ticket {
    Regular(int c) { super(c); }
    double price() { return 150; }
}

class Premium extends Ticket {
    Premium(int c) { super(c); }
    double price() { return 250; }
}

class Recliner extends Ticket {
    Recliner(int c) { super(c); }
    double price() { return 400; }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        while (n-- > 0) {
            String seat = sc.next();
            int count = sc.nextInt();
            Ticket t = seat.equals("REGULAR") ? new Regular(count)
                     : seat.equals("PREMIUM") ? new Premium(count)
                     : new Recliner(count);
            System.out.printf("%s: %.2f%n", seat, t.amount());
            total += t.amount();
        }
        System.out.printf("Total: %.2f%n", total);
    }
}