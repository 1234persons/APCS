import java.util.Scanner;

public class Coder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String userString;

        System.out.println("Enter the string you would like to encode: ");
        userString = input.nextLine();

        char[] userChars = userString.toCharArray();

        for (int i = 0; i < userChars.length; i++) {
            if (userChars[i] < 121 && userChars[i] > 96) {
            userChars[i] = (char)(userChars[i] + 2);
            } else if (userChars[i] > 120) {
                userChars[i] = (char)(userChars[i] - 24);
            }
        }

        for (int i = 0; i < userChars.length; i++) {
            System.out.print(userChars[i]);
        }

    }
}
