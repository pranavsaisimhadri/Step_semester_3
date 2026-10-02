import java.time.LocalDate;
import java.util.*;

abstract class Plan {
    String name;
    LocalDate start;

    Plan(String name, LocalDate start) {
        this.name = name;
        this.start = start;
    }

    abstract int validity();

    LocalDate renewalDate() { return start.plusDays(validity()); }
}

class Basic extends Plan {
    Basic(String n, LocalDate d) { super(n, d); }
    int validity() { return 30; }
}

class Standard extends Plan {
    Standard(String n, LocalDate d) { super(n, d); }
    int validity() { return 90; }
}

class Premium extends Plan {
    Premium(String n, LocalDate d) { super(n, d); }
    int validity() { return 365; }
}

public class StreamingPlanRenewalReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Plan> plans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());
            switch (type) {
                case "BASIC":    plans.add(new Basic(name, date));    break;
                case "STANDARD": plans.add(new Standard(name, date)); break;
                case "PREMIUM":  plans.add(new Premium(name, date));  break;
            }
        }

        for (Plan p : plans)
            System.out.println(p.name + ": " + p.renewalDate());
    }
}