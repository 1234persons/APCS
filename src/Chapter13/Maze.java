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
                String tempString = readSlide.readLine() + " ";
                for (int col = 0; col < width; col++) {
                    slideData[row][col] = tempString.substring(col, col + 1);
                    visited[row][col] = false;
                    System.out.print(slideData[row][col]);

                }
                System.out.println(); // read past end-of-line characters
            }
            pathFound = findPath(slideData, visited, 1, 1, "");
            if (pathFound) {
                System.out.println("Path Found.");
            }

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

        if (row > 7 || col > 10 || row < 0 || col < 0 || visited[row][col]) {
            return (false);
        }

        solution += "(" + row + ", " + col + ") ";
        visited[row][col] = true;
        

        if (data[row][col].equalsIgnoreCase("X")) {
            return (false);

        }
        if (data[row][col].equals("$")) {
            System.out.println(solution);
            return (true);
        }

        if (findPath(data, visited, row + 1, col, solution) || !visited[row + 1][col]) {
            return (true);
        }

        if (findPath(data, visited, row - 1, col, solution) || !visited[row - 1][col]) {
            return (true);
        }

        if (findPath(data, visited, row, col + 1, solution) || !visited[row][col + 1]) {
            return (true);
        }
        if (findPath(data, visited, row, col - 1, solution) || !visited[row][col - 1]) {
            return (true);
        }
       
        return (false);
    }
}