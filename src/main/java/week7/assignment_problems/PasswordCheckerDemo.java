class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int len = password.length();
        if (len < 6) return "Weak";
        else if (len < 10) return "Medium";
        else return "Strong";
    }
}

public class PasswordCheckerDemo {
    public static void main(String[] args) {
        PasswordChecker pc = new PasswordChecker("abcd");
        System.out.println("'abcd' -> " + pc.getStrength());
        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        System.out.println("'abcdefgh' -> " + pc2.getStrength());
        PasswordChecker pc3 = new PasswordChecker("abcdefghijkl");
        System.out.println("'abcdefghijkl' -> " + pc3.getStrength());
    }
}