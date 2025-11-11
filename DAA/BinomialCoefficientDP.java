package DAA;
//5. Write a program to generate binomial coefficients using dynamic programming.

import java.util.Scanner;

public class BinomialCoefficientDP {

    // Function to calculate binomial coefficient using DP
    public static int binomialCoeff(int n, int k) {
        int[][] C = new int[n + 1][k + 1];

        // Build Pascal’s Triangle
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || j == i)
                    C[i][j] = 1;
                else
                    C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
            }
        }

        return C[n][k];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        System.out.println("\nBinomial Coefficient C(" + n + ", " + k + ") = " + binomialCoeff(n, k));
    }
}

