import java.util.Scanner;
import java.text.NumberFormat;

public class MySavings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        NumberFormat money = NumberFormat.getCurrencyInstance();
        PiggyBank bank = new PiggyBank();

        int userInput;
        double withdrawal;

        do {

        System.out.println("1. Show total in bank.");
        System.out.println("2. Add a penny.");
        System.out.println("3. Add a nickel.");
        System.out.println("4. Add a dime.");
        System.out.println("5. Add a quarter.");
        System.out.println("6. Take money out of the bank.");
        System.out.println("Enter 0 to quit.");
        System.out.println("Enter your choice: ");
        do {
        userInput = input.nextInt();
        } while (userInput > 6 || userInput < 1);
            if(userInput == 0) break;

        switch(userInput) {
            case 1: System.out.println("You have " + money.format(bank.getMoney())); break;

            case 2:
                System.out.println("Enter the amount of pennies you'd like to add: ");
                bank.addPennies(input.nextInt()); break;
            case 3:
                System.out.println("Enter the amount of nickels you'd like to add: ");
                bank.addNickels(input.nextInt()); break;
            case 4:
                System.out.println("Enter the amount of dimes you'd like to add: ");
                bank.addDimes(input.nextInt()); break;
            case 5:
                System.out.println("Enter the amount of quarters you'd like to add: ");
                bank.addQuarters(input.nextInt()); break;
            case 6:
                System.out.println("Enter the amount you'd like to withdrawal: ");
                withdrawal = input.nextDouble();
                if (withdrawal > bank.getMoney()) {
                    System.out.println("You don't have that much money.");
                } else {
                    bank.withdrawal(withdrawal);
                }
                break;

        }

        System.out.println("Would you like to enter 1 to continue or enter 0 to quit?");
        userInput = input.nextInt();
    } while (userInput != 0);

    input.close();

    }
}
