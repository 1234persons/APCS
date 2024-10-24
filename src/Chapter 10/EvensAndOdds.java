import java.util.ArrayList;

public class EvensAndOdds {
    public static void main(String[] args) {
        
        ArrayList<Integer> evens = new ArrayList<Integer>();
        ArrayList<Integer> odds = new ArrayList<Integer>();
        int randomNum;

        for (int i = 1; i <= 25; i++) {
            randomNum = (int)((99-1) * Math.random() + 1);

            if (randomNum % 2 == 0) {
                evens.add(randomNum);
            } else {
                odds.add(randomNum);
            }
        }

        System.out.println("Evens: ");
        for (int i = 0; i < evens.size(); i++) {
            System.out.print(evens.get(i) + " ");
        }

        System.out.println("\nOdds: ");
        for (int i = 0; i < odds.size(); i++) {
            System.out.print(odds.get(i) + " ");
        }

    }
}
