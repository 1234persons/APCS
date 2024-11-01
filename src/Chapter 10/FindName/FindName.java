package FindName;

import java.util.Scanner;

public class FindName {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int MAX = 5;
        String[] nameList = new String[MAX];
        String nameToFind;
        int location;

        for(int i = 0; i < nameList.length; i++) {
            System.out.println("Enter a name to add to the list: ");
            nameList[i] = input.next();
        }

        System.out.println("Enter the name you are looking for: ");
        nameToFind = input.next();

        location = Search.linear(nameList, nameToFind);

        if(location == -1) {
            System.out.println("The string is not contained in the array.");
        } else {
            System.out.println("The string's location in the array is: " + location);
        }
        input.close();
    }
}
