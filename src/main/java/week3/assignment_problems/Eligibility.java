import java.util.Scanner;

public class Eligibility{

    void checkVotingEligibility(int age) {
        // Declare boolean with a name
        boolean isEligible = false;

        if (age >= 18) {
            isEligible = true;
            System.out.println("Eligible to vote");
        } else {
            System.out.println("Not eligible");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        Eligibility e = new Eligibility();
        e.checkVotingEligibility(age);

        sc.close();
    }
}