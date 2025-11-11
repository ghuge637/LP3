package DAA;
//3. Write a program to solve a fractional Knapsack problem using a greedy method.

import java.util.*;

public class FractionalKnapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        double[] value = new double[n];
        double[] weight = new double[n];
        double[] ratio = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value and weight of item " + (i + 1) + ": ");
            value[i] = sc.nextDouble();
            weight[i] = sc.nextDouble();
            ratio[i] = value[i] / weight[i];
        }

        System.out.print("Enter capacity of knapsack: ");
        double capacity = sc.nextDouble();

        // Sort items by value/weight ratio (descending order)
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ratio[i] < ratio[j]) {
                    double temp;

                    temp = ratio[i]; ratio[i] = ratio[j]; ratio[j] = temp;
                    temp = value[i]; value[i] = value[j]; value[j] = temp;
                    temp = weight[i]; weight[i] = weight[j]; weight[j] = temp;
                }
            }
        }

        double totalValue = 0;

        for (int i = 0; i < n && capacity > 0; i++) {
            if (weight[i] <= capacity) {
                totalValue += value[i];
                capacity -= weight[i];
            } else {
                totalValue += value[i] * (capacity / weight[i]);
                capacity = 0;
            }
        }

        System.out.println("\nMaximum value = " + totalValue);
    }
}
