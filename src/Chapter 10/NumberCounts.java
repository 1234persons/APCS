import java.util.Scanner;

public class NumberCounts {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int userNum;

        int[] digits = new int[11];

        System.out.println("Enter a number: ");
        userNum = input.nextInt();

        while(userNum >= 1) {
            userNum %= 10;
            digits[userNum] += 1;
            userNum /= 10;
        }

        for(int i = 0; i < digits.length; i++) {
            System.out.println(i + ": " + digits[i]);
        }


    }
}
