package Chapter13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Maze {
    public static boolean[][] visited;

    public static void main(String[] args) {
        boolean pathFound = false;
        String[][] slideData;
        try {
            File slideFile = new File("i:\\Maze.txt");
            FileReader in = new FileReader(slideFile);
            BufferedReader readSlide = new BufferedReader(in);
            int length = Integer.parseInt(readSlide.readLine());
            int width = Integer.parseInt(readSlide.readLine());
            visited = new boolean[length][width];
            slideData = new String[length][width];
            for (int row = 0; row < length; row++) {
                for (int col = 0; col < width; col++) {
                    slideData[row][col] = Integer.toString(readSlide.read());

                }
                readSlide.readLine(); // read past end-of-line characters
            }
            pathFound = findPath(slideData, visited, 1, 1, "");

            readSlide.close();
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist or could not be found.");
            System.err.println("FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Problem reading file.");
            System.err.println("IOException: " + e.getMessage());
        }

    }

    public static boolean findPath(String[][] data, boolean[][] visited, int row, int col, String solution) {

        if (row > 7 || col > 7 || row < 0 || col < 0) {
            return (false);
        } else if (visited[row][col]) {
            return (false);

        }

        solution += "(" + row + ", " + col + ") ";

        visited[row][col] = true;

        if (data[row][col].equalsIgnoreCase("X")) {
            return (false);

        } else if (data[row][col].equals("$")) {
            return (true);

        } else if (findPath(data, visited, row + 1, col, solution) && !visited[row + 1][col] ||
                findPath(data, visited, row - 1, col, solution) && !visited[row - 1][col] ||
                findPath(data, visited, row, col + 1, solution) && !visited[row][col + 1] ||
                findPath(data, visited, row, col - 1, solution) && !visited[row][col - 1]) {
                    System.out.println(solution);
            return (true);

        } else {
            return (false);
        }
    }
}