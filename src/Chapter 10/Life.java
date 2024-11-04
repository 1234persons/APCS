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
        //printBoard(grid, 10, 10);

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
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (grid[i][j].equals("X")) {
                    if (grid[i - 1][j].equals("X")) {
                        neighborNum++;
                    }
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
