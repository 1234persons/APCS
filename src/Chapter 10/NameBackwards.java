import java.util.Scanner;

public class NameBackwards {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name;

        System.out.println("Enter your name: ");
        name = input.nextLine();

        char[] backwardsName = name.toCharArray();

        for (int i = backwardsName.length - 1; i >= 0; i--) {
            System.out.print(backwardsName[i]);
        }

        input.close();
    }
}
