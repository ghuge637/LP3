package DAA;
//4. Write a program to solve a 0-1 Knapsack problem using dynamic programming or branch and bound strategy.

import java.util.Scanner;

public class KnapsackDP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] value = new int[n + 1];
        int[] weight = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter value and weight for item " + i + ": ");
            value[i] = sc.nextInt();
            weight[i] = sc.nextInt();
        }

        System.out.print("Enter capacity of knapsack: ");
        int capacity = sc.nextInt();

        int[][] dp = new int[n + 1][capacity + 1];

        // Build table dp[][] in bottom-up manner
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weight[i] <= w) {
                    dp[i][w] = Math.max(value[i] + dp[i - 1][w - weight[i]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println("\nMaximum value that can be obtained = " + dp[n][capacity]);
    }
}
