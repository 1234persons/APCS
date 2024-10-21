import java.util.Scanner;

public class NameBackwards {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name;
        String backwardsName = "";

        System.out.println("Enter your name: ");
        name = input.next();

        for (int i = name.length() - 1; i >= 0; i--) {
            backwardsName += name.charAt(i);
        }

        System.out.println(backwardsName);
        input.close();
    }
}
