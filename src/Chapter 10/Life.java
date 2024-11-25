import java.util.ArrayList;
import java.util.Scanner;

public class Life {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[][] grid = new String[10][10];
        String userInput;
        ArrayList<Integer> rowCords = new ArrayList<Integer>();
        ArrayList<Integer> colCords = new ArrayList<Integer>();

        do {
            System.out.println("Enter the coordinates you would like to place living cells.");
            System.out.println("row");
            rowCords.add(input.nextInt());

            System.out.println("column");
            colCords.add(input.nextInt());

            System.out.println("Would you like to enter more coordinates? (y for yes)");
            userInput = input.next();
        } while (!userInput.equalsIgnoreCase("n"));

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = "O";
            }
        }

        for (int i = 0; i < rowCords.size(); i++) {
            grid[rowCords.get(i)][colCords.get(i)] = "X";
        }
        // printBoard(grid, 10, 10);

        while (true) {

            printBoard(grid, 10, 10);
            if (lifeOver(grid)) {
                System.out.println("The game is over");
                break;
            }
            setCells(grid);

            System.out.println("Continue? (y for yes, n for no)");
            if (input.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public static void setCells(String[][] grid) {
        int neighborNum = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                // check the cell above
                if (i > 0 && grid[i - 1][j].equals("X")) {
                    neighborNum++;
                }
                // check the cell below
                if (i < grid.length - 1 && grid[i + 1][j].equals("X")) {
                    neighborNum++;
                }
                // check the cell to the left
                if (j > 0 && grid[i][j - 1].equals("X")) {
                    neighborNum++;
                }
                // check the cell to the right
                if (j < grid[1].length - 1 && grid[i][j + 1].equals("X")) {
                    neighborNum++;
                }
                // check the cell above and to the left
                if (i > 0 && j > 0 && grid[i - 1][j - 1].equals("X")) {
                    neighborNum++;
                }
                // check the cell above and to the right
                if (i > 0 && j < grid[1].length - 1 && grid[i - 1][j + 1].equals("X")) {
                    neighborNum++;
                }
                // check the cell below and to the left
                if (i < grid.length - 1 && j > 0 && grid[i + 1][j - 1].equals("X")) {
                    neighborNum++;
                }
                // check the cell below and to the right
                if (i < grid.length - 1 && j < grid[1].length - 1 && grid[i + 1][j + 1].equals("X")) {
                    neighborNum++;
                }

                if (neighborNum == 2 || neighborNum == 3) {
                    grid[i][j] = "X";
                } else {
                    grid[i][j] = "O";
                }

            }

        }
    }

    public static void printBoard(String[][] grid, int width, int length) {

        System.out.println();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();

        }
    }

    public static boolean lifeOver(String[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].equals("X"))
                    return false;
            }
        }
        return true;
    }
}
