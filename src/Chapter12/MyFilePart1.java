package Chapter12;

import java.io.File;
import java.util.Scanner;

public class MyFilePart1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String userInput;

        System.out.println("Enter the name of the file you would like to create: ");
        userInput = input.nextLine();

        if (userInput.contains("\\")) {
            userInput.replace("\\", "\\\\");
        }
        
        File textFile = new File(userInput);
        if (textFile.exists()) {
            System.out.println("The file exists.");
        } else {
            System.out.println("The file doesn't exist.");
        }
    }
}
