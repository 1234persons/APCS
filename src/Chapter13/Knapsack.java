package Chapter13;

import java.util.Scanner;

public class Knapsack {
    public static int[] filledSack = new int[6];

    public static void main(String[] args) {
        int[] weights = new int[6];
        int sum = 0;

        for (int i = 0; i < weights.length; i++) {
            weights[i] = (int) (Math.random() * 31) + 1;
            sum += weights[i];
        }

        System.out.println("Weights: ");
        for (int i = 0; i < weights.length; i++) {
            System.out.print(weights[i]);

            if (i < weights.length - 1) {
                System.out.print(", ");
                continue;
            }

            System.out.println();
        }

        int goal = 0;

        Scanner scanner = new Scanner(System.in);

        while (goal <= 0 || goal > sum) {
            System.out.print("Enter a goal between 1 and " + sum + ", or -1 to pick a random number: ");
            goal = scanner.nextInt();

            if (goal == -1) {
                goal = (int) (Math.random() * sum) + 1;
            }
        }

        scanner.close();

        System.out.println("Goal: " + goal);
        System.out.println(loadSack(weights, goal, 0));
        for (int i = 0; i < weights.length; i++) {
            int[] tempArray = weights.clone();
            tempArray[i] = 0;
            if (loadSack(tempArray, goal, 0)) {
                weights[i] = 0;
            }
        }

        for (int i = 0; i < weights.length; i++) {
            if (weights[i] != 0) {
                System.out.print(weights[i] + " ");
            }
        }
    }

    public static boolean loadSack(int[] weights, int goalWeight, int start) {
        if (goalWeight == 0) {
            return (true);
        } else if (start >= weights.length) {
            return (false);
        } else {
            if (loadSack(weights, goalWeight, start + 1)) {
                return (true);
            } else if (loadSack(weights, goalWeight - weights[start], start + 1)) {
                return (true);
            } else {
                return (false);
            }
        }
    }

}
