package Chapter12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Assignment {
    public static void main(String[] args) {
        File textFile = new File("i:\\assignment.txt.txt"); 
        BufferedReader readFile;
        FileReader in;
        String lineOfText;

        try {
            in = new FileReader(textFile);
            readFile = new BufferedReader(in);
            while ((lineOfText = readFile.readLine()) != null ) {
                System.out.println(lineOfText);
            }
            readFile.close();
            in.close();
         } catch (FileNotFoundException e) {
            System.out.println("The file does not exist or could not be found.");
            System.out.println("FileNotFoundException: " + e.getMessage());
         } catch (IOException e) {
            System.out.println("Problem reading file.");
            System.out.println("IOException: " + e.getMessage());
         }

        
    }
    }