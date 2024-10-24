import java.util.Scanner;

public class GameOfLight {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int userWidth = 0;
        int userLength;
        int row;
        int column;
        int moves = 0;

        do {
            System.out.println("Enter how wide you would like the grid: (3-9)");
            userWidth = input.nextInt();
        } while (userWidth < 3 || userWidth > 9);

        do {
            System.out.println("Enter the length of the grid: (3-9)");
            userLength = input.nextInt();
        } while (userWidth < 3);

        String[][] grid = new String[userLength][userWidth];

        for (int i = 0; i < userLength; i++) {
            for (int j = 0; j < userWidth; j++) {

                grid[i][j] = "O";
            }
        }
        printBoard(grid, userWidth, userLength);

        while (true) {

            do {
                System.out.println("Enter a row to click on: ");
                row = input.nextInt();
            } while (row < 0 || row > userLength);

            do {
                System.out.println("Enter a column to click on: ");
                column = input.nextInt();
            } while (column < 0 || column > userWidth);
            
            setCell(grid, row, column);

            if (row > 0) {
                setCell(grid, row - 1, column);
            }

            if (row < userLength - 1) {
                setCell(grid, row + 1, column);
            }

            if (column > 0) {
                setCell(grid, row, column - 1);
            }

            if (column < userWidth - 1) {
                setCell(grid, row, column + 1);
            }

            printBoard(grid, userWidth, userLength);
            if (gameOver(grid)) {
                System.out.println("You win!");
                System.out.println("It took you " + moves + " moves");
                break;
            } else {
                moves += 1;
            }
        }
        input.close();
    }

    public static void setCell(String[][] grid, int row, int column) {
        if (grid[row][column].equalsIgnoreCase("O")) {
        grid[row][column] = "L";
        } else {
            grid[row][column] = "O";
        }
    }

    public static void printBoard(String[][] board, int width, int length) {

        System.out.print("  ");
        for (int i = 0; i < width; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < width; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();

        }

    }

    public static boolean gameOver(String[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals("O"))
                    return false;
            }
        }
        return true;
    }
}
