package DAA;

import java.util.Scanner;

public class Ass1 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        
        int stepCount = 0;

        if (n <= 1) {
            System.out.println("Fibonacci(" + n + ") = " + n);
            System.out.println("Step Count: " + stepCount);
            return;
        }

        int a = 0, b = 1, c = 0;
        stepCount++; // initialization

        System.out.print("Fibonacci Series: " + a + " " + b);

        for (int i = 2; i <= n; i++) {
            stepCount++; // loop iteration
            c = a + b;
            stepCount++; // addition
            System.out.print(" " + c);
            a = b;
            b = c;
        }

        System.out.println("\nFibonacci(" + n + ") = " + c);
        System.out.println("Step Count (Iterative): " + stepCount);

        sc.close();
    }
}
