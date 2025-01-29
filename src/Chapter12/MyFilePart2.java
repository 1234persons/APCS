package Chapter12;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MyFilePart2 {
    public static void main(String[] args) {
        File zzz = new File("zzz.txt"); 
        String userInput;
        Scanner input = new Scanner(System.in);
            
            if (zzz.exists()) {
                System.out.println("File already exists.");
            } else {
                try {
                    zzz.createNewFile();
                    System.out.println("New file created.");
                } catch(IOException e) {
                    System.out.println("File could not be created.");
                    System.out.println("IOException: " + e.getMessage());
                }
            }
        
        do {
        System.out.println("Would you like to keep the file? (y for yes, n for no)");
        userInput = input.nextLine();
        } while (!userInput.equalsIgnoreCase("y") && !userInput.equalsIgnoreCase("n"));

        if (userInput.equalsIgnoreCase("y")) {
            System.out.println("The file has been saved");
        } else {
            zzz.delete();
            System.out.println("The file has been deleted.");
        }
    }
}
