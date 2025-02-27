package Chapter12;


import java.io.File;
import java.util.Scanner;

public class HTMLReader {
    public static void main(String[] args) {
        File file = new File("I:\\june_bugs.html");

        try {
            Scanner scanner = new Scanner(file);

            String contents = "";

            while (scanner.hasNextLine()) {
                contents += scanner.nextLine() + "\n";
            }

            System.out.println(contents.replaceAll("<br>", "\n").replaceAll("<p>", "\n\n").replaceAll("<hr>",
                    "\n----------------------------------------"));

            scanner.close();
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }
}
