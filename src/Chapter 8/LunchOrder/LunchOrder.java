import java.util.Scanner;
import java.text.NumberFormat;

public class LunchOrder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        NumberFormat money = NumberFormat.getCurrencyInstance();
        Food burger = new Food(1.85, 9, 33, 1);
        Food salad = new Food(2, 1, 11, 5);
        Food frenchFries = new Food(1.30, 11,  36, 4);
        Food soda = new Food(.95, 0, 38, 0);

        double userInput;
        double price = 0.0;

        System.out.println("Enter the number of hamburgers you would like: ");
        userInput = input.nextInt();
        price += userInput*burger.getPrice();
        System.out.println("Each burger has " + burger.getFat() + " grams of fat, " + burger.getCarbs() + " grams of carbs, and " + burger.getFiber() + " gram of fiber.");

        System.out.println("Enter the number of salads you would like: ");
        userInput = input.nextInt();
        price += userInput*salad.getPrice();
        System.out.println("Each salad has " + salad.getFat() + " grams of fat, " + salad.getCarbs() + " grams of carbs, and " + salad.getFiber() + " gram of fiber.");
        
        System.out.println("Enter the number of french fries you would like: ");
        userInput = input.nextInt();
        price += userInput*frenchFries.getPrice();
        System.out.println("Each order of french fries has " + frenchFries.getFat() + " grams of fat, " + frenchFries.getCarbs() + " grams of carbs, and " + frenchFries.getFiber() + " gram of fiber.");
        
        System.out.println("Enter the number of sodas you would like: ");
        userInput = input.nextInt();
        price += userInput*soda.getPrice();
        System.out.println("Each soda has " + soda.getFat() + " grams of fat, " + soda.getCarbs() + " grams of carbs, and " + soda.getFiber() + " gram of fiber.");

        System.out.println("The total price is " + money.format(price) + ".");
        input.close();
    }
}
