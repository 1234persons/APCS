package Chapter13;

/**
 * Slide class.
 */

import java.io.*;

public class Slide {
    private char COLONY = '*', NON_COLONY = '-';
    private char[][] slideData;

    /**
     * constructor
     * pre: Slide file contains valid slide data in the format:
     * first line: lenght of slide
     * second line: width of slide
     * remaining lines: slide data
     * post: Slide data has been loaded from slide file.
     */
    public Slide(String s) {

        try {
            File slideFile = new File(s);
            FileReader in = new FileReader(slideFile);
            BufferedReader readSlide = new BufferedReader(in);
            int length = Integer.parseInt(readSlide.readLine());
            int width = Integer.parseInt(readSlide.readLine());
            slideData = new char[length][width];
            for (int row = 0; row < length; row++) {
                for (int col = 0; col < width; col++) {
                    slideData[row][col] = (char) readSlide.read();
                }
                readSlide.readLine(); // read past end-of-line characters
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

    /**
     * Determines a colony size
     * pre: none
     * post: All colony cells adjoining and including cell (Row, Col) have
     * been changed to NON_COLONY, and count of these cells is returned.
     */
    private int collectCells(int row, int col) {

        if ((row < 0) || (row >= slideData.length) || (col < 0) || (col >= slideData[0].length)
                || (slideData[row][col] != COLONY)) {
            return (0);
        } else {
            slideData[row][col] = NON_COLONY;
            return (1 +
                    collectCells(row + 1, col) +
                    collectCells(row - 1, col) +
                    collectCells(row, col + 1) +
                    collectCells(row, col - 1) +
                    collectCells(row + 1, col + 1) +
                    collectCells(row - 1, col - 1) +
                    collectCells(row + 1, col - 1) +
                    collectCells(row - 1, col + 1));
        }
    }

    private int collectColoredCells(int row, int col, char color) {

        if ((row < 0) || (row >= slideData.length) || (col < 0) || (col >= slideData[0].length)
                || (slideData[row][col] != color)) {
            return (0);
        } else {
            slideData[row][col] = '0';
            return (1 +
                    collectColoredCells(row + 1, col, color) +
                    collectColoredCells(row - 1, col, color) +
                    collectColoredCells(row, col + 1, color) +
                    collectColoredCells(row, col - 1, color) +
                    collectColoredCells(row + 1, col + 1, color) +
                    collectColoredCells(row - 1, col - 1, color) +
                    collectColoredCells(row + 1, col - 1, color) +
                    collectColoredCells(row - 1, col + 1, color));
        }
    }

    /**
     * Analyzes a slide for colonies and displays colony data
     * pre: none
     * post: Colony data has been displayed.
     */
    public void displayColonies() {
        int count;

        for (int row = 0; row < slideData.length; row++) {
            for (int col = 0; col < slideData[0].length; col++) {
                if (slideData[row][col] == COLONY) {
                    count = collectCells(row, col);
                    System.out.println("Colony at (" + row + "," + col + ") with size " + count);
                }
            }
        }
    }

    /**
     * Analyzes a slide for colonies and displays colony data
     * pre: none
     * post: Colony data has been displayed.
     */
    public void displayColoredColonies() {
        int count;
        char color;

        for (int row = 0; row < slideData.length; row++) {
            for (int col = 0; col < slideData[0].length; col++) {
                if (slideData[row][col] != '0') {
                    color = slideData[row][col];
                    count = collectColoredCells(row, col, color);
                    System.out
                            .println("Colony at (" + row + "," + col + ") with size " + count + " and color " + color);
                }
            }
        }
    }

    /**
     * Displays a slide.
     * pre: none
     * post: Slide data has been displayed.
     */
    public void displaySlide() {

        for (int row = 0; row < slideData.length; row++) {
            for (int col = 0; col < slideData[0].length; col++) {
                System.out.print(slideData[row][col]);
            }
            System.out.println();
        }
    }
}
