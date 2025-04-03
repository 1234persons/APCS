package Chapter13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Maze {
    public static String solution = "";
    public static void main(String[] args) {
        boolean pathFound = false;
        String[][] slideData;
        try {
             File slideFile = new File("i:\\Maze.txt");
             FileReader in = new FileReader(slideFile);
             BufferedReader readSlide = new BufferedReader(in);
             int length = Integer.parseInt(readSlide.readLine());
             int width = Integer.parseInt(readSlide.readLine());
             slideData = new String[length][width];
             for (int row = 0; row < length; row++) {
                 for (int col = 0; col < width; col++) {
                     slideData[row][col] =  String.valueOf(readSlide.read());
                     
                 }
                 readSlide.readLine(); // read past end-of-line characters
             }
             pathFound = findPath(slideData, 1, 1);
             
             readSlide.close();
             in.close();
         } catch (FileNotFoundException e) {
             System.out.println("File does not exist or could not be found.");
             System.err.println("FileNotFoundException: " + e.getMessage());
         } catch (IOException e) {
             System.out.println("Problem reading file.");
             System.err.println("IOException: " + e.getMessage());
         }

        System.out.println(solution);  
    }

    public static boolean findPath(String[][] data, int row, int col) {
        String originalSolution = solution;
        solution += ", (" + row + ", " + col + ")";
        if (data[row][col].equals("$")) {;
            return(true);
        } else if (data[row][col].equals("X")) {
            solution = originalSolution;
            return(false);
        // } else if (findPath(data, row + 1, col) ||
        //            findPath(data, row - 1, col) ||
        //            findPath(data, row, col + 1) ||
        //            findPath(data, row, col - 1)) {
        //     return(true);
        // } 
        } else {
            return(false);
        }
    }
}