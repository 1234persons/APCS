import java.util.Scanner;

public class GameOfLight {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int userWidth = 0;
        int userLength;

        do {
        System.out.println("Enter how wide you would like the grid: (3-9)");
        if (input.hasNextInt()) {
            userWidth = input.nextInt();
        }    
        } while (userWidth < 3 || userWidth > 9);

        do {
        System.out.println("Enter the length of the grid: (3-9)");
        userLength = input.nextInt();
        } while (userWidth < 3);

        String[][] grid = new String[userLength][userWidth];

        for (int i = 0; i < userLength; i++) {
            for (int j = 0; j < userWidth; j++) {
                //System.out.println(i + "=" + j);
                grid[i][j]  = "O";
            } 
        }

        for (int i = 0; i < userLength; i++) {
            for (int j = 0; j < userWidth; j++) {
                System.out.print(grid[i][j] + " ");
            } 
            System.out.println();
        }
    }
}
