package FindName;

import java.util.Scanner;

public class FindNum {
    public static void main(String[] args) {
        final int MAX = 20;
        int[] numArray = new int[MAX];
        Scanner input = new Scanner(System.in);
        int num, location;

        // Fills array with random numbers

        for(int i = 0; i<numArray.length;i++) {
            numArray[i] = (int)((MAX + 1) * Math.random());
        }

        System.out.println("Enter a number to search the array for: ");
        num = input.nextInt();

        //search for number and notify user of its location
        location = Search.linear(numArray, num);
        if(location == -1) {
            System.out.println("Number not found");
        } else {
            System.out.println("The first occurrence of the number is: " + location);
        }


    }
}
