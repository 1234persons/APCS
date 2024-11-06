import java.util.Scanner;

public class Life {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[][] grid = new String[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i > 4 && i < 6 && j > 3 && j < 7) {
                    grid[i][j] = "X";
                } else {
                    grid[i][j] = "O";
                }

            }
        }
        // printBoard(grid, 10, 10);

        while (true) {

            printBoard(grid, 10, 10);
            if (lifeOver(grid)) {
                System.out.println("The game is over");
                break;
            }
            setCells(grid);
            input.nextInt();
        }
    }

    public static void setCells(String[][] grid) {
        int neighborNum = 0;


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                // Check cell
                if (grid[i][j].equals("X")) {
                    neighborNum++;
                }

                // Check cell below and to the left
                if (grid[i - 1][j - 1].equals("X") && i - 1 > 0 && i  < 10 && j - 1 > 0 && j < 10) {
                    neighborNum++;
                }

                // Check cell below
                if (grid[i - 1][j].equals("X") && i - 1 > 0 && i  < 10 && j - 1 > 0 && j < 10) {
                    neighborNum++;
                }

                // Check cell below and to the right
                if (grid[i - 1][j + 1].equals("X") && i - 1 > 0 && i < 10 && j - 1 > 0 && j + 1 < 10) {
                    neighborNum++;
                }

                // Check cell to the right
                if (grid[i][j + 1].equals("X") && i > 0 && i < 10 && j > 0 && j + 1 < 10) {
                    neighborNum++;
                }

                // Check cell to the left
                if (grid[i][j - 1].equals("X") && i > 0 && i < 10 && j - 1 > 0 && j < 10) {
                    neighborNum++;
                }

                // Check cell above and to the left
                if (grid[i + 1][j - 1].equals("X") && i > 0 && i + 1 < 10 && j - 1 > 0 && j < 10) {
                    neighborNum++;
                }

                // Check cell above
                if (grid[i + 1][j].equals("X") && i > 0 && i + 1 < 10 && j > 0 && j < 10) {
                    neighborNum++;
                }

                // Check cell above and to the right
                if (grid[i + 1][j + 1].equals("X") && i > 0 && i + 1 < 10 && j > 0 && j + 1 < 10) {
                    neighborNum++;
                }

                if (neighborNum == 2 || neighborNum == 3) {
                    grid[i][j] = "X";
                } else {
                    grid[i][j] = "O";
                }

            }
            System.out.println();

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
                if (grid[i][j].equals("O"))
                    return false;
            }
        }
        return true;
    }
}
