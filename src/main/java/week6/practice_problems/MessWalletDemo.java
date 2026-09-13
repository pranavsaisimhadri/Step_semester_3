class MessWallet {
    private double balance;

    MessWallet(double balance) {
        if (balance < 0) {
            System.out.println("Warning: negative balance, setting to 0");
            balance = 0;
        }
        this.balance = balance;
    }

    void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid top-up amount");
            return;
        }
        balance += amount;
        System.out.println("Balance after top-up: " + balance);
    }

    void deduct(double amount) {
        if (amount > balance) {
            System.out.println("Deduct rejected: insufficient balance");
            return;
        }
        balance -= amount;
    }

    double getBalance() {
        return balance;
    }
}

public class MessWalletDemo {
    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}