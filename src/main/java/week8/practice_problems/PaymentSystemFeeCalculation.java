import java.util.*;

abstract class Payment {
    String type;
    double amount;

    Payment(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    abstract double finalAmount();
}

class CardPayment extends Payment {
    CardPayment(double a) { super("CARD", a); }
    double finalAmount() { return amount * 1.02; }
}

class WalletPayment extends Payment {
    WalletPayment(double a) { super("WALLET", a); }
    double finalAmount() { return amount * 1.01; }
}

class BankTransferPayment extends Payment {
    BankTransferPayment(double a) { super("BANKTRANSFER", a); }
    double finalAmount() { return amount; }
}

public class PaymentSystemFeeCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Payment> payments = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            switch (type) {
                case "CARD":         payments.add(new CardPayment(amount));         break;
                case "WALLET":       payments.add(new WalletPayment(amount));       break;
                case "BANKTRANSFER": payments.add(new BankTransferPayment(amount)); break;
            }
        }

        double total = 0;
        for (Payment p : payments) {
            double f = p.finalAmount();
            System.out.printf("%s: %.2f%n", p.type, f);
            total += f;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}