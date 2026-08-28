import java.util.Scanner;

public class PrintNumbers {
    
    void printNumbersUpToN(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();

        
        PrintNumbers pn = new PrintNumbers();
        pn.printNumbersUpToN(n);

        sc.close();
    }
}