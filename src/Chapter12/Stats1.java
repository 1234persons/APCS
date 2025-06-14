package Chapter12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Stats1 {

    public static void main(String[] args) {
        File textFile = new File("i:\\test1.dat");
        BufferedReader readFile;
        FileReader in;
        String lineOfText;
        int lowestScore = 100;
        int highestScore = 0;
        int avgScore = 0;
        int numOfData = 0;

        try {
            in = new FileReader(textFile);
            readFile = new BufferedReader(in);
            while ((lineOfText = readFile.readLine()) != null) {
                System.out.println(lineOfText);
                numOfData++;
                if (numOfData % 2 == 0) {
                    
                    avgScore += Integer.parseInt(lineOfText);
                    if (Integer.parseInt(lineOfText) > highestScore) {
                        highestScore = Integer.parseInt(lineOfText);
                    } else if (Integer.parseInt(lineOfText) < lowestScore) {
                        lowestScore = Integer.parseInt(lineOfText);
                    }
                }

            }
            readFile.close();
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist or could not be found.");
            System.out.println("FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Problem reading file.");
            System.out.println("IOException: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Cannot parse a string.");
            System.out.println("NumberFormatException: " + e.getMessage());
        }

        System.out.println("Highest score: " + highestScore);
        System.out.println("Lowest score: " + lowestScore);
        System.out.println("Average score: " + avgScore / (numOfData/2));
    }

}
