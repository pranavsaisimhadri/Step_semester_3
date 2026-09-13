class PayrollAccount {
    private double basicSalary;
    private double bonus;

    PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: negative salary, setting to 0");
            basicSalary = 0;
        }
        this.basicSalary = basicSalary;
        this.bonus = 0;
    }

    void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid bonus amount");
            return;
        }
        bonus += amount;
        System.out.println("Bonus credited: Rs " + amount);
    }

    void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Invalid tax percent");
            return;
        }
        basicSalary -= basicSalary * percent / 100;
        System.out.println("Tax deducted: " + (int) percent + "%");
    }

    double getNetSalary() {
        return basicSalary + bonus;
    }
}

public class PayrollDemo {
    public static void main(String[] args) {
        PayrollAccount acc = new PayrollAccount(50000);
        acc.creditBonus(5000);
        acc.deductTax(10);
        System.out.println("Net salary: Rs " + acc.getNetSalary());
    }
}